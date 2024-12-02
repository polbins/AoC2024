import kotlin.math.abs

private fun Pair<Int?, Int>.safe(): Boolean {
    val (previous, current) = this
    return when {
        abs(current) !in 1..3 -> false
        (previous ?: 1) > 0 && current > 0 -> true
        (previous ?: -1) < 0 && current < 0 -> true
        else -> false
    }
}

fun main() {
    fun safe(line: IntArray): Boolean {
        var previousDifference: Int? = null
        line.reduce { left, right ->
            val difference = left - right
            if (!(previousDifference to difference).safe()) {
                return false
            }

            previousDifference = difference
            right
        }

        return true
    }

    fun part1(input: List<String>): Int {
        val lines = mutableListOf<IntArray>()
        input.forEach { line ->
            lines += line.split(" ").map { it.toInt() }.toIntArray()
        }

        var result = 0
        lines.forEach { line ->
            result += if (safe(line)) 1 else 0
        }

        return result
    }

    fun part2(input: List<String>): Int {
        val lines = mutableListOf<IntArray>()
        input.forEach { line ->
            lines += line.split(" ").map { it.toInt() }.toIntArray()
        }

        var result = 0
        lines.forEach { line ->
            if (!safe(line)) {
                line.indices.map { i ->
                    val modifiedLine = line.toMutableList()
                    modifiedLine.removeAt(i)
                    if (safe(modifiedLine.toIntArray())) {
                        result += 1
                        return@forEach
                    } else if (i == line.lastIndex) {
                        return@forEach
                    }
                }
            }
            result += 1
        }

        return result
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day02_test.txt` file:
    val testInput = readInput("Day02_test")
    check(part2(testInput) == 4)

    // Read the input from the `src/Day02.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
