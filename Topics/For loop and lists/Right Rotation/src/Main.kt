fun main() {
    // write your code here
    val size = readln().toInt()
    val list = mutableListOf<String>()
    for (index in 0 until size) {
        list.add(readln())
    }
    val rotateTo = readln().toInt()
    val actualRotation = rotateTo % size

    for (times in 0 until actualRotation) {
        rotate(list)
    }
    println(list.joinToString(" "))
}

fun rotate(list: MutableList<String>) {
    val last = list.last()
    for (index in list.size - 1 downTo 1) {
        list[index] = list[index - 1]
    }
    list[0] = last;
}