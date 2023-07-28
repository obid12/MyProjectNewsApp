pipeline {
    agent any

    tools {
            jdk 'JBR17'
        }
    environment {
      ANDROID_HOME = "C:/Users/GLI/AppData/Local/Android/Sdk"
    }
    stages {
        stage('Compile') {
            steps {
                sh 'chmod +x ./gradlew'
                sh './gradlew compileDebugSources'
                sh 'java -version'
            }
        }
    }
}