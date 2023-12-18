const val G = 9.8
fun main() {
    // write your code here
    val density = readln().toDouble()
    val height = readln().toDouble()

    println(density * G * height)
}