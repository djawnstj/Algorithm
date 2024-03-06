import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()

    var result = 1

    var l = 1
    var r = 1
    var sum = 1

    while (r < n) {
        if (sum == n) {
            result++
            r++
            sum += r
        } else if (sum > n) {
            sum -= l
            l ++
        } else {
            r++
            sum += r
        }
    }

    println(result)
}

fun StringTokenizer.nextInt() = nextToken().toInt()
