package sorting

import sorting.DataType.*
import sorting.SortingType.*
import java.util.*

class Data<T : Comparable<T>>(data: List<T>, val dataType: DataType, val sortingType: SortingType) {
    val sortedData = data.sorted()
    val countedSortedData: SortedMap<T, Int> = sortByValueKey(count(data))

    override fun toString(): String {
        return "Total ${dataType.secondName}s ${sortedData.size}.\n" +
                when (sortingType) {
                    NATURAL -> when (dataType) {
                        LONG, WORD -> "Sorted data: ${sortedData.joinToString(" ")}"
                        LINE -> "Sorted data:\n${sortedData.joinToString("\n")}"
                    }
                    BY_COUNT -> StringBuilder()
                        .also {
                            countedSortedData.forEach { (k, v) ->
                                it.append("$k: $v time(s), ${calcPercentage(v, sortedData.size)}%\n")
                            }
                        }
                }
    }
}