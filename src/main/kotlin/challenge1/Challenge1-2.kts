import java.io.File

val sumOfHighest3CaloryElfes = File("./input.txt")
    .readText()
    .split("\n\n")
    .map { elfCaloriesString ->
        elfCaloriesString
            .split("\n")
            .map { caloriesString ->  Integer.parseInt(caloriesString, 10) }
            .sum()
    }
    .sortedDescending()
    .subList(0, 3)
    .sum()

print(sumOfHighest3CaloryElfes)