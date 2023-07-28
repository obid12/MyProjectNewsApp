pipeline {
    agent any

    tools {
       jdk 'oracle-9.0.4'
    }
    environment {
      ANDROID_HOME = "C:/Users/GLI/AppData/Local/Android/Sdk"
    }
    stages {
        stage('Compile') {
            steps {
                sh '''
                env | grep -e PATH -e JAVA_HOME
                which java
                java -version'''
                sh 'chmod +x ./gradlew'
                sh './gradlew compileDebugSources'
            }
        }
    }
}