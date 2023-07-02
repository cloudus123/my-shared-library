def call(String name, String name2, String containername, String port = "", String port1 = "", String mountvolume = "") {
    script {
        def dockerRunCommand = "docker run -d --name ${containername}"
        
        if (port && port1) {
            dockerRunCommand += " -p ${port}:${port1}"
        }
        if (mountvolume) {
            dockerRunCommand += " -v ${mountvolume}"
        }
        dockerRunCommand += " ${name}"
        
        sh """
            docker build -t ${name} -f ${name2} .
            ${dockerRunCommand}
        """
    }
}
