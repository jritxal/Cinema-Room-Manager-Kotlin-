fun main() {
    // write your code here
    val size = readln().toInt()
    val integers = mutableListOf<Int>()
    for (index in 0 until size) {
        integers.add(readln().toInt())
    }
    val numbersToFind = readln().split(" ")
    if (integers.contains(numbersToFind[0].toInt()) &&
        integers.contains(numbersToFind[1].toInt())
    ) {
        println("YES")
    } else {
        println("NO")
    }
}