def call (java.lang.String name, java.lang.String name2, java.lang.String containername) {
    script {
         sh "docker build -t ${name} -f ${name2} ."
    }
}
