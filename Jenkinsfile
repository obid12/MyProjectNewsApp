pipeline {
    agent any

    tools {
       jdk 'JAVA_HOME'
    }
    environment {
      ANDROID_HOME = 'C:\\Users\\GLI\\AppData\\Local\\Android\\Sdk'
    }
    stages {
        stage('Compile') {
            steps {
                bat 'java -version'
                bat './gradlew compileDebugSources'
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

