def call (String name, String name2, containername) {
    script {
         sh """
            docker build -t ${name} -f ${name2} .
            """
    }
}
