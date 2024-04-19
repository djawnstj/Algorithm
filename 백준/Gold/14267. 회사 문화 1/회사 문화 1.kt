import java.io.*
import java.util.*
import kotlin.collections.ArrayList

/*
6 6
-1 1 2 3 3 2
2 123
3 123
4 123
5 123
2 123
3 123

답: 0 246 492 615 615 246

* */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()
    val m = st.nextInt()

    st = StringTokenizer(br.readLine())

    val arr = LongArray(n)
    val graph = Array<ArrayList<Int>>(n) { ArrayList() }

    for (i in 0 until n) {
        val num = st.nextInt()
        if (num == -1) continue

//        arr[num - 1].lowerEmps.add(emp)
        graph[num - 1].add(i)
    }

    for (i in 0 until m) {
        st = StringTokenizer(br.readLine())

        val num = st.nextInt() - 1
        val com = st.nextInt().toLong()

        arr[num] += com
    }

    dfs(arr, graph, 0)

    arr.forEach(Long::printWithSeparate)
}

private fun Long.printWithSeparate() = print("$this ")

private fun dfs(arr: LongArray, graph: Array<ArrayList<Int>>, num: Int) {
    graph[num].forEach {
        arr[it] += arr[num]
        dfs(arr, graph, it)
    }
}

private fun BufferedReader.readInt(): Int = readLine().toInt()

private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
