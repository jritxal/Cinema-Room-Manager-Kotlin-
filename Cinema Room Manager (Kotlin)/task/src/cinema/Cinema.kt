package cinema

fun main() {
    // write your code here
    println("Enter the number of rows:")
    val numRows = readln().toInt()
    println("Enter the number of seats in each row:")
    val numSeats = readln().toInt()

    val cinema = mutableListOf<MutableList<String>>()
    for (i in 0..numRows) {
        cinema.add(mutableListOf())
    }

    for (i in 0..numRows) {
        for (j in 0..numSeats) {
            when {
                (j == 0 && i == 0) -> cinema[i].add(" ")
                (i == 0) -> cinema[i].add("$j")
                (j == 0) -> cinema[i].add(i.toString())
                else -> cinema[i].add("S")
            }
        }
    }

    var ticketsSold = 0
    var currentIncome = 0
    val totalIncome = totalIncome(numRows, numSeats)

    do {
        println(
            """1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit"""
        )
        val action = readln().toInt()

        when (action) {
            1 -> printCinema(numRows, cinema)
            2 -> {
                currentIncome += buyTicket(numRows, numSeats, cinema)
                ticketsSold++
            }

            3 -> showStatistics(
                numRows = numRows, numSeats = numSeats,
                ticketsSold = ticketsSold, currentIncome = currentIncome,
                totalIncome = totalIncome
            )
        }
    } while (action != 0)
}

fun totalIncome(numRows: Int, numSeats: Int): Int {
    return if (numRows * numSeats < 60) 10 * numRows * numSeats else {
        val half = numRows / 2
        half * numSeats * 10 + (numRows - half) * numSeats * 8
    }
}

private fun printCinema(
    numRows: Int,
    cinema: MutableList<MutableList<String>>
) {
    println("\nCinema:")
    for (i in 0..numRows) {
        println(cinema[i].joinToString(" "))
    }
    println()
}

private fun buyTicket(
    numRows: Int,
    numSeats: Int,
    cinema: MutableList<MutableList<String>>,
): Int {
    do {
        var purchased = false
        println("Enter a row number:")
        val rowPicked = readln().toInt()
        println("Enter a seat number in that row:")
        val seatPicked = readln().toInt()

        if (rowPicked !in 1..numRows || seatPicked !in 1..numSeats) {
            println("Wrong input!")
            continue
        } else if (cinema[rowPicked][seatPicked] == "S") {
            cinema[rowPicked][seatPicked] = "B"
            purchased = true
        }

        if (!purchased) {
            println("That ticket has already been purchased!")
        } else {
            return if (numRows * numSeats < 60) {
                println("Ticket price: $10")
                10

            } else {
                if (rowPicked <= numRows / 2) {
                    println("Ticket price: $10")
                    return 10
                } else {
                    println("Ticket price: $8")
                    return 8
                }
            }
        }
    } while (rowPicked !in 1..numRows || seatPicked !in 1..numSeats || !purchased)
    return 0
}

fun showStatistics(
    numRows: Int,
    numSeats: Int,
    ticketsSold: Int,
    currentIncome: Int,
    totalIncome: Int
) {
    println("\nNumber of purchased tickets: $ticketsSold")

    val percentage = if (ticketsSold == 0) 0.0 else (ticketsSold / (numRows * numSeats).toDouble()) * 100
    val formattedPercentage = "%.2f".format(percentage)
    println("Percentage: $formattedPercentage%")
    println("Current income: $$currentIncome")
    println("Total income: $$totalIncome\n")
}