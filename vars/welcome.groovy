def call(String name, String name2, String containername, String port = "", String port = "", String mountvolume = "") {
    script {
        def dockerRunCommand = "docker run -d --name ${containername}"
        
        if (port) {
            dockerRunCommand += " -p ${port}:${port}"
        }
        if (mountvolume) {
            dockerRunCommand += "-v ${mountvolume}"
        }
        dockerRunCommand += " ${name}"
        
        sh """
            docker build -t ${name} -f ${name2} .
            ${dockerRunCommand}
        """
    }
}
