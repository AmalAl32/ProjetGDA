pipeline {
  agent any
  stages {
    stage('Recupérer code source') {
      steps {
        git 'https://github.com/AmalAl32/ProjetGDA.git'
      }
    }
    stage('built maven') {
      steps {
        sh 'mvn clean install'
      }
    }
  }
}