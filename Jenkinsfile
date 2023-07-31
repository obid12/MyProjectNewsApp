pipeline {
    agent any

    environment {
      ANDROID_HOME = 'C:\\Users\\GLI\\AppData\\Local\\Android\\Sdk'
      GRADLE_HOME = "C:\\Users\\GLI\\.gradle"
      LOCATION_PROJECT = 'C:\\Users\\GLI\\.jenkins\\workspace\\coba dulu@script\\bd0e1eaec9584cb3fa627ed4dd4a6ef24c80866f884b4e89cd45f9e4e5ae105f'
    }
    stages {
        stage('Delete Workspace Dir') {
            steps {
               script {
                   try {
                       deleteDir()
                   } catch (Exception e) {
                       echo "Error deleting workspace: ${e.message}"
                   }
               }
            }
        }

        stage('Clean Gradle Cache') {
            steps {
                script {
                  dir(env.LOCATION_PROJECT) {
                    bat "gradlew.bat clean"
                  }
                }
            }
        }

        stage('Start Emulator') {
            steps {
                // Start the Android emulator
                androidEmulator(
                    avdName: 'Pixel_2_API_33', // Specify the name of the Android Virtual Device (AVD)
                    osVersion: '33', // Specify the Android OS version
                    screenDensity: '420', // Specify the screen density
                    screenResolution: '1080x1920', // Specify the screen resolution
                    emulatorOptions: '-no-window' // Additional emulator options, if needed
                )
            }
        }

        stage('Compile & Build APK') {
            steps {
                dir(env.LOCATION_PROJECT) {
                    bat 'java -version'
                    bat 'gradlew.bat clean assembleDebug'
                }
            }
//             post {
//                 success {
//                     // Archive the APK file as a build artifact
//                     archiveArtifacts artifacts: 'C:\\Users\\GLI\\.jenkins\\workspace\\coba dulu@script\\bd0e1eaec9584cb3fa627ed4dd4a6ef24c80866f884b4e89cd45f9e4e5ae105f\\app\\build\\outputs\\apk\\debug\\*.apk', fingerprint: true
//                 }
//             }
        }
        stage('Unit Tests') {
            steps {
                dir(env.LOCATION_PROJECT) {
                    bat "gradlew.bat test"
                }
            }
        }
    }
}

