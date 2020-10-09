package sorting

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.help
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.choice

class Args : CliktCommand() {
    val dataType by option("--dataType", "-dataType", "-t")
        .help("Data type")
        .choice("long", "word", "line", ignoreCase = true)
        .default("word")

    override fun run() {}
}