import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()
    val m = st.nextInt()

    st = StringTokenizer(br.readLine())

    val arr = IntArray(n)
    val sumArr = IntArray(n + 1)

    for (i in 0 until n) {
        arr[i] = st.nextInt()
        sumArr[i+1] = sumArr[i] + arr[i]
    }


    for (i in 0 until m) {
        st = StringTokenizer(br.readLine())

        val i = st.nextInt() - 1
        val j = st.nextInt()

        println(sumArr[j] - sumArr[i])
    }

}

fun StringTokenizer.nextInt(): Int = nextToken().toInt()

