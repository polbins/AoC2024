import kotlin.math.abs

private fun Int.isPositive() = this > 0

fun main() {
    fun part1(input: List<String>): Int {
        val lines = mutableListOf<IntArray>()
        input.forEach { line ->
            lines += line.split(" ").map { it.toInt() }.toIntArray()
        }

        var result = 0
        lines.forEach { line ->
            // subtract from left to right
            // it should either be positive or negative all throughout, and difference should be 1 to 3
            var previousDifference: Int? = null
            val safe = line.reduce { left, right ->
                val difference = left - right
                if (abs(difference) !in 1..3) {
                    return@reduce -1
                } else {
                    when {
                        previousDifference == null -> right
                        previousDifference?.isPositive() == true && difference.isPositive() -> right
                        previousDifference?.isPositive() == false && !difference.isPositive() -> right
                        else -> return@reduce -1
                    }.also {
                        previousDifference = difference
                    }
                }
            }
            println(safe)
            result += if (safe.isPositive()) 1 else 0
        }

        return result
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day02_test.txt` file:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)

    // Read the input from the `src/Day02.txt` file.
//    val input = readInput("Day02")
//    part1(input).println()
//    part2(input).println()
}
