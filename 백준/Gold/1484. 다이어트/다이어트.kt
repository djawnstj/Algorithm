import java.io.BufferedReader
import java.util.StringTokenizer
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val br = System.`in`.bufferedReader()
    val g = br.nextInt()
    val gDouble = g.toDouble()

    val result = mutableListOf<Int>()
    val max = sqrt(gDouble + (gDouble / 2).pow(2))
    repeat(max.toInt() + 1) { rt ->
        for (lt in 1 until rt) {
            if ((rt * rt) - (lt * lt) == g) {
                result += rt
                return@repeat
            }
        }
    }

    if (result.isEmpty()) println("-1")
    else println(result.joinToString(separator = "\n"))
}

private fun BufferedReader.nextInt(): Int = readLine().toInt()

private fun BufferedReader.nextIntPair(): Pair<Int, Int> = StringTokenizer(readLine()).let { it.nextInt() to it.nextInt() }

private fun BufferedReader.nextIntArray(): IntArray {
    val st = StringTokenizer(readLine())
    val n = st.countTokens()

    return IntArray(n) { st.nextInt() }
}

private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
