import java.io.*
import java.util.*

private val disX = intArrayOf(1, 0, -1, 0)
private val disY = intArrayOf(0, 1, 0, -1)
private var result = Int.MAX_VALUE

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()

    val arr = Array(n) { x ->
        st = StringTokenizer(br.readLine())
        Array(n) { y ->
            val value = st.nextInt()
            if (value == 1) Island(x, y)
            else Sea(x, y)
        }
    }

    var islandNum = 0

    for (x in 0 until n) {
        for (y in 0 until n) {
            if (arr[x][y].isSea()) continue
            if ((arr[x][y] as Island).isChecked()) continue
            checkIsland(n, arr, x, y, ++islandNum)
        }
    }

    for (x in 0 until n) {
        for (y in 0 until n) {
            if (arr[x][y].isSea()) continue
            bfs(n, arr, x, y, Array(n) { BooleanArray(n) })
        }
    }

    println(result)
}

private fun bfs(n: Int, arr: Array<Array<Node>>, x: Int, y: Int, visited: Array<BooleanArray>) {
    val q: Queue<Bridge> = LinkedList()

    val island = arr[x][y] as Island

    for (i in 0 until 4) {
        val newX = island.x + disX[i]
        val newY = island.y + disY[i]

        if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue

        if (arr[newX][newY].isSea()) q.add(Bridge(x, y, island.num))
    }

    while (q.isNotEmpty()) {
        val cur = q.poll()

        val newLength = cur.length + 1

        for (i in 0 until 4) {
            val newX = cur.x + disX[i]
            val newY = cur.y + disY[i]

            if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue
            if (visited[newX][newY]) continue

            visited[newX][newY] = true
            val nextNode = arr[newX][newY]
            if (nextNode.isSea()) q.add(Bridge(newX, newY, cur.start, newLength))
            else if (cur.isConnect((nextNode as Island).num)) result = Math.min(result, cur.length)
        }
    }
}

private fun checkIsland(n: Int, arr: Array<Array<Node>>, curX: Int, curY: Int, islandNum: Int) {
    if (arr[curX][curY].isSea()) return
    val cur =  (arr[curX][curY] as Island)
    if (cur.isChecked()) return
    cur.num = islandNum

    for (i in 0 until 4) {
        val newX = curX + disX[i]
        val newY = curY + disY[i]

        if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue

        checkIsland(n, arr, newX, newY, islandNum)
    }
}

interface Node {
    val x: Int
    val y: Int
    fun isIsland(): Boolean
    fun isSea(): Boolean
}

data class Island(override val x: Int, override val y: Int, var num: Int = -1): Node {
    fun isChecked(): Boolean = this.num != -1

    override fun isIsland(): Boolean = true
    override fun isSea(): Boolean = false
}
data class Sea(override val x: Int, override val y: Int): Node {
    override fun isIsland(): Boolean = false
    override fun isSea(): Boolean = true
}
data class Bridge(val x: Int, val y: Int, val start: Int, val length: Int = 0) {
    fun isConnect(islandNum: Int): Boolean = this.start != islandNum
}

private fun BufferedReader.readInt(): Int = readLine().toInt()
private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
private fun String.println() = println(this)
