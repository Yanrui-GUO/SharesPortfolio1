// Powered by Infostretch

timestamps {

node () {

	stage ('Projet1 - Checkout') {
 	 checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '88f4da1f-91a4-41fc-b1d8-8bd1e8b6bd26', url: 'https://github.com/DavidNavarreICS/SharesPortfolio1.git']]])
	}
	stage ('Projet1 - Build') {
 			// Ant build step
	withAnt(installation: 'Ant10.5', jdk: 'jdk8') {
 			if(isUnix()) {
 				sh "ant clean jar checkstyle findbugs sonar "
			} else {
 				bat "ant clean jar checkstyle findbugs sonar "
			}
recordIssues(tools: [checkStyle(), findBugs(useRankAsPriority: true)])
junit allowEmptyResults: true, testResults: '${basedir}/build/report/*.xml'
 		}
	}
}
}