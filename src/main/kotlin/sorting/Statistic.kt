package sorting

import sorting.DataType.*
import kotlin.math.roundToInt

class Statistic(val max: String, val occurs: Int, val total: Int, val type: DataType) {
    val occurrencePercentage = (occurs.toDouble() / total * 100).roundToInt()

    override fun toString(): String {
        return when (type) {
            LONG -> "Total numbers: $total.\nThe greatest number: $max "
            WORD -> "Total words: $total.\nThe longest word: $max "
            LINE -> "Total lines: $total.\nThe longest line:\n$max\n"
        } + "($occurs time(s), $occurrencePercentage%)."
    }
}