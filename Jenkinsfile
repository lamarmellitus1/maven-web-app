pipeline{
    agent any
    tools{
        maven 'm3'
    }
    stages{
        stage('maven build'){
            steps{
                sh 'mvn clean package'
            }
        }
        stage('deploying to dockerhub'){
            steps{
                    echo 'building a docker image & deploying to dockerhub'
                      withCredentials([string(credentialsId: 'Dockerhub', variable: 'passwd')]) {
                    sh 'docker build -t mellitus/java-web-app: latest . '
                    sh "docker login -u mellitus -p ${passwd}"
                    sh "docker push mellitus/java-web-app: latest"

            }
        }
    }
}
