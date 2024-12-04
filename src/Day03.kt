private val MULTIPLICATION_REGEX = "mul\\((\\d+),(\\d+)\\)".toRegex()
private val DISABLED_ENABLED_MULTIPLICATION_REGEX = "don't\\(\\)|do\\(\\)|mul\\((\\d+),(\\d+)\\)".toRegex()

fun main() {
    fun part1(input: List<String>): Int {
        return input.sumOf { line ->
            MULTIPLICATION_REGEX.findAll(line).sumOf {
                it.groupValues[1].toInt() * it.groupValues[2].toInt()
            }
        }
    }

    fun part2(input: List<String>): Int {
        var result = 0
        var enabled = true
        input.forEach { line ->
            DISABLED_ENABLED_MULTIPLICATION_REGEX.findAll(line).forEach {
                with(it.value) {
                    if (startsWith("don't")) {
                        enabled = false
                    } else if (startsWith("do")) {
                        enabled = true
                    } else {
                        if (enabled) {
                            result += it.groupValues[1].toInt() * it.groupValues[2].toInt()
                        }
                    }
                }
            }
        }
        return result
    }

    // Test if implementation meets criteria from the description, like:
//    check(part1(listOf("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))")) == 161)

    // Or read a large test input from the `src/Day03_test.txt.txt` file:
//    val testInput = readInput("Day03_test")
//    check(part2(testInput) == 48)

    // Read the input from the `src/Day03.txt` file.
    val input = readInput("Day03")
//    part1(input).println()
    part2(input).println()
}
