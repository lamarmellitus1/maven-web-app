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
        stage("deploy"){
        steps{
            script{
                gv.deploy()
            }
        }
        }
      }
   
}
