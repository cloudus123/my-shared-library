def call(String name, String pathtodocker, String contextPath, String ECRurl) {
    script {
        sh """
            docker build -t ${name} -f ${pathtodocker} ${contextPath}
            docker tag ${name} ${ECRurl}/${name}
            docker push ${ECRurl}/${name}
        """        
    }
}
