fun main() {
    // put your code here
    val a = readln().toInt()
    val b = readln().toInt()

    try {
        println(a / b)
    } catch (e: ArithmeticException) {
        println("Division by zero, please fix the second argument!")
    }
}