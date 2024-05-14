import java.io.BufferedReader
import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val tokenizer = br.readLine().toTokenizer()

    val n = tokenizer.nextInt()
    val c = tokenizer.nextInt()

    val arr = IntArray(n) { br.readInt() }
        .apply { sort() }

    var result = 0
    var left = 0
    var right = arr.last() - arr.first()

    while (left <= right) {
        var cnt = 1
        val mid = (right + left) / 2

        var cur = arr.first()

        for (i in 1 until n) {
            if (arr[i] - cur >= mid) {
                cnt++
                cur = arr[i]
            }
        }

        if (cnt >= c) {
            result = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    println(result)
}

private fun check(arr: LongArray, length: Long): Long = arr.sumOf { calc(it, length) }

private fun calc(original: Long, to: Long): Long = original / to

private fun String.toTokenizer(): StringTokenizer = StringTokenizer(this)
private fun BufferedReader.readInt(): Int = readLine().toInt()
private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
private fun String.println() = println(this)
