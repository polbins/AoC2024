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
        val left = mutableListOf<Int>()
        val rightCount = mutableMapOf<Int, Int>()

        input.forEach { line ->
            val split = line.split(WHITESPACE_REGEX)
            left.add(split[0].toInt())
            val right = split[1].toInt()
            rightCount[right] = rightCount.getOrPut(right) { 0 } + 1
        }

        return input.indices.sumOf {
            val num = left[it]
            num * (rightCount[num] ?: 0)
        }
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
