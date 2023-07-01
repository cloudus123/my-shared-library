def call (String name, String name2) {
    script {
         docker build -t {name} {name2} .
    }
}
