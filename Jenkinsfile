pipeline {
    agent any
    environment {
      ANDROID_HOME = "C:/Users/GLI/AppData/Local/Android/Sdk"
    }
    stages {
        stage('Compile') {
            steps {
                sh './gradlew compileDebugSources'
            }
        }
    }
}