import java.util.*
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()
    val s = st.nextInt()

    st = StringTokenizer(br.readLine())

    val arr = IntArray(n) { st.nextInt() }

    var result = Int.MAX_VALUE
    var lt = 0
    var rt = 0

    var sum = arr[rt++]
    if (sum >= s) result = 1

    while (lt < n) {
        if (rt < n) {
            if (sum < s) {
                sum += arr[rt++]
            } else {
                sum -= arr[lt++]
            }
        } else sum -= arr[lt++]


        if (sum >= s) result = Math.min(result, rt - lt)
    }

    println(if (result != Int.MAX_VALUE) result else 0)

}

private fun StringTokenizer.nextInt() = nextToken().toInt()
