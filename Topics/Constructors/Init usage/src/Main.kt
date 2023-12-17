const val MIN_TIME = -128
const val MAX_TIME = 127
fun main() {
    val timerValue = readLine()!!.toInt()
    val timer = ByteTimer(timerValue)
    println(timer.time)
}

class ByteTimer(var time: Int) {
    init {
        when {
            time < MIN_TIME -> time = MIN_TIME
            time > MAX_TIME -> time = MAX_TIME
        }
    }
}