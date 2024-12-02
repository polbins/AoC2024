import kotlin.math.abs

private val WHITESPACE_REGEX = "\\s+".toRegex()

fun main() {
    fun part1(input: List<String>): Int {
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()

        input.forEach {
            val split = it.split(WHITESPACE_REGEX)
            left.add(split[0].toInt())
            right.add(split[1].toInt())
        }

        left.sort()
        right.sort()

        return input.indices.sumOf {
            abs(left[it] - right[it])
        }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
//    part2(input).println()
}
