package sorting

import sorting.DataType.*

class Statistic(val max: String, val occurs: Int, val total: Int, val type: DataType) {
    override fun toString(): String {
        return when (type) {
            LONG -> "Total numbers: ${total}.\nThe greatest number: $max ($occurs time(s))."
            WORD, LINE -> throw NotImplementedError()
        }
    }
}