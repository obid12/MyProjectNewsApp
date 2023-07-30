pipeline {
    agent any

    tools {
       jdk 'JAVA_HOME'
    }
    environment {
      ANDROID_HOME = 'C:\\Users\\GLI\\AppData\\Local\\Android\\Sdk'
    }
    stages {
        stage('Clean Gradle Cache') {
                    steps {
                        script {
                            // Clear Gradle cache
                            deleteDir()
                        }
                    }
                }
        stage('Compile') {
            steps {
                bat 'java -version'
                bat 'gradlew.bat clean assembleDebug'
            }
        }
    }
}

// pipeline {
//     agent any
//
//     stages {
//         stage('Hello') {
//             steps {
//                 echo 'Hello World'
//             }
//         }
//     }
// }

