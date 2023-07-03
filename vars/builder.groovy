def call(String imageName, String containerName, String dockerfilePath, String contextPath) {
	stages {
	  stage("Build Docker Image") {
		steps {
        		sh "docker build -t ${imageName} -f ${dockerfilePath} ${contextPath}"
		}
    	 }
    	   stage("Run container image") {
		steps {
        		sh "docker run -d --name ${containerName} ${imageName}"
		}
    	   }
	}
}
