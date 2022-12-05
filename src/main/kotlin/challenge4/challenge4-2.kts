import java.io.File

val input = File("./input.txt")
    .readLines()
    .map { it.split(",").map { it.split("-").map { Integer.parseInt(it) } } }
    .count {
        val (firstPair, secondPair) = it
        val (a0, a1) = firstPair
        val (b0, b1) = secondPair
        val noOverlap = (a0 < b0 && a1 < b0) || (b1 < a0 && b1 < a1)
        !noOverlap
    }

println(input)