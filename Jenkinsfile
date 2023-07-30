pipeline {
    agent any

    tools {
       jdk 'JAVA_HOME'
    }
    environment {
      ANDROID_HOME = 'C:\\Users\\GLI\\AppData\\Local\\Android\\Sdk'
      GRADLE_HOME = "C:\\Users\\GLI\\.gradle"
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
                dir('C:\\Users\\GLI\\.jenkins\\workspace\\coba dulu@script\\bd0e1eaec9584cb3fa627ed4dd4a6ef24c80866f884b4e89cd45f9e4e5ae105f') {
                    // Run Gradle Wrapper
                    bat 'gradlew.bat clean assembleDebug'
                }
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

