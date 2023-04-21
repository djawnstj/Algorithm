
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.IllegalArgumentException
import kotlin.math.sqrt

val tt = intArrayOf(7, 17, 23, 31, 41, 47, 49, 71, 73, 79, 89, 97, 103, 113, 119, 119, 127, 137, 151, 161, 161, 167, 191, 193, 199, 217, 217, 223, 233, 239, 241, 257, 263, 271, 281, 287, 287, 289, 311, 313, 329, 329, 337, 343, 353, 359, 367, 383, 391, 391, 401, 409, 431, 433, 439, 449, 457, 463, 479, 487, 497, 497, 503, 511, 511, 521, 527, 527, 529, 553, 553, 569, 577, 593, 599, 601, 607, 617, 623, 623, 631, 641, 647, 673, 679, 679, 697, 697, 713, 713, 719, 721, 721, 727, 743, 751, 761, 769, 791, 791, 799, 799, 809, 823, 833, 833, 839, 857, 863, 881, 887, 889, 889, 911, 919, 929, 937, 943, 943, 953, 959, 959, 961, 967, 977, 983, 991, 1009, 1031, 1033, 1039, 1049, 1057, 1057, 1063, 1081, 1081, 1087, 1097, 1103, 1127, 1127, 1129, 1151, 1153, 1169, 1169, 1193, 1201, 1207, 1207, 1217, 1223, 1231, 1241, 1241, 1249, 1271, 1271, 1279, 1289, 1297, 1303, 1319, 1321, 1327, 1337, 1337, 1343, 1343, 1351, 1351, 1361, 1367, 1393, 1393, 1399, 1409, 1423, 1433, 1439, 1447, 1457, 1457, 1471, 1481, 1487, 1489, 1511, 1513, 1513, 1519, 1519, 1543, 1553, 1559, 1561, 1561, 1567, 1583, 1601, 1607, 1609, 1631, 1631, 1633, 1633, 1649, 1649, 1657, 1663, 1673, 1673, 1679, 1679, 1681, 1687, 1687, 1697, 1721, 1751, 1751, 1753, 1759, 1777, 1783, 1799, 1799, 1801, 1817, 1817, 1823, 1831, 1841, 1841, 1847, 1871, 1873, 1879, 1889, 1897, 1897, 1913, 1921, 1921, 1927, 1927, 1951, 1967, 1967, 1993, 1999, 2009, 2009, 2017, 2023, 2023, 2039, 2047, 2047, 2063, 2081, 2087, 2089, 2111, 2113, 2129, 2137, 2143, 2153, 2159, 2159, 2161, 2177, 2177, 2191, 2191, 2201, 2201, 2207, 2209, 2231, 2231, 2239, 2263, 2263, 2273, 2281, 2287, 2297, 2303, 2303, 2311, 2329, 2329, 2351, 2359, 2359, 2369, 2369, 2377, 2383, 2393, 2399, 2401, 2417, 2423, 2441, 2447, 2449, 2449, 2471, 2471, 2473, 2503, 2513, 2513, 2521, 2543, 2551, 2567, 2567, 2569, 2569, 2591, 2593, 2599, 2599, 2609, 2617, 2633, 2647, 2657, 2663, 2671, 2681, 2681, 2687, 2689, 2711, 2713, 2719, 2729, 2737, 2737, 2737, 2737, 2753, 2759, 2759, 2767, 2777, 2791, 2801)

fun main() {
    rectangles = mutableListOf<Rectangle>()
    val start = System.currentTimeMillis()
    val sb = StringBuilder()
    val br = BufferedReader(InputStreamReader(System.`in`))
    val times = br.readLine().toInt()
    for (tr in 1..times) {
        val max = br.readLine().toInt()
        sb.append(dfs(max/2, 2)).append('\n')
    }
//    println()
//    rectangles.forEach { print("${it}, ")}
//    println()
    print(sb)

//    rectangles.forEach { print("$it, ") }
//    println()
//    println("${System.currentTimeMillis() - start}")
//    println()
    // 7, 17, 23, 31, 41, 47, 49, 71, 73, 79, 89,
}

var rectangles = mutableListOf<Rectangle>()

class Rectangle(val width: Int, val height: Int) : Comparable<Rectangle> {
    override fun equals(other: Any?): Boolean {
        if (other !is Rectangle) throw IllegalArgumentException("not matching class")
        return (this.width == other.width) && (this.height == other.height) || (this.height == other.width) && (this.width == other.height)
    }

    override fun compareTo(other: Rectangle): Int {
        return (this.width + this.height) - (other.width + other.height)
    }

    override fun hashCode(): Int {
        return 31 * (width + height)
    }

    override fun toString(): String {
        return "${width + height}"
    }
}

fun dfs(length: Int, max: Int): Int {
//    println("call($length, $max)")
//    if (length < 3) return 0
//    else if (length > max) return 0
    var result = 0
//
//    result += generatePythagoreanTriple(length)
//    var newMax = max
//    if (result > 0) newMax = max - length
//    result += dfs(length + 1, newMax)

    var temp = 0
    tt.forEach {
        temp += it
        if (temp > length) return result
        else result++
    }

    return result
}

fun generatePythagoreanTriple(i: Int): Int {
    if (i < 3) return 0 // 피타고라스 정리를 만족하는 정수는 3 이상이어야 합니다.

    for (a in 1..i) {
        for (b in 1..i - a) {
            val c = Math.sqrt((a * a + b * b).toDouble()).toLong()
            if (c > i) break // c 가 i보다 크면 더 이상 확인할 필요가 없습니다.
            if ((a * a + b * b).toLong() == c * c && gcd(a, b) == 1 && rectangles.indexOf(Rectangle(a, b)) < 0) {
//                print("${a + b}($i), ")
                rectangles += Rectangle(a, b)
                return 1
            }
        }
    }

    return 0
}

fun gcd(first: Int, second: Int): Int {
    var a = first
    var b = second
    while (b != 0) {
        val r = a % b
        a = b
        b = r
    }
    return a
}