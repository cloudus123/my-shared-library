import org.jenkinsci.plugins.docker.workflow.*
import org.jenkinsci.plugins.workflow.cps.CpsScript

def call(script) {
    // Create the image to use in this build instead of using a parameter
    def docker = new Docker(script)
    def image = docker.image("praqma/native-scons")
    return new Builder(script, image)
}

class Builder {
    CpsScript script
    Docker docker
    def image

    Builder(CpsScript script, Docker image) {
        this.script = script
        this.docker = docker
        this.image = image
    }

    def buildAndRun(String imageName, String containerName, String dockerfilePath, String contextPath, String port = '', String containerPort = '') {
        script.stage("Build Docker Image") {
            script.sh "docker build -t ${imageName} -f ${dockerfilePath} ${contextPath}"
        }
        script.stage("Run container image") {
            def publishOption = port ? "-p ${port}:${containerPort}" : ""
            script.sh "docker run -d ${publishOption} --name ${containerName} ${imageName}"
        }
    }
}
