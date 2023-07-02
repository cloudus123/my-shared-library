def call(String name, String pathtodocker, String contextPath, String containername, String port = "", String port1 = "", String mountvolume = "") {
    script {
        
        sh """
            docker build -t ${name} -f ${pathtodocker} ${contextPath}
            ${dockerRunCommand}
        """
        def dockerRunCommand = "docker run -d --name ${containername}"
        
        if (port && port1) {
            dockerRunCommand += " -p ${port}:${port1}"
        }
        if (mountvolume) {
            dockerRunCommand += " -v ${mountvolume}"
        }
        dockerRunCommand += " ${name}"
    }
}
