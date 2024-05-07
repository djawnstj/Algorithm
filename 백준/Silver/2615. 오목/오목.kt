import java.io.BufferedReader
import java.util.*

private val disX = intArrayOf(1, 0, -1, 0, 1, 1, -1, -1)
private val disY = intArrayOf(0, 1, 0, -1, 1, -1, 1, -1)

fun main() {
    val br = System.`in`.bufferedReader()

    val arr = Array(19) {
        val st = StringTokenizer(br.readLine())

        IntArray(19) { st.nextInt() }
    }

    val visited = ArrayList<Deque<Pair<Int, Int>>>()

    repeat(19) { x ->
        repeat(19) { y ->
            val doll = arr[x][y]

            if (doll == 0) return@repeat

            val deque = ArrayDeque<Pair<Int, Int>>()
            val check = check(doll, x, y, arr, deque, visited)

            if (check) {
                val comparator = compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first }
                val result = deque.minWithOrNull(comparator)

                println(doll)
                println("${result!!.first + 1} ${result.second + 1}")

                return
            }
        }
    }

    println(0)

    br.close()
}

private fun check(doll: Int, x: Int, y: Int, arr: Array<IntArray>, deque: Deque<Pair<Int, Int>>, visited: ArrayList<Deque<Pair<Int, Int>>>): Boolean {
    repeat(8) {
        deque.clear()

        deque.add(x to y)

        dfs(doll, x, y, arr, it, deque)

        if (deque.size >= 6) {
            val copiedDeque: Deque<Pair<Int, Int>> = ArrayDeque<Pair<Int, Int>>().apply {
                deque.forEach { (first, second) -> add(Pair(first, second)) }
            }
            visited.add(copiedDeque)
        }
        if (deque.size == 5) {
            val win = !visited.any { it.containsAll(deque) }
            if (win) return true
        }
    }

    return false
}

private fun dfs(doll: Int, x: Int, y: Int, arr: Array<IntArray>, direction: Int, deque: Deque<Pair<Int, Int>>) {
    val newX = x + disX[direction]
    val newY = y + disY[direction]

    if (newX < 0 || newX >= 19 || newY < 0 || newY >= 19) return

    if (doll != arr[newX][newY]) return

    deque.addLast(newX to newY)

    return dfs(doll, newX, newY, arr, direction, deque)
}

private fun BufferedReader.readInt(): Int = readLine().toInt()
private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
private fun String.println() = println(this)
