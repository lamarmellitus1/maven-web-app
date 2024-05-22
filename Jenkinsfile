pipeline{
    agent any
    stages{
        stage("A"){
            steps{
                echo "========executing A========"
            }
           
        }
        stage("B"){
            steps{
                echo "========executing B========"
            }
           
        }
        stage("C"){
            steps{
               script{
                def dockercmd= 'docker run -d -p 80:80 nginx'
                sshagent(['vm-instance']) {
                    sh "ssh -o StrictHostKeyChecking=no mellitus@35.232.39.197  ${dockercmd}"
}
               }
            }
           
        }
    }
   
}
