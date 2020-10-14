package sorting

import sorting.DataType.*

fun main(args: Array<String>) {
    run(Args().also { it.main(it.checkAndFilter(args)) })
}

fun run(parsedArgs: Args) {
    val data = when (parsedArgs.dataType) {
        LONG -> Data(readLongsFromConsole(), LONG, parsedArgs.sortingType)
        WORD -> Data(readWordsFromConsole(), WORD, parsedArgs.sortingType)
        LINE -> Data(readLinesFromConsole(), LINE, parsedArgs.sortingType)
    }
    parsedArgs.outputFile?.writeText(data.toString()) ?: print(data)
}