package sorting

import java.util.*

fun main(args: Array<String>) {
    run(Args().also { it.main(args) })
}

fun run(parsedArgs: Args) {
    when (parsedArgs.dataType) {
        "long" -> outputNumbersInfo(readNumbersFromConsole(Scanner(System.`in`)))
        "word" -> println("Not implemented yed")
        "line" -> println("Not implemented yet")
    }
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
