pipeline {
    agent any
    environment {
        // Define Docker Hub credentials
        DOCKERHUB_CREDENTIALS_ID = 'dockerHUB'
        DOCKERHUB_REPO = 'mellitus/gke'
        // Define GCP credentials
        GCP_CREDENTIALS_ID = 'gke-json'
        GCP_PROJECT = 'basic-curve-423914-d9'
        GKE_CLUSTER = 'eks-cluster'
        GKE_ZONE = 'us-central1-c'
        K8S_NAMESPACE = 'default'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout code from version control
                echo "checkout scm"
            }
        }

        stage('Build Maven Project') {
            steps {
                // Run Maven build
                sh 'mvn clean install'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Build Docker image
                    def imageTag = "latest"
                    sh "docker build -t ${DOCKERHUB_REPO}:${imageTag} ."
                }
            }
        }

        stage('Tag Docker Image') {
            steps {
                script {
                    // Tag Docker image
                    def imageTag = "latest"
                    sh "docker tag ${DOCKERHUB_REPO}:${imageTag} ${DOCKERHUB_REPO}:${env.BUILD_ID}"
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    // Login to Docker Hub
                    withCredentials([usernamePassword(credentialsId: DOCKERHUB_CREDENTIALS_ID, passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'mellitus')]) {
                        sh "echo $DOCKERHUB_PASSWORD | docker login -u $mellitus --password-stdin"
                    }

                    // Push Docker images to Docker Hub
                    def imageTag = "latest"
                    sh "docker push ${DOCKERHUB_REPO}:${imageTag}"
                    sh "docker push ${DOCKERHUB_REPO}:${env.BUILD_ID}"
                }
            }
        }

        stage('Deploy to GKE') {
            steps {
                script {
                    // Authenticate with GCP
                    withCredentials([file(credentialsId: GCP_CREDENTIALS_ID, variable: 'GOOGLE_APPLICATION_CREDENTIALS')]) {
                        sh "gcloud auth activate-service-account --key-file=${GOOGLE_APPLICATION_CREDENTIALS}"
                        sh "gcloud config set project ${GCP_PROJECT}"
                        sh "gcloud container clusters get-credentials ${GKE_CLUSTER} --zone ${GKE_ZONE}"
                    }

                    // Deploy to GKE
                    sh "kubectl set image deployment/deploy mavenpod=${DOCKERHUB_REPO}:${env.BUILD_ID} --record -n ${K8S_NAMESPACE}"
                }
            }
        }
    }

    post {
        always {
            // Cleanup
            cleanWs()
        }
    }
}
