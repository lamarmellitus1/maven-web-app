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
        stage("buildImage"){
            steps{
               script{
                    gv.buildjar()
            }
           
        }
        stage("C"){
            steps{
               script{
               gv.buildImage()
               }
            }
           
        }
        stage(){
        steps{
            script{
                gv.deploy()
            }
        }
        }
    }
   
}
