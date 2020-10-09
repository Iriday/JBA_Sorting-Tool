package sorting

import java.util.*
import sorting.DataType.*

fun main(args: Array<String>) {
    run(Args().also { it.main(args) })
}

fun run(parsedArgs: Args) {
    val statistic = when (parsedArgs.dataType) {
        LONG -> processNumbers(readNumbersFromConsole(Scanner(System.`in`)))
        WORD, LINE -> throw NotImplementedError()
    }
    print(statistic)
}

fun readNumbersFromConsole(scn: Scanner) = scn.asSequence().map { it.toLong() }.toList()

fun processNumbers(nums: List<Long>): Statistic {
    val max = nums.maxOrNull() ?: throw IllegalArgumentException("The list is empty")
    val occurs = nums.count { it == max }
    return Statistic(max.toString(), occurs, nums.size, LONG)
}
