package sorting

import java.util.*

fun main() {
    outputNumbersInfo(readNumbersFromConsole(Scanner(System.`in`)))
}

fun readNumbersFromConsole(scn: Scanner): List<Long> {
    return scn.asSequence().map { it.toLong() }.toList()
}

fun outputNumbersInfo(nums: List<Long>) {
    val max = nums.maxOrNull() ?: throw IllegalArgumentException("The list is empty")
    val occurs = nums.count { it == max }

    println("Total numbers: ${nums.size}.")
    println("The greatest number: $max ($occurs time(s)).")
}
