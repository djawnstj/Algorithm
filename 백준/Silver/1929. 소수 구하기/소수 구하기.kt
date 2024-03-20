import java.util.*
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val m = st.nextInt()
    val n = st.nextInt()

    val arr = Array(n + 1) { true }

    for (i in 2 .. n) {
        if (!arr[i]) continue
        else if (i >= m) println(i)

        var temp = i

        while (temp <= n) {
            arr[temp] = false
            temp += i
        }
    }
}

private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
