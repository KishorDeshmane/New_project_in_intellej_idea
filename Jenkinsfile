pipeline {
    agent any

    tools {
        maven "Maven"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/KishorDeshmane/New_project_in_intellej_idea.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat "mvn clean test"
            }
        }

        stage('Generate Reports') {
            steps {
                junit '**/target/surefire-reports/TEST-*.xml'
                cucumber 'target/cucumber-reports/*.json'
            }
        }
    }

    post {
        always {
            echo "Sending email notification..."
            emailext(
                subject: "Jenkins Build Status: ${currentBuild.currentResult} - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
                Build **${currentBuild.currentResult}**: The Jenkins job '${env.JOB_NAME}' build #${env.BUILD_NUMBER}.

                * Job URL: ${env.BUILD_URL}
                * Console Output: ${env.BUILD_URL}console

                Regards,  
                Jenkins CI/CD
                """,
                to: "kishor.deshmane@iffort.com"
            )
        }
    }
}
