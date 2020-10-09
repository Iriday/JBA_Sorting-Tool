package sorting

import java.util.*
import sorting.DataType.*

fun main(args: Array<String>) {
    run(Args().also { it.main(args) })
}

fun run(parsedArgs: Args) {
    val statistic = when (parsedArgs.dataType) {
        LONG -> processNums(readNumsFromConsole())
        WORD -> processWords(readWordsFromConsole())
        LINE -> processLines(readLinesFromConsole())
    }
    print(statistic)
}

fun readNumsFromConsole() = Scanner(System.`in`).asSequence().map { it.toLong() }.toList()
fun readWordsFromConsole() = Scanner(System.`in`).asSequence().toList()
fun readLinesFromConsole() = Scanner(System.`in`).useDelimiter("\n").asSequence().toList()

fun processNums(nums: List<Long>): Statistic {
    val maxNumber = nums.maxOrNull() ?: throw IllegalArgumentException("The list is empty")
    val occurs = nums.count { it == maxNumber }
    return Statistic(maxNumber.toString(), occurs, nums.size, LONG)
}
fun processWords(words: List<String>) = processText(words, WORD)
fun processLines(lines: List<String>) = processText(lines, LINE)

private fun processText(data: List<String>, type: DataType): Statistic {
    val longestStr = data.sorted().maxByOrNull { it.length } ?: throw IllegalArgumentException("The list is empty")
    val occurs = data.count { it == longestStr }
    return Statistic(longestStr, occurs, data.size, type)
}