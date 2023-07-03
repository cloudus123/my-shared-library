def call(String name, String pathtodocker, String contextPath, String containername, String port = "", String containerport = "") {
    script {
        def dockerRunCommand = "docker run -d --name ${containername}"
        
        if (port && port1) {
            dockerRunCommand += " -p ${port}:${port1}"
        }
        dockerRunCommand += " ${name}"
        sh """
            docker build -t ${name} -f ${pathtodocker} ${contextPath}
            ${dockerRunCommand}
        """
        
    }
}
