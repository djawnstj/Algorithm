import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()

    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val v = st.nextToken().toInt() - 1

    val arr = Array(n) { BooleanArray(n) }

    (0 until m).forEach {
        st = StringTokenizer(br.readLine())
        val m1 = st.nextToken().toInt() - 1
        val m2 = st.nextToken().toInt() - 1

        arr[m1][m2] = true
        arr[m2][m1] = true
    }

    val dfsResult = mutableListOf<Int>()
    dfs(arr, v, BooleanArray(n), dfsResult)

    println(dfsResult.joinToString(" "))

    val bfsResult = mutableListOf<Int>()
    bfs(arr, v, BooleanArray(n), bfsResult)

    println(bfsResult.joinToString(" "))
}

private fun dfs(arr: Array<BooleanArray>, cur: Int, check: BooleanArray, result: MutableList<Int>) {
    if (check[cur]) return

    check[cur] = true
    result.add(cur + 1)

    arr[cur].forEachIndexed { index, value ->
        if (check[index]) return@forEachIndexed

        if (value) {
            dfs(arr, index, check, result)
        }
    }
}

private fun bfs(arr: Array<BooleanArray>, cur: Int, check: BooleanArray, result: MutableList<Int>) {
    val q: Queue<Int> = LinkedList()
    q.offer(cur)

    while (q.isNotEmpty()) {
        val t = q.poll()
        result.add(t + 1)
        check[t] = true

        arr[t].forEachIndexed { index, value ->
            if (check[index]) return@forEachIndexed

            if (value) {
                check[index] = true
                q.offer(index)
            }
        }
    }
}

