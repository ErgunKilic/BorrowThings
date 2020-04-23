pipeline {
    agent any
    environment {
        SPRING_DATASOURCE_URL='jdbc:mysql://157.26.83.85:3306/spring_db_2020'
        SPRING_DATASOURCE_USERNAME  = credentials('SPRING_DATASOURCE_USERNAME')
        SPRING_DATASOURCE_PASSWORD = credentials('SPRING_DATASOURCE_PASSWORD')
        JDC_ENV_TEST = credentials('JDC_ENV_TEST')
    }
    stages {
        stage('Build') {
            agent {
              docker {
               image 'maven:3.6.3-jdk-11-slim'
              }
            }
            steps {
			sh '(cd ./BorrowThings/; mvn clean package)'
		stash name: "app", includes: "**"
            }
        }
	    stage('QualityTest') {
            agent {
              docker {
               image 'maven:3.6.3-jdk-11-slim'
              }
            }
            steps {
		    unstash "app"
			sh '(cd ./BorrowThings/; mvn clean test)'
		    sh '(cd ./BorrowThings/; mvn sonar:sonar -Dsonar.projectKey=ErgunKilic_BorrowThings -Dsonar.organization=ergunkilic -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=e6471701f468743ac8a3a5df6bf848e040e728d6)'
	        }
        }
        stage('IntegrationTest'){
            agent{
                docker{
                image 'lucienmoor/katalon-for-jenkins:latest'
                args '-p 8888:8080'
                }
            }
            steps {
                unstash "app"
                sh 'java -jar ./BorrowThings/target/BorrowThings-0.0.1-SNAPSHOT.jar >/dev/null 2>&1 &'
                sh 'sleep 30'
                sh 'chmod +x ./runTest.sh'
                sh './runTest.sh'
                cleanWs()
            }
        }
    }
    post {
        always {
            echo 'always clean up'
            deleteDir()
        }
    }
    options {
        disableConcurrentBuilds()
    }
}

