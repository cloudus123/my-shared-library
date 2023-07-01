import org.jenkinsci.plugins.workflow.cps.CpsScript
import org.jenkinsci.plugins.docker.workflow.*

class DockerBuilder implements Serializable {
    CpsScript script
    Docker docker

    DockerBuilder(CpsScript script) {
        this.script = script
        this.docker = new Docker(script)
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
