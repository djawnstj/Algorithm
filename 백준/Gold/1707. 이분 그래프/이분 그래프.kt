import java.util.*
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val k = st.nextInt()

    for (i in 0 until k) {
        st = StringTokenizer(br.readLine())

        val v = st.nextInt()
        val e = st.nextInt()

        val arr = Array(v + 1) { ArrayList<Int>() }
        val visited = BooleanArray(v + 1)
        val check = IntArray(v + 1)
        var even = true

        for (l in 0 until e) {
            st = StringTokenizer(br.readLine())

            val x = st.nextInt()
            val y = st.nextInt()
            arr[x].add(y)
            arr[y].add(x)
        }

        for (l in 1 .. v) {
            even = dfs(arr, l, check, visited)
            if (!even) break
        }

        val result = if (even) "YES" else "NO"

        println(result)
    }

}

fun dfs(arr: Array<ArrayList<Int>>, node: Int, check: IntArray, visited: BooleanArray): Boolean {
    visited[node] = true

    arr[node].forEach {
        if (!visited[it]) {
            check[it] = (check[node] + 1) % 2
            dfs(arr, it, check, visited)
        } else if (check[node] == check[it]) {
            return false
        }
    }

    return true
}

private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
