import java.util.*
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()
    val m = st.nextInt()

    val arr = IntArray(n + 1) { it }

    for (i in 0 until m) {
        st = StringTokenizer(br.readLine())

        val operator = st.nextInt()
        val a = st.nextInt()
        val b = st.nextInt()

        if (operator == 0) union(arr, a, b)
        else println(check(arr, a, b))
    }
}

fun union(arr: IntArray, a: Int, b: Int) {
    val rootA = find(arr, a)
    val rootB = find(arr, b)

    if (rootA != rootB) arr[rootB] = rootA
}

fun check(arr: IntArray, a: Int, b: Int): String {
    val rootA = find(arr, a)
    val rootB = find(arr, b)

    return if (rootA == rootB) "YES" else "NO"
}

fun find(arr: IntArray, num: Int): Int {
    val found = arr[num]
    if (found == num) return found

    return find(arr, found).also { arr[num] = it }
}

private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
