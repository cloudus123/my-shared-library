def call (String name, String name2, String containername) {
    script {
         sh """
            docker build -t ${name} -f ${name2} .
            docker run -d --name ${containername} ${name}
            """
    }
}
