package sorting

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.help
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.choice
import com.github.ajalt.clikt.parameters.types.enum
import sorting.SortingType.*

class Args : CliktCommand() {
    val dataType by option("--dataType", "-dataType", "-t")
        .help("Data type")
        .enum<DataType>()
        .default(DataType.WORD)

    val sortingType by option("-sortingType", "-s")
        .help("Sorting type")
        .choice("natural" to NATURAL, "byCount" to BY_COUNT, ignoreCase = true)
        .default(NATURAL)

    override fun run() {}
}