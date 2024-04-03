import java.util.*
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()

    val a = IntArray(n)
    val b = IntArray(n)
    val c = IntArray(n)
    val d = IntArray(n)

    for (i in 0 until n) {
        st = StringTokenizer(br.readLine())

        a[i] = st.nextInt()
        b[i] = st.nextInt()
        c[i] = st.nextInt()
        d[i] = st.nextInt()
    }

    val max = n * n
    val ab = IntArray(max)
    val cd = IntArray(max)

    var idx = 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            ab[idx] = a[i] + b[j]
            cd[idx++] = c[i] + d[j]
        }
    }

    ab.sort()
    cd.sort()

    var ans = 0L
    var left = 0
    var right = max - 1

    while (left < max && right >= 0) {
        if (ab[left] + cd[right] < 0) left++
        else if (ab[left] + cd[right] > 0) right--
        else {
            var leftCount = 1L
            var rightCount = 1L

            while (left + 1 < max && (ab[left] == ab[left + 1])) {
                leftCount++
                left++
            }

            while (right > 0 && (cd[right] == cd[right - 1])) {
                rightCount++
                right--
            }

            ans += leftCount * rightCount
            left ++
        }

    }
    println(ans)
}

private fun StringTokenizer.nextInt() = nextToken().toInt()
