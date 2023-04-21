import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.sqrt

var list = ArrayList<Int>()

fun main() {
    list = setList(500000)

    val sb = StringBuilder()
    val br = BufferedReader(InputStreamReader(System.`in`))
    val times = br.readLine().toInt()
    for (tr in 1..times) {
        val max = br.readLine().toInt()
        val result = test(max / 2)
        sb.append(result).append('\n')
    }
    print(sb)

}

fun test(i: Int): Int {
    var result = 0
    var temp = 0

    list.forEach {
        temp += it
        if (temp > i) return result
        result++
    }

    return result
}

fun setList(limit: Int): ArrayList<Int> {
    var a: Int
    var b: Int
    val list = ArrayList<Int>()
    var sum = 0
    var plus = 7
    while (plus <= limit) {
        for (i in 1..plus / 2) {
            a = i
            b = plus - i
            val c = sqrt((a * a + b * b).toDouble()).toInt()
            if (c * c == a * a + b * b && gcd(a, b) == 1) {
                sum += a + b
                if (sum > limit) return list
                list.add(a + b)
            }
        }
        plus++
    }
    return list
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
