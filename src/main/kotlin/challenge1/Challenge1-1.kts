import java.io.File

val highestCalories = File("./input.txt")
    .readText()
    .split("\n\n")
    .map { elfCaloriesString ->
        elfCaloriesString
            .split("\n")
            .map { caloriesString ->  Integer.parseInt(caloriesString, 10) }
            .sum()
    }
    .max()

print(highestCalories)