package sorting

import sorting.DataType.*

fun main(args: Array<String>) {
    run(Args().also { it.main(args) })
}

fun run(parsedArgs: Args) {
    val data = when (parsedArgs.dataType) {
        LONG -> Data(readNumsFromConsole(), LONG, parsedArgs.sortingType)
        WORD -> Data(readWordsFromConsole(), WORD, parsedArgs.sortingType)
        LINE -> Data(readLinesFromConsole(), LINE, parsedArgs.sortingType)
    }
    print(data)
}