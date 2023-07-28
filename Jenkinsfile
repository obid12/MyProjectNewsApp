pipeline {
    agent {
      label 'android-agent'
    }

    tools {
       jdk 'JAVA_HOME'
    }
    environment {
      ANDROID_HOME = "C:/Users/GLI/AppData/Local/Android/Sdk"
    }
    stages {
        stage('Compile') {
            steps {
                sh 'java -version'
                sh 'chmod +x ./gradlew'
                sh './gradlew compileDebugSources'
            }
        }
    }
}