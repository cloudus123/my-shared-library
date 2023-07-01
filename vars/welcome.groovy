def call (String name, String name2) {
    stage ("build") {
        script {
            echo "HI, ${name} and ${name2}"
        }
    }
}
