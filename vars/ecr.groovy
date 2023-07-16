def call(String name, String pathtodocker, String contextPath, String ECRurl) {
    script {
        sh """
            docker build -t ${name} -f ${pathtodocker} ${contextPath}
            docker tag ${name} ${ECRurl}/${name}
	    image_name= $(docker image ls | grep -i ${ECRurl}/${name} | awk '{print$3}')
	    trivy_output=$(trivy image "$image_name" --format json)
	    critical_vulns=$(echo "$trivy_output" | grep -i "CRITICAL: 0" | wc -l)
			
	    if [[ $critical_vulns -eq 0 ]]; then
	    	echo "No critical vulnerabilities found. Proceeding with Docker push."
	    	docker push ${ECRurl}/${name}
	    else
	    	echo "Critical vulnerabilities found. Aborting Docker push."
	    	exit 1
	    fi
           
        """        
    }
}
