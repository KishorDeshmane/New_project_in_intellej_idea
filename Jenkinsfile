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
                subject: "Jenkins Build Status",
                body: "hello",
                to: "kishordeshmane321@gmail.com"
            )
        }
    }
}
