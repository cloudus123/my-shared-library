def call (String name, String name2) {
    stage ("build") {
        steps {
            echo "HI, ${name} and ${name2}"
        }
    }
}
