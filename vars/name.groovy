def call(String name, String pathtodocker, String contextPath, String containername, String port = "", String containerport = "") {
    script {
        def dockerRunCommand = "docker run -d --name ${containername}"
        
        if (port && containerport) {
            dockerRunCommand += " -p ${port}:${containerport}"
        }
        dockerRunCommand += " ${name}"
        sh """
            docker build -t ${name} -f ${pathtodocker} ${contextPath}
            ${dockerRunCommand}
        """
        
    }
}
