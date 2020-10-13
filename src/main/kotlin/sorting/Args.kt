package sorting

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.help
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.choice
import com.github.ajalt.clikt.parameters.types.enum
import sorting.SortingType.*
import kotlin.system.exitProcess

class Args : CliktCommand() {
    val dataType by option("-dataType")
        .help("Data type")
        .enum<DataType>()
        .default(DataType.WORD)

    val sortingType by option("-sortingType")
        .help("Sorting type")
        .choice("natural" to NATURAL, "byCount" to BY_COUNT, ignoreCase = true)
        .default(NATURAL)

    override fun run() {}

    fun checkAndFilter(args: Array<String>): MutableList<String> {
        fun checkType(argName: String, secondName: String) {
            val argIndex = args.indexOf(argName)
            if (argIndex != -1 && (argIndex == args.lastIndex || args[argIndex + 1].startsWith("-"))) {
                print("No $secondName defined!")
                exitProcess(1)
            }
        }
        checkType("-dataType", "data type")
        checkType("-sortingType", "sorting type")

        val filteredArgs = mutableListOf<String>()
        var i = 0
        while (i < args.size) {
            if (args[i] == "-dataType" || args[i] == "-sortingType") {
                filteredArgs.add(args[i++])
                filteredArgs.add(args[i++])
                continue
            }
            if (args[i].startsWith("-")) {
                println(""""${args[i]}" is not a valid parameter. It will be skipped.""")
            }
            i++
        }
        return filteredArgs
    }
}