import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, 1, 0, -1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()
    val m = st.nextInt()

    val arr = Array(n) { IntArray(m) }
    val temp = Array(n) { Array(m) { false } }

    for (x in 0 until n) {
        st = StringTokenizer(br.readLine())
        val line = st.nextToken()
        for (y in 0 until m) {
            arr[x][y] = line.substring(y, y+1).toInt()
        }
    }

    bfs(arr, temp, n, m)

    println(arr[n - 1][m-1])
}

fun bfs(arr: Array<IntArray>, temp: Array<Array<Boolean>>, n: Int, m: Int) {
    val queue: Queue<IntArray> = LinkedList()

    queue.add(intArrayOf(0, 0))

    while (queue.isNotEmpty()) {
        val now = queue.poll()
        for (i in 0 until 4) {
            val x = now[0] + dx[i]
            val y = now[1] + dy[i]

            if (x >= 0 && y >= 0 && x < n && y < m) {
                if (arr[x][y] != 0 && !temp[x][y]) {
                    temp[x][y] = true
                    arr[x][y] = arr[now[0]][now[1]] + 1
                    queue.add(intArrayOf(x, y))
                }
            }
        }
    }
}

fun StringTokenizer.nextInt(): Int = nextToken().toInt()
