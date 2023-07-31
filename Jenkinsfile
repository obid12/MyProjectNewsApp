pipeline {
    agent any

    environment {
      ANDROID_HOME = 'C:\\Users\\GLI\\AppData\\Local\\Android\\Sdk'
      GRADLE_HOME = "C:\\Users\\GLI\\.gradle"
//       LOCATION_PROJECT = "C:\\Users\\GLI\\.jenkins\\workspace\\coba dulu@script\\bd0e1eaec9584cb3fa627ed4dd4a6ef24c80866f884b4e89cd45f9e4e5ae105f"
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

        stage('Checkout') {
            steps {
                bat 'https://github.com/obid12/MyProjectNewsApp.git
            }
        }

        stage('Clean Gradle Cache') {
            steps {
                script {
                  bat "gradlew.bat clean"
                }
            }
        }
//         stage('Compile & Build APK') {
//             steps {
// //                 dir('@{LOCATION_PROJECT}') {
// //                     // Run Gradle Wrapper
// //                     bat 'java -version'
// //                     bat 'gradlew.bat clean assembleDebug'
// //                 }
//                 bat 'java -version'
//                 bat 'gradlew.bat clean assembleDebug'
//             }
// //
// //             post {
// //                 success {
// //                     // Archive the APK file as a build artifact
// //                     archiveArtifacts artifacts: 'C:\\Users\\GLI\\.jenkins\\workspace\\coba dulu@script\\bd0e1eaec9584cb3fa627ed4dd4a6ef24c80866f884b4e89cd45f9e4e5ae105f\\app\\build\\outputs\\apk\\debug\\*.apk', fingerprint: true
// //                 }
// //             }
//         }
//
//         stage('Unit Tests') {
//             steps {
// //                 dir('@{LOCATION_PROJECT}') {
// //                     bat "gradlew.bat test"
// //                 }
//
//                 bat "gradlew.bat test"
//             }
//         }
    }
}

