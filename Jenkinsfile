def gv
pipeline{
    agent any
    stages{
        stage("init"){
            steps{
           script{
             gv=load "script.groovy"
           }
            }
           
        }
        stage("buildjar"){
            steps{
               script{
                    gv.buildjar()
            }
           
        }
        stage("buildImage"){
            steps{
               script{
               gv.buildImage()
               }
            }
           
        }
        stage('deploy to vm machine'){
        steps{
            script{
                gv.deploy()
            }
        }
        }
    }
   
}
