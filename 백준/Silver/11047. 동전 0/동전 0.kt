import java.util.*
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val n = st.nextInt()
    val k = st.nextInt()

    val arr = IntArray(n) { StringTokenizer(br.readLine()).nextInt() }

    var temp = 0
    var result = 0

    arr.sortedArrayDescending().forEach {
        val target = k - temp
        if (it > target) return@forEach

        val mock = target / it
        if (mock > 0) {
            temp += it * mock
            result+=mock
        }
    }

    println(result)
}

private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
