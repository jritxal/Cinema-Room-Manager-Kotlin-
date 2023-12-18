fun main() {
    // write your code here
    val maxN = readln().toInt()
    var sum = 0;

    for (i in 1..maxN) {
        sum += readln().toInt()
    }

    println(sum)
}