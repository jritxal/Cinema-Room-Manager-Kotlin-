fun main() {
    // put your code here
    val input = readln()
    for (c in input) {
        if (c.isDigit()) {
            println(c)
            return
        }
    }
}