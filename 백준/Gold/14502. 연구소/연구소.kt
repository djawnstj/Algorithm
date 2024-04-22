import java.io.*
import java.util.*

private val disX = intArrayOf(1, 0, -1, 0)
private val disY = intArrayOf(0, 1, 0, -1)
private var max = Int.MIN_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()
    val m = st.nextInt()
    val q: Queue<Node> = LinkedList()

    val original = Array(n) { x ->
        st = StringTokenizer(br.readLine())

        IntArray(m) { y ->
            val value = st.nextInt()
            if (value == 2) q.add(Node(x, y))
            value
        }
    }

    dfs(n, m, original, 0, 0, 0, q)

    println(max)
}

private fun dfs(n: Int, m: Int, arr: Array<IntArray>, curX: Int, curY: Int, wallNum: Int, q: Queue<Node>) {
    if (wallNum == 3) {
        val copy = Array(n) { arr[it].copyOf() }
        bfs(n, m, copy, LinkedList(q))

        return
    }

    for (x in 0 until n) {
        for (y in 0 until m) {
            if (arr[x][y] == 0) {
                arr[x][y] = 1
                dfs(n, m, arr, x, y, wallNum + 1, q)
                arr[x][y] = 0
            }
        }
    }
}

private fun bfs(n: Int, m: Int, arr: Array<IntArray>, q: Queue<Node>) {

    while (q.isNotEmpty()) {
        val cur = q.poll()

        for (i in 0 until 4) {
            val newX = disX[i] + cur.x
            val newY = disY[i] + cur.y

            if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue

            if (arr[newX][newY] == 0) {
                arr[newX][newY] = 2
                q.add(Node(newX, newY))
            }

        }
    }

    calc(arr)
}

private fun calc(arr: Array<IntArray>) {
    var temp = 0
   arr.forEach { ints: IntArray ->
       ints.forEach {
           if (it == 0) temp++
       }
   }

    max = Math.max(max, temp)
}

data class Node(
    val x: Int,
    val y: Int,
)

private fun BufferedReader.readInt(): Int = readLine().toInt()

private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
