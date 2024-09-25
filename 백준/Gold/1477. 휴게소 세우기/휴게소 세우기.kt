import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m, l) = br.readLine().split(" ").map { it.toInt() }
    val positions = if (n > 0) br.readLine().split(" ").map { it.toInt() }.toIntArray() else intArrayOf()
    
    // 시작점(0)과 끝점(l)을 추가
    val allPositions = (listOf(0) + positions.toList() + listOf(l)).toIntArray()
    allPositions.sort()

    println(solve(n, m, l, allPositions))
}

fun solve(n: Int, m: Int, l: Int, positions: IntArray): Int {
    var left = 1
    var right = l - 1

    while (left <= right) {
        val mid = left + (right - left) / 2
        if (canBuild(mid, positions, m)) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    return left
}

fun canBuild(dist: Int, positions: IntArray, m: Int): Boolean {
    var count = 0
    for (i in 1 until positions.size) {
        val gap = positions[i] - positions[i-1]
        count += (gap - 1) / dist
        if (count > m) return false
    }
    return true
}