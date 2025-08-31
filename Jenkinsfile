pipeline {
  agent { label 'chrome' }   // make sure this node has Chrome installed

  tools {
    jdk 'temurin-17'         // Configure in Manage Jenkins → Global Tool Configuration
    maven 'maven-3.9'        // ditto (name must match what you configure)
  }

  options {
    timestamps()
    ansiColor('xterm')
  }

  environment {
    MAVEN_OPTS = '-Dmaven.test.failure.ignore=false'
  }

  stages {
    stage('Checkout') {
      steps {
        cleanWs()
        checkout scm
      }
    }

    stage('Build & Test') {
      steps {
        sh 'mvn -B -e -Dheadless=true clean test'   // Windows agent? use: bat 'mvn -B -e -Dheadless=true clean test'
      }
    }

    stage('Publish Reports') {
      steps {
        // JUnit (from surefire)
        junit allowEmptyResults: false, testResults: 'target/surefire-reports/*.xml'

        // Publish TestNG HTML report
        publishHTML(target: [
          reportDir: 'test-output',
          reportFiles: 'index.html',
          reportName: 'TestNG Report',
          keepAll: true,
          alwaysLinkToLastBuild: true
        ])
      }
    }
  }

  post {
    always {
      archiveArtifacts artifacts: 'target/surefire-reports/**, test-output/**', fingerprint: true
    }
    failure {
      echo 'Build failed. Check console log and reports.'
    }
  }
}
