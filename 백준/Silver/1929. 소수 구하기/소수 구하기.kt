import java.util.*
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val m = st.nextInt()
    val n = st.nextInt()

    val arr = IntArray(n + 1)

    for (i in 2 .. n) {
        arr[i] = i
    }

    for (i in 2 ..Math.sqrt(n.toDouble()).toInt()) {
        if (arr[i] == 0) continue

        for (j in i+i .. n step i) {
            arr[j] = 0
        }
    }

    for (i in m .. n) {
        if (arr[i] == 0) continue
        println(arr[i])
    }
}

private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
