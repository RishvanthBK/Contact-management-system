pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/RishvanthBK/Contact-management-system.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t contact-system:latest .'
            }
        }

        stage('Run Container') {
            steps {
                bat """
                docker rm -f contact-container || exit 0
                docker run -d --name contact-container contact-system:latest
                """
            }
        }

        stage('Kubernetes Deploy') {
            steps {
                bat """
                kubectl apply -f deployment.yaml
                kubectl apply -f service.yaml
                kubectl get pods
                kubectl get services
                """
            }
        }
    }

    post {
        success {
            echo 'Build + Kubernetes Deploy Successful ✅'
        }
        failure {
            echo 'Build Failed ❌'
        }
    }
}