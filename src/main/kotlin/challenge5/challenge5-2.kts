import java.io.File

val (stackString, instructionString) = File("./input.txt")
    .readText()
    .split("\n\n")

val instructions = instructionString.split("\n")
    .map {
        val (move, from, to) = Regex("move (\\d+) from (\\d+) to (\\d+)")
            .matchEntire(it)!!
            .destructured
        Instruction(
            Integer.parseInt(move),
            Integer.parseInt(from),
            Integer.parseInt(to))
    }


val numberOfStacks = stackString.split("\n").last().split("   ").map { Integer.parseInt(it.strip()) }.max()
val stacks =  Array(numberOfStacks) { _ -> ArrayDeque<String>()}

stackString
    .split("\n")
    .reversed()
    .drop(1)
    .forEach {
        var toTake = it
        var iter = 0
        while(toTake != "") {
            val token = toTake.take(3)
            if (token != "   ")
                stacks[iter].addLast(token.subSequence(1, 2).toString())
            toTake = toTake.drop(4)
            iter++
        }
    }

instructions.forEach {
    val removed = buildList {
        repeat(it.move) {_ -> add(stacks[it.from - 1].removeLast())}
    }
    stacks[it.to - 1].addAll(removed.reversed())
}

stacks.forEach {
    print(it.last())
}

data class Instruction(
    val move: Int,
    val from: Int,
    val to: Int,
)