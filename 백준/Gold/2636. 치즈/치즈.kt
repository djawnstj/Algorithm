import java.io.*
import java.util.*

private val disX = intArrayOf(1, 0, -1, 0)
private val disY = intArrayOf(0, 1, 0, -1)
private var cheese: Int = 0

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()
    val m = st.nextInt()

    val arr = Array(n) { x ->
        st = StringTokenizer(br.readLine())
        IntArray(m) { y ->
            val value = st.nextInt()
            if (value == 1) cheese++

            value
        }
    }

    var time = 0
    var result = 0

    while (cheese != 0) {
        time++
        result = cheese

        bfs(n, m, arr)
    }


    println("$time\n$result")

    br.close()
}


private fun validateRange(newX: Int, n: Int, newY: Int, m: Int) = (newX < 0 || newX >= n || newY < 0 || newY >= m)

private fun bfs(n: Int, m: Int, arr: Array<IntArray>) {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(0 to 0)
    val visited = Array(n) { BooleanArray(m) }
    visited[0][0] = true

    while (q.isNotEmpty()) {
        val curCheese = q.poll()

        repeat(4) {
            val newX = curCheese.first + disX[it]
            val newY = curCheese.second + disY[it]

            if (validateRange(newX, n, newY, m)) return@repeat
            if (visited[newX][newY]) return@repeat

            if (arr[newX][newY] == 1) {
                cheese--
                arr[newX][newY] = 0
            } else if (arr[newX][newY] == 0) q.add(newX to newY)

            visited[newX][newY] = true
        }
    }

}

private fun BufferedReader.readInt(): Int = readLine().toInt()
private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
private fun String.println() = println(this)
