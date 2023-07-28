pipeline {
    agent any

    tools {
       JAVA_HOME = "C:/tools/jdk/jdk-11.0.20.8-hotspot"
    }
    environment {
      ANDROID_HOME = "C:/Users/GLI/AppData/Local/Android/Sdk"
    }
    stages {
        stage('Compile') {
            steps {
                sh 'chmod +x ./gradlew'
                sh './gradlew compileDebugSources'
            }
        }
    }
}