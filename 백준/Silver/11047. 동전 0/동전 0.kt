import java.util.*
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val n = st.nextInt()
    var k = st.nextInt()

    val arr = IntArray(n) { StringTokenizer(br.readLine()).nextInt() }

    var result = 0

    arr.sortedArrayDescending().forEach {
        if (it > k) return@forEach

        val mock = k / it
        if (mock > 0) {
            k -= it * mock
            result+=mock
        }
    }

    println(result)
}

private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
