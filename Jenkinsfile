pipeline {
    agent any

    environment {
      LANG = 'en_US.UTF-8'
      LC_ALL = 'en_US.UTF-8'
      ANDROID_HOME = 'C:\\Users\\GLI\\AppData\\Local\\Android\\Sdk'
      GRADLE_HOME = "C:\\Users\\GLI\\.gradle"
      LOCATION_PROJECT = 'C:\\Users\\GLI\\.jenkins\\workspace\\coba dulu@script\\bd0e1eaec9584cb3fa627ed4dd4a6ef24c80866f884b4e89cd45f9e4e5ae105f'
    }
    stages {
        stage('Configure Environment') {
            steps {
                bat"bundle exec fastlane add_plugin android_versioning"
            }
        }

//         stage('Clean Gradle Cache') {
//             steps {
//                 script {
//                   dir(env.LOCATION_PROJECT) {
//                     bat "gradlew.bat clean"
//                   }
//                 }
//             }
//         }
//
//         stage('Compile') {
//             steps {
//                 dir(env.LOCATION_PROJECT) {
//                     bat "bundle exec fastlane build"
//                 }
//             }
//         }
//
//         stage('Testing') {
//             steps {
//                 dir(env.LOCATION_PROJECT) {
//                     bat "bundle exec fastlane test"
//                 }
//             }
//         }
        stage('name') {
            steps {
                dir(env.LOCATION_PROJECT) {
                    bat "bundle exec fastlane set_version_name"
                }
            }
        }


        stage('code') {
            steps {
                dir(env.LOCATION_PROJECT) {
                    bat "bundle exec fastlane set_version_code"
                }
            }
        }

        stage('Firebase') {
            steps {
                dir(env.LOCATION_PROJECT) {
                    bat "bundle exec fastlane deploy_to_firebase"
                }
            }
        }
    }
}

