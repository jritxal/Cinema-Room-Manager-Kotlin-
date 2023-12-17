fun main() {
    try {
    // write your code here, do not touch the lines above
        val string = "Hello"
        val n = string.toInt()

    // do not touch the lines below    
    } catch(e: RuntimeException) {
        println("Well")
    } catch (e: Exception) {
        println("Wrong")
    }
}