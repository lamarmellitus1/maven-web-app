def buildjar(){
    echo 'building a jar file'
    sh 'mvn clean package'
}

def buildImage(){
   echo 'building a docker image & deploying to dockerhub'
                    withCredentials([string(credentialsId: 'passwds', variable: 'dockerwd')]){
                     sh 'docker build -t mellitus/java-web-app:latest . '
                    sh "docker login -u mellitus -p ${dockerwd}"
                    sh "docker push mellitus/java-web-app:latest"
                    }
                    
}

def deploy(){
   def dockercmd= 'docker run -d -p 8080:8080 mellitus/java-web-app:latest'
    sshagent(['vm-instance']) {
    sh "ssh -o StrictHostKeyChecking=no mellitus@35.232.39.197  ${dockercmd}"
}
}
return this
