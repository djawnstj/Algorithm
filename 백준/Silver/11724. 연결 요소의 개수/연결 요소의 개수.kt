import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var A: Array<ArrayList<Int>>
lateinit var visited: Array<Boolean>

fun main(args: Array<String>) {

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    A = Array(n + 1) { ArrayList() }
    visited = Array(n + 1) { false }

    for (i in 0 until m) {
        st = StringTokenizer(br.readLine())
        val s = st.nextToken().toInt()
        val e = st.nextToken().toInt()
        A[s].add(e)
        A[e].add(s)
    }

    var count = 0
    
    for (i in 1 until n+1) {
        if (!visited[i]) {
            count ++
            DFS(i)
        }
    }
    println(count)

}

fun DFS(v: Int) {
    if (visited[v]) return
    visited[v] = true
    A[v].forEach { if (!visited[it]) DFS(it) }
}