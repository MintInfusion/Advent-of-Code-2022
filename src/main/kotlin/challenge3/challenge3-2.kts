import java.io.File

val input = File("./input.txt")
    .readLines()
    .chunked(3)
    .map {
        val set1 = buildSet { addAll(it[0].toList()) }
        val set2 = buildSet { addAll(it[1].toList()) }
        val set3 = buildSet { addAll(it[2].toList()) }
        set3.intersect(set1.intersect(set2)).first()
    }
    .map {
        if(it.code in 65..90) {
            it.code - 64 + 26
        } else {
            it.code - 96
        }
    }.sum()

println(input)