def call (String name, String name2) {
    script {
         sh """
            docker build -t ${name} -f ${name2} .
            """
    }
}
