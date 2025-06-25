pipeline {
    agent any

    tools {
        maven "Maven"
        allure "Allure"
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

        stage('Restore Allure History') {
            steps {
                script {
                    if (fileExists('target/allure-report/history')) {
                        bat 'xcopy /E /Y /I target\\allure-report\\history target\\allure-results\\history'
                    }
                }
            }
        }

        stage('Generate Allure Report') {
            steps {
                bat 'allure generate target/allure-results --clean -o target/allure-report'
            }
        }

        stage('Publish Allure Report in Jenkins') {
            steps {
                allure([
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'target/allure-results']]
                ])
            }
        }

        stage('Generate Other Reports') {
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

            archiveArtifacts artifacts: 'target/allure-report/history/**', allowEmptyArchive: true
        }
    }
}
