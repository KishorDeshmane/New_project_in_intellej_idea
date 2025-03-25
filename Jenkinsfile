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
                bat "mvn clean test"  // Run TestNG tests (including Cucumber)
            }
        }

        stage('Generate Reports') {
            steps {
                // Collect TestNG and Cucumber reports
                junit '**/target/surefire-reports/TEST-*.xml'
                cucumber 'target/cucumber-reports/*.json'
            }
        }
    }

    post {
        success {
            echo 'Build & Tests Passed! ✅'
        }
        failure {
            echo 'Build/Test Failed! ❌ Fix the issues!'
        }
    }
}
