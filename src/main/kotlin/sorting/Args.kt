package sorting

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.help
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.enum

class Args : CliktCommand() {
    val dataType by option("--dataType", "-dataType", "-t")
        .help("Data type")
        .enum<DataType>()
        .default(DataType.WORD)

    override fun run() {}
}