pipeline {
    agent any
  
    tools {
        maven "maven-first"
    }

    environment {
        BASE_PATH = "/var/jenkins_home/workspace"
        PRAGMA_USER = "Gustavo Arellano"
        PROJECT_ROOT = "li-control-service"
        EMAIL_ADDRESS = "arellano.gustavo@gmail.com"
    }
    
    stages {
        stage('Obten Código Fuente') {
            steps {
                git branch: 'develop',
                    credentialsId: '31459996-f0c4-44ad-a81b-f8d9b3e81e72',
                    url: 'https://github.com/kebblar/li-control-service.git'
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

def qualityGateValidation(qg) {
    if(qg.status != 'OK') {
        emailext body: "El código no pasó el Quality Gate de Sonar", subject: "Error Sonar Scan, Quality Gate", to: "${EMAIL_ADDRESS}"
        return true
    }
    emailext body: "El código ha pasado el Quality Gate de sonar exitosamente", subject: "Info -Ejecucion pipeline", to: "${EMAIL_ADDRESS}"
    return false
}

