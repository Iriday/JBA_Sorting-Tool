package sorting

import java.util.*
import sorting.DataType.*

fun main(args: Array<String>) {
    run(Args().also { it.main(args) })
}

fun run(parsedArgs: Args) {
    val scn = Scanner(System.`in`)
    val statistic = when (parsedArgs.dataType) {
        LONG -> processNumbers(readNumbersFromConsole(scn))
        WORD -> processWords(readWordsFromConsole(scn))
        LINE -> throw NotImplementedError()
    }
    print(statistic)
}

fun readNumbersFromConsole(scn: Scanner) = scn.asSequence().map { it.toLong() }.toList()

fun readWordsFromConsole(scn: Scanner) = scn.asSequence().toList()

fun processNumbers(nums: List<Long>): Statistic {
    val maxNumber = nums.maxOrNull() ?: throw IllegalArgumentException("The list is empty")
    val occurs = nums.count { it == maxNumber }
    return Statistic(maxNumber.toString(), occurs, nums.size, LONG)
}

fun processWords(words: List<String>): Statistic {
    words.sorted()
    val longestWord = words.maxByOrNull { it.length } ?: throw IllegalArgumentException("The list is empty")
    val occurs = words.count { it == longestWord }
    return Statistic(longestWord, occurs, words.size, WORD)
}
