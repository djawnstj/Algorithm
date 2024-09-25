import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()
    val m = st.nextInt()
    val l = st.nextInt()

    val readLine = br.readLine()

    st = StringTokenizer(readLine)

    val size = n + 2
    val arr = IntArray(size) {
        when (it) {
            0 -> return@IntArray 0
            size - 1 -> return@IntArray l
            else -> st.nextInt()
        }
    }

    arr.sort()

    println(solve(n, m, l, arr))
}

private fun StringTokenizer.nextInt(): Int = nextToken().toInt()

fun solve(n: Int, m: Int, l: Int, positions: IntArray): Int {
    var left = 1
    var right = l

    while (left <= right) {
        val mid = left + (right - left) / 2
        if (canBuild(mid, positions, m, l)) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    return left
}

fun canBuild(dist: Int, positions: IntArray, m: Int, l: Int): Boolean {
    var count = 0
    
    for (i in 1 until positions.size) {
        val gap = positions[i] - positions[i-1]
        count += (gap - 1) / dist
        if (count > m) return false
    }

    return count <= m
}
