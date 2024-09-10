import java.io.BufferedReader
import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()

    val (n, s) = br.nextIntPair()

    val arr = br.nextIntArray()

    var count = 0

    fun dfs(index: Int, sum: Int) {
        if (index == n) {
            if (sum == s) count++
            return
        }

        dfs(index + 1, sum)

        dfs(index + 1, sum + arr[index])
    }

    dfs(0, 0)

    if (s == 0) count--

    println(count)
}

private fun BufferedReader.nextIntPair(): Pair<Int, Int> = StringTokenizer(readLine()).let { it.nextInt() to it.nextInt() }

private fun BufferedReader.nextIntArray(): IntArray {
    val st = StringTokenizer(readLine())
    val n = st.countTokens()

    return IntArray(n) { st.nextInt() }
}

private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
