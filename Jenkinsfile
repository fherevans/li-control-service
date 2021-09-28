pipeline {
    agent any
    stages {
        stage('mvn version') {
            steps {
                sh 'mvn --version'
            }
        }
        stage('construyendo') {
            steps {
                echo 'Construyendo.....'
            }
        }
        stage('tests') {
            steps {
                echo 'corriendo tests...'
            }
        }
    }
}
