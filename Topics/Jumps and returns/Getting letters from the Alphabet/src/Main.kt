fun main() {
    // put your code here
    val letter = readln()

    for (i in 'a'.code..letter[0].code) {
        if (i == letter[0].code) return
        print(i.toChar())
    }
}