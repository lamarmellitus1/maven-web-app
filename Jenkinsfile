def gv
pipeline{
    agent any
    tools{
        maven 'm3'
     
    }
    stages{
        stage('init'){
            steps{
                script{
                    gv = load "script.groovy"
                }
            }
        }
        stage('maven build'){
            steps{
                script{
                    gv.buildjar()
            }
        }
        }
        stage('deploying to dockerhub'){
            steps{
                script{
                    gv.buildImage()
                }
 
            }
        }
        stage('deploy'){
            steps{
             script{
                  gv.deploy()
            }
        }
        }
    }
}
