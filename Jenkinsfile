// pipeline {
//     agent {
//       label 'android'
//     }
//
//     tools {
//        jdk 'JAVA_HOME'
//     }
//     environment {
//       ANDROID_HOME = "C:/Users/GLI/AppData/Local/Android/Sdk"
//     }
//     stages {
//         stage('Compile') {
//             steps {
//                 sh 'java -version'
//                 sh 'chmod +x ./gradlew'
//                 sh './gradlew compileDebugSources'
//             }
//         }
//     }
// }

pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
    }
}

