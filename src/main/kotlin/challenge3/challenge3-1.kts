import java.io.File

val input = File("./input.txt")
    .readLines()
    .map {
        val len = it.length
        Pair(it.subSequence(0, len / 2), it.subSequence(len / 2, len))
    }.map { (left, right) ->
        Pair(
            buildSet { addAll(left.toList()) },
            buildSet { addAll(right.toList()) }
        )
    }.map { (left, right) ->
        left.intersect(right).first()
    }.map {
        if(it.code in 65..90) {
            it.code - 64 + 26
        } else {
            it.code - 96
        }
    }.sum()

println(input)