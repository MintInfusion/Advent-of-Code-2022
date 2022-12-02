import java.io.File

val totalScore = File("./input.txt")
    .readLines()
    .map { roundString ->
        val (opponent, me) = roundString.split(" ")
        val winningPoints = when(me) {
            "X" -> 0
            "Y" -> 3
            "Z" -> 6
            else -> throw Error("what? $me")
        }
        val choiceScore = when (opponent) {
            "A" -> when(me) {
                "X" -> 3
                "Y" -> 1
                "Z" -> 2
                else -> throw Error("HOW? $me")
            }
            "B" -> when(me) {
                "X" -> 1
                "Y" -> 2
                "Z" -> 3
                else -> throw Error("HOW? $me")
            }
            "C" -> when(me) {
                "X" -> 2
                "Y" -> 3
                "Z" -> 1
                else -> throw Error("HOW? $me")
            }
            else -> throw Error("wrong? $opponent")
        }
        winningPoints + choiceScore
    }.sum()

print(totalScore)