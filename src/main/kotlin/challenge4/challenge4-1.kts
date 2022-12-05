import java.io.File

val input = File("./input.txt")
    .readLines()
    .map { it.split(",").map { it.split("-").map { Integer.parseInt(it) } } }
    .count {
        val (firstPair, secondPair) = it
        (firstPair[0] <= secondPair[0] && firstPair[1] >= secondPair[1])
                || (firstPair[0] >= secondPair[0] && firstPair[1] <= secondPair[1])
    }

println(input)