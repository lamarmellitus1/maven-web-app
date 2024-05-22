pipeline{
    agent{
        label "node"
    }
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
                def dockercmd= 'docker run -d -p 8080:8080 melltus/javawebapp:latest'
                sshagent(['vm-instance']) {
                    ssh "ssh -o StrictHostKeyChecking=no mellitus@35.232.39.197  ${dockercmd}"
}
               }
            }
           
        }
    }
   
}
