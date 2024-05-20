pipeline{
       agent any
      
    stages{
        stage("git clone"){
            steps{
                echo "========executing A========"
            } 
        }
        stage("deploying to env"){
           
            steps{
               scripts{
                env.ENV=input message: 'deploy to any enviroment', ok: 'Done', parameters: [ choice(name: "ENV", choices: ["dev", "staging", "prod"], description: "")]
                echo "deploying to ${ENV}"
               } 
            }
        }
        
    }
    
}
