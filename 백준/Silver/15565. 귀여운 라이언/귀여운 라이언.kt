import java.util.*
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()
    val k = st.nextInt()

    st = StringTokenizer(br.readLine())
    val temp = IntArray(n)
    val arr = IntArray(3)

    var lt = 0
    var cur = 0
    var result = Int.MAX_VALUE

    for (i in 0 until n) {
        val curDoll = st.nextInt()
        arr[curDoll]++
        temp[i] = curDoll

        if (curDoll == 1 && arr[curDoll] == k) {
            while (true) {
                val preDoll = temp[lt++]
                arr[preDoll]--
                if (preDoll == curDoll) break
            }
            result = Math.min(result, (i - lt + 2))
        }
    }

    if (result == Int.MAX_VALUE) println(-1)
    else println(result)

}

private fun BufferedReader.readInt(): Int = readLine().toInt()

private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
