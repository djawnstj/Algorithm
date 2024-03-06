import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()

    st = StringTokenizer(br.readLine())

    val m = st.nextInt()

    st = StringTokenizer(br.readLine())

    val arr = IntArray(n) { st.nextInt() }.sortedArray()

    var result = 0

    var l = 0
    var r = n - 1

    while (l < r) {
        val sum = arr[l] + arr[r]

        if (sum < m) l++
        else if (sum > m) r--
        else {
            result++
            l++
            r--
        }
    }

    println(result)
}

fun StringTokenizer.nextInt() = nextToken().toInt()
