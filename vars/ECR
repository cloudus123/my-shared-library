def call(String name, String pathtodocker, String contextPath) {
    script {
        sh """
            docker build -t ${name} -f ${pathtodocker} ${contextPath}
            
        """        
    }
}
