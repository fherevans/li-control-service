pipeline {
    agent any
    environment {
        BASE_PATH = "/var/jenkins_home/workspace"
        PRAGMA_USER = "Gustavo Arellano"
        PROJECT_ROOT = "li-control-service"
        EMAIL_ADDRESS = "arellano.gustavo@gmail.com"
    }
    stages {
        
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
        stage("Corre Escaneo de Sonar") {
            environment {
                scannerHome = tool 'sonar-scanner'
            }
            
            steps {
                withSonarQubeEnv('sonar-scanner') {
                    sh "${scannerHome}/bin/sonar-scanner \
                    -Dsonar.projectKey=li-control-service \
                    -Dsonar.projectName=li-control-service \
                    -Dsonar.projectVersion=0.${BUILD_NUMBER} \
                    -Dsonar.sources=${BASE_PATH}/${PROJECT_ROOT}/src/main/java \
                    -Dsonar.test.sources=${BASE_PATH}/${PROJECT_ROOT}/src/test/java \
                    -Dsonar.language=java \
                    -Dsonar.java.binaries=${BASE_PATH}/${PROJECT_ROOT}/target/classes \
                    -Dsonar.java.test.binaries=${BASE_PATH}/${PROJECT_ROOT}/target/test-classes \
                    -Dsonar.junit.reportPaths=${BASE_PATH}/${PROJECT_ROOT}/target/jacoco.exec \
                    -Dsonar.coverage.jacoco.xmlReportPaths=${BASE_PATH}/${PROJECT_ROOT}/target/site/jacoco/jacoco.xml \
                    -Dsonar.java.coveragePlugin=jacoco"
                }
                timeout(time: 2, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: qualityGateValidation(waitForQualityGate())
                }                
            }
            
        }
    }
}
