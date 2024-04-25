import java.io.*
import java.util.*

private val disX = intArrayOf(1, 0, -1, 0)
private val disY = intArrayOf(0, 1, 0, -1)
private val bridges: PriorityQueue<Bridge> = PriorityQueue()

enum class Direction(val index: Int) {
    SOUTH(0), EAST(1), NORTH(2), WEST(3);

    companion object {
        fun indexOf(index: Int): Direction =
            when (index) {
                0 -> SOUTH
                1 -> EAST
                2 -> NORTH
                3 -> WEST
                else -> throw IllegalArgumentException()
            }
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()
    val m = st.nextInt()

    val arr = Array(n) { x ->
        st = StringTokenizer(br.readLine())
        Array(m) { y ->
            val value = st.nextInt()
            if (value == 1) Island(x, y)
            else Sea(x, y)
        }
    }

    var islandNum = 2

    for (x in 0 until n) {
        for (y in 0 until m) {
            if (arr[x][y].isSea()) continue
            if ((arr[x][y] as Island).isChecked()) continue
            checkIsland(n, m, arr, x, y, islandNum++)
        }
    }

    val parent = IntArray(islandNum) { it }

    for (x in 0 until n) {
        for (y in 0 until m) {
            if (arr[x][y].isSea()) continue
            bfs(n, m, arr, x, y, Array(n) { BooleanArray(m) })
        }
    }

    val result = kruskal(islandNum, parent)
    println(result)

    br.close()
}

// 크루스칼 알고리즘을 위한 유니온-파인드
fun find(a: Int, arr: IntArray) : Int {
    if (arr[a] != a) {
        arr[a] = find(arr[a], arr)
    }
    return arr[a]
}
fun union(a: Int, b: Int, arr: IntArray) {
    val x = find(a, arr)
    val y = find(b, arr)

    if(x < y) arr[y] = x
    else arr[x] = y
}

// 크루스칼 알고리즘으로 MST 구하기
fun kruskal(islandNum: Int, arr: IntArray): Int {
    var sum = 0

    while(bridges.isNotEmpty()) {
        val edge = bridges.poll()
        if(find(edge.start, arr) != find(edge.end, arr)) {
            sum += edge.length
            union(edge.start, edge.end, arr)
        }
    }

    // 모든 섬이 연결되어 있는지 확인
    for(i in 2 until islandNum) {
        if(find(arr[i], arr) != 2) {
            sum = -1
        }
    }

    return sum
}

private fun bfs(n: Int, m: Int, arr: Array<Array<Node>>, x: Int, y: Int, visited: Array<BooleanArray>) {
    val q: Queue<Bridge> = LinkedList()

    val island = arr[x][y] as Island

    for (i in 0 until 4) {
        val newX = island.x + disX[i]
        val newY = island.y + disY[i]

        if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue

        if (arr[newX][newY].isSea()) q.add(Bridge(x, y, island.num, Direction.indexOf(i)))
    }

    while (q.isNotEmpty()) {
        val cur = q.poll()

        val newLength = cur.length + 1

        val newX = cur.x + disX[cur.direction.index]
        val newY = cur.y + disY[cur.direction.index]

        if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue
        if (visited[newX][newY]) continue

        visited[newX][newY] = true
        val nextNode = arr[newX][newY]

        if (nextNode.isSea()) q.add(Bridge(newX, newY, cur.start, cur.direction, newLength))
        else if (cur.isConnect((nextNode as Island).num)) {
            if (cur.length > 1) {
                bridges.add(cur.copy(end = nextNode.num))
            }
        }

    }
}

private fun checkIsland(n: Int, m: Int, arr: Array<Array<Node>>, curX: Int, curY: Int, islandNum: Int) {
    if (arr[curX][curY].isSea()) return
    val cur =  (arr[curX][curY] as Island)
    if (cur.isChecked()) return
    cur.num = islandNum

    for (i in 0 until 4) {
        val newX = curX + disX[i]
        val newY = curY + disY[i]

        if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue

        checkIsland(n, m, arr, newX, newY, islandNum)
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
data class Bridge(val x: Int, val y: Int, val start: Int, val direction: Direction, val length: Int = 0, val end: Int = -1): Comparable<Bridge> {
    fun isConnect(islandNum: Int): Boolean = this.start != islandNum

    override fun compareTo(other: Bridge): Int = this.length.compareTo(other.length)
}

private fun BufferedReader.readInt(): Int = readLine().toInt()
private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
private fun String.println() = println(this)
