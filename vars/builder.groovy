def image_build_and_run(String imageName, String containerName, String dockerfilePath, String contextPath, String port = '', String containerPort = '') {
    stage("Build Docker Image") {
		steps {
        sh "docker build -t ${imageName} -f ${dockerfilePath} ${contextPath}"
		}
    }
    stage("Run container image") {
		steps {
        def publishOption = port ? "-p ${port}:${containerPort}" : ""
        sh "docker run -d ${publishOption} --name ${containerName} ${imageName}"
		}
    }
}
