pipeline {
  agent {
    docker {
      image 'maven:3.8.4-openjdk-17'
    }
  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean install'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }
  }
}