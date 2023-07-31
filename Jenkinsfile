pipeline {
    agent any

    environment {
      ANDROID_HOME = 'C:\\Users\\GLI\\AppData\\Local\\Android\\Sdk'
      GRADLE_HOME = "C:\\Users\\GLI\\.gradle"
      LOCATION_PROJECT = 'C:\\Users\\GLI\\.jenkins\\workspace\\coba dulu@script\\bd0e1eaec9584cb3fa627ed4dd4a6ef24c80866f884b4e89cd45f9e4e5ae105f'
      AVD_NAME = 'Pixel_2_API_33' // Replace with the actual AVD name you have created
      EMULATOR_OPTIONS = '-no-audio -no-window -no-boot-anim'
    }
    stages {
        stage('Delete Workspace Dir') {
            steps {
               script {
                   try {
                       deleteDir()
                       echo "${env.ANDROID_HOME}\\emulator\\emulator.exe"
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

        stage('Start Emulator') {
            steps {
                script {
                  bat "${env.ANDROID_HOME}\\emulator\\emulator.exe -avd ${env.AVD_NAME} ${env.EMULATOR_OPTIONS}"
                  bat 'ping -n 10 127.0.0.1 > nul'
                }
            }
        }

        stage('Unit Tests') {
            steps {
                dir(env.LOCATION_PROJECT) {
                    bat "gradlew.bat test"
                }
            }
        }

        post {
            always {
                bat 'taskkill /F /IM emulator.exe /T'
            }
        }
    }
}

