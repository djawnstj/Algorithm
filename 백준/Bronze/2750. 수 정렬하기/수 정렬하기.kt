import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()

    val arr = IntArray(N) { br.readLine().toInt() }

    for (i in 0 until N-1) {
        for (j in 0 until N-1-i) {
            if (arr[j] > arr[j+1]) {
                val temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp
            }
        }
    }

    arr.forEach { println(it) }

}