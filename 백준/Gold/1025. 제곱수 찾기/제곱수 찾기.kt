import java.io.BufferedReader
import java.util.*
import kotlin.math.sqrt


fun main() {
    val br = System.`in`.bufferedReader()

    val st = br.readLine().toTokenizer()

    val n = st.nextInt()
    val m = st.nextInt()

    val arr = Array(n) {
        val nums = br.readLine()
        IntArray(m) { nums[it].digitToInt() }
    }

    var result = -1

    repeat(n) { x ->
        repeat(m) { y ->
            for (dx in -n until n) {
                for (dy in -m until m) {
                    if (dx == 0 && dy == 0) continue

                    var nX = x
                    var nY = y
                    var now = 0
                    while ((nX in 0 until n) && (nY in 0 until m)) {
                        now *= 10
                        now += arr[nX][nY]

                        val sqrt = sqrt(now.toDouble()).toInt()
                        if (sqrt * sqrt == now) result = Math.max(result, now)

                        nX += dx
                        nY += dy
                    }
                }
            }
        }
    }

    println(result)

    br.close()
}

private fun String.toTokenizer(): StringTokenizer = StringTokenizer(this)
private fun BufferedReader.readInt(): Int = readLine().toInt()
private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
private fun String.println() = println(this)
