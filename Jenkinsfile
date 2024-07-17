pipeline {
    agent any

    environment {
        DOCKER = '/usr/local/bin/docker'
        DOCKER_HOME = '/Applications/Docker.app/Contents/Resources/bin' // Adjust this path accordingly for macOS
        PATH = "${DOCKER_HOME}:${PATH}"
    }

    tools{
        maven 'MAVEN 3.9.8'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/thechamplive/jenkins-pipeline']])
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image'){
            steps{
                 script{
                     sh '${DOCKER} build -t thechamplive/jenkins-pipeline-docker .'
                 }
            }
        }
        stage('Push Docker Image'){
            steps{
                 script{
                    withCredentials([string(credentialsId: 'docker-hub-pwd', variable: 'dockerhubpwd')]) {
                        sh '${DOCKER} login -u thechamplive -p ${dockerhubpwd}'
                    }
                    sh '${DOCKER} push thechamplive/jenkins-pipeline-docker'
                 }
            }
        }
        }
}