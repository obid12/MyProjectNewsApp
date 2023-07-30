pipeline {
    agent any

//     tools {
//        jdk 'JAVA_HOME'
//     }
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

                dir('C:\\Users\\GLI\\.jenkins\\workspace\\coba dulu@script\\bd0e1eaec9584cb3fa627ed4dd4a6ef24c80866f884b4e89cd45f9e4e5ae105f') {
                    // Run Gradle Wrapper
                    bat 'java -version'
                    bat 'gradlew.bat clean assembleDebug'
                }
            }
        }

         stage('Build APK') {
            steps {
                // Set the path to the Gradle executable
                def gradleBat = "${env.GRADLE_HOME}/bin/gradle.bat"

                // Run the Gradle build to create the APK
                // Adjust the command based on your project's setup and flavor (e.g., assembleDebug, assembleRelease)
                bat "${gradleBat} assembleDebug"
            }

            post {
                success {
                    // Archive the APK file as a build artifact
                    archiveArtifacts artifacts: 'app/build/outputs/apk/debug/*.apk', fingerprint: true
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

