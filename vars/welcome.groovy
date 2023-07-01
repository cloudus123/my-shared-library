def call (String name, String name2) {
    script {
         echo "build -t ${name} ${name2} ."
    }
}
