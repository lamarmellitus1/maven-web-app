pipeline{
       agent any
    stages{
        stage("git clone"){
            steps{
                echo "========executing A========"
            } 
        }
        stage("deploying to env"){
            input{
                message "select the enviroment to deploy to"
                ok "Done"
                parameters{
                    choice(name: "ENV", choices: ["dev", "staging", "prod"], description: "")
                }
            }
            steps{
               script{
                echo "deploying to ${ENV}"
               } 
            }
        }
        
    }
    
}
