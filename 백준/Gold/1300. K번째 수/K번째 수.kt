import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    println(findKth(br.readLine().toLong(), br.readLine().toLong()))
}

fun findKth(n: Long, k: Long): Long {
    var left: Long = 1
    var right: Long = k
    while (left < right) {
        val mid = left + (right - left) / 2
        if (countLessEqual(n, mid) < k) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}

fun countLessEqual(n: Long, x: Long): Long {
    var count: Long = 0
    for (i in 1..n) {
        count += minOf(x / i, n)
    }
    return count
}
