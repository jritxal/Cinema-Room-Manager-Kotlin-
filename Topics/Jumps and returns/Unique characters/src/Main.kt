fun main() {
    // put your code here
    val word = readln()
    var result = word
    val list = mutableListOf<Char>()
    for (i in 0 until word.length) {
        if (!list.contains(word[i])) {
            list.add(word[i])
        } else {
            result = result.replace(word[i].toString(), "")
        }
    }
    println(result.length)
}