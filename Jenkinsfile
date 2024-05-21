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
                script{
                    echo 'building a docker image & deploying to dockerhub'
                    withCredentials([gitUsernamePassword(credentialsId: 'dockerhub', , variable: 'passwd')])
                    sh 'docker build -t mellitus/java-web-app: latest . '
                    sh 'echo $passwd | docker login -u $dockerhub --password-stdin'
                    sh 'docker push mellitus/java-web-app:latest'
                }
 {
   
}
            }
        }
    }
}
