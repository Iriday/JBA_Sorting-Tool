package sorting

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class TestUtils {
    @Test
    fun testCount() {
        assertEquals(count(listOf(1, 2, 2, 5, 10, 10, 10)).toString(), "{1=1, 2=2, 5=1, 10=3}")
        assertEquals(count(listOf("a", "bba", "a", "a", "bba", "cdefg")).toString(), "{a=3, bba=2, cdefg=1}")
    }

    @Test
    fun testSortByValueKey() {
        assertEquals(
            sortByValueKey(mutableMapOf(Pair(2, 2), Pair(1, 1), Pair(5, 1), Pair(10, 3))).toString(),
            "{1=1, 5=1, 2=2, 10=3}"
        )
        assertEquals(
            sortByValueKey(mutableMapOf(Pair("aab", 2), Pair("abb", 2), Pair("c", 3), Pair("aaa", 2))).toString(),
            "{aaa=2, aab=2, abb=2, c=3}"
        )
    }
}