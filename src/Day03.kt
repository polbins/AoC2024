private val MULTIPLICATION_REGEX = "mul\\((\\d+),(\\d+)\\)".toRegex()

fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf { line ->
            MULTIPLICATION_REGEX.findAll(line).sumOf {
                it.groupValues[1].toInt() * it.groupValues[2].toInt()
            }
        }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))")) == 161)

    // Or read a large test input from the `src/Day03_test.txt.txt` file:
//    val testInput = readInput("Day03_test")
//    check(part1(testInput) == 161)

    // Read the input from the `src/Day03.txt` file.
    val input = readInput("Day03")
    part1(input).println()
//    part2(input).println()
}
