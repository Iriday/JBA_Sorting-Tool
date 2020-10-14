package sorting

import java.util.*
import kotlin.collections.LinkedHashMap
import kotlin.math.roundToInt

fun readLongs(scn: Scanner) = readWords(scn).mapNotNull { v ->
    v.toLongOrNull().also { if (it == null) println(""""$v" is not a long. It will be skipped.""") }
}
fun readWords(scn: Scanner) = scn.asSequence().toList()
fun readLines(scn: Scanner) = scn.useDelimiter("\n").asSequence().toList()

fun <T> count(data: List<T>) = LinkedHashMap<T, Int>().also { data.forEach { v -> it[v] = (it[v] ?: 0) + 1 } }

fun <T : Comparable<T>> sortByValueKey(data: MutableMap<T, Int>): SortedMap<T, Int> {
    return data.toSortedMap { a, b -> val d = data[a]!!.compareTo(data[b]!!); if (d != 0) d else a.compareTo(b) }
}

fun calcPercentage(v: Int, total: Int) = (v.toDouble() / total * 100).roundToInt()