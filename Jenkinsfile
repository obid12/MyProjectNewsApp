pipeline {
    agent any

    environment {
      ANDROID_HOME = 'C:\\Users\\GLI\\AppData\\Local\\Android\\Sdk'
      GRADLE_HOME = "C:\\Users\\GLI\\.gradle"
      LOCATION_PROJECT = 'C:\\Users\\GLI\\.jenkins\\workspace\\coba dulu@script\\bd0e1eaec9584cb3fa627ed4dd4a6ef24c80866f884b4e89cd45f9e4e5ae105f'
    }
    stages {
//         stage('Delete Workspace Dir') {
//             steps {
//                script {
//                    try {
//                        deleteDir()
//                    } catch (Exception e) {
//                        echo "Error deleting workspace: ${e.message}"
//                    }
//                }
//             }
//         }

        stage('Clean Gradle Cache') {
            steps {
                script {
                  dir(env.LOCATION_PROJECT) {
                    bat "gradlew.bat clean"
                  }
                }
            }
        }

        stage('Compile') {
            steps {
                dir(env.LOCATION_PROJECT) {
                    bat "bundle exec fastlane build"
                }
            }
        }

        stage('Testing') {
            steps {
                dir(env.LOCATION_PROJECT) {
                    bat "bundle exec fastlane test"
                }
            }
        }

        stage('Firebase') {
            steps {
                dir(env.LOCATION_PROJECT) {
                    bat "bundle exec fastlane beta"
                }
            }
        }
    }
}

