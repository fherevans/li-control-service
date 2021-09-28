pipeline {
    agent { docker { image 'maven:3.3.3' } }
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
