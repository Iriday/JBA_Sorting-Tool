package sorting

import sorting.DataType.*
import java.util.*

fun main(args: Array<String>) {
    run(Args().also { it.main(it.checkAndFilter(args)) })
}

fun run(parsedArgs: Args) {
    val scn = Scanner(parsedArgs.inputFile?.inputStream() ?: System.`in`)
    val data = when (parsedArgs.dataType) {
        LONG -> Data(readLongs(scn), LONG, parsedArgs.sortingType)
        WORD -> Data(readWords(scn), WORD, parsedArgs.sortingType)
        LINE -> Data(readLines(scn), LINE, parsedArgs.sortingType)
    }
    scn.close()
    parsedArgs.outputFile?.writeText(data.toString()) ?: print(data)
}