import java.io.*
import java.util.*

val disX = intArrayOf(0, 1, 0, -1, 1, 1, -1, -1)
val disY = intArrayOf(1, 0, -1, 0, 1, -1, -1, 1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()
    val m = st.nextInt()

    val arr = Array(n) { IntArray(m) }
    val ch = Array(n) { BooleanArray(m) }

    for (i in 0 until n) {
        st = StringTokenizer(br.readLine())
        for (j in 0 until m) arr[i][j] = st.nextInt()
    }

    var result = 0

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (ch[i][j]) continue
            val temp = dfs(n, m, i, j, arr[i][j], arr, ch, Array(n) { BooleanArray(m) })

            if (temp) result++
            else ch[i][j] = true
        }
    }

    println(result)

}

fun dfs(n: Int, m: Int, curX: Int, curY: Int, start: Int,  arr: Array<IntArray>, ch: Array<BooleanArray>, visited: Array<BooleanArray>): Boolean {
    if (visited[curX][curY]) return true
    visited[curX][curY] = true

    val cur = arr[curX][curY]

    if (start > cur) {
        ch[curX][curY] = true
        return true
    }

    if (start < cur) {
        return false
    }

    for (i in 0 until 8) {
        val nextX = curX + disX[i]
        val nextY = curY + disY[i]

        if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue
        if (visited[nextX][nextY]) continue

        val result = dfs(n, m, nextX, nextY, start, arr, ch, visited)

        if (!result) {
            ch[curX][curY] = true

            return false
        }
    }

    ch[curX][curY] = true

    return true
}

fun StringTokenizer.nextInt(): Int = nextToken().toInt()

fun BufferedReader.readInt(): Int = readLine().toInt()
