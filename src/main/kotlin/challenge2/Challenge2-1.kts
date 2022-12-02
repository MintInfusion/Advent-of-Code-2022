import java.io.File

/**
 * A, X = ROCK (1 Point)
 * B, Y = PAPER (2 Points)
 * C, Z = Scissors (3 Points)
 */
val totalScore = File("./input.txt")
    .readLines()
    .map { roundString ->
        val (opponent, me) = roundString.split(" ")
        when (opponent) {
            "A" ->
                when(me) {
                    "X" -> 1 + 3
                    "Y" -> 2 + 6
                    "Z" -> 3 + 0
                    else -> throw Error("somethings wrong... opponent: $opponent, me: $me")
                }
            "B" -> when(me) {
                    "X" -> 1 + 0
                    "Y" -> 2 + 3
                    "Z" -> 3 + 6
                    else -> throw Error("somethings wrong... opponent: $opponent, me: $me")
                }
            "C" -> when(me) {
                    "X" -> 1 + 6
                    "Y" -> 2 + 0
                    "Z" -> 3 + 3
                    else -> throw Error("somethings wrong... opponent: $opponent, me: $me")
                }
            else -> throw Error("somethings wrong... opponent: $opponent, me: $me")
        }
    }.sum()

print(totalScore)