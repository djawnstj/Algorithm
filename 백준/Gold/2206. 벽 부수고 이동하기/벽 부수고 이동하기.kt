import java.io.*
import java.util.*

private val disX = intArrayOf(1, 0, -1, 0)
private val disY = intArrayOf(0, 1, 0, -1)
private var min = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()
    val m = st.nextInt()

    val original = Array(n) { x -> br.readLine().map(Char::digitToInt).toIntArray() }
    // 세번째 인덱스 0 -> 부순적 없이 방문한 경로, 1 -> 부수고 방문한 경로
    val visited = Array(n) { Array(m) { BooleanArray(2) } }

    val result = bfs(n, m, original, visited)

    println((if (result == Int.MAX_VALUE) - 1 else result))
}

private fun bfs(n: Int, m: Int, arr: Array<IntArray>, visited: Array<Array<BooleanArray>>): Int {

    val q: Queue<Node> = LinkedList()
    q.add(Node(0, 0))
    visited[0][0][0] = true

    while (q.isNotEmpty()) {
        val cur = q.poll()

        if (cur.isEnd(n, m)) return cur.depth

        for (i in 0 until 4) {
            val newX = cur.x + disX[i]
            val newY = cur.y + disY[i]
            val newDepth = cur.depth + 1

            if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue

            /*
            1. 벽을 만났을 때
              1-1. 벽을 부순 적이 있다면 continue
              1-2. 벽을 부순 적이 없다면
                1-2-1. 벽을 부순 적이 없는 경로에서 방문한 적이 있다면 continue
                q.add
            2. 벽이 아닌 곳을 만났을 때
              2-1. cur.crashed 에 따라 방문한 적이 없는 곳에 q.add

            */
            if (arr[newX][newY] == 1) {
                if (cur.crashed) continue
                if (visited[newX][newY][1]) continue

                q.add(Node(newX, newY, newDepth, true))
                visited[newX][newY][1] = true

                continue
            }

            if (!cur.crashed && visited[newX][newY][0]) continue
            if (cur.crashed && visited[newX][newY][1]) continue

            val crashedVisitedIndex = if (cur.crashed) 1 else 0
            q.add(Node(newX, newY, newDepth, cur.crashed))
            visited[newX][newY][crashedVisitedIndex] = true
        }
    }

    return -1
}

data class Node(
    val x: Int,
    val y: Int,
    val depth: Int = 1,
    val crashed: Boolean = false,
) {

    fun isEnd(n: Int, m: Int): Boolean = (this.x == n - 1 && this.y == m - 1)
}

private fun BufferedReader.readInt(): Int = readLine().toInt()

private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
