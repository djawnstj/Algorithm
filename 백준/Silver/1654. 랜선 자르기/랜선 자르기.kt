import java.io.BufferedReader
import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val tokenizer = br.readLine().toTokenizer()

    val k = tokenizer.nextInt()
    val n = tokenizer.nextInt()

    val arr = LongArray(k) { br.readInt().toLong() }
    val totalLength:Long  = arr.sumOf { it }

    var maxLength:Long = totalLength.toLong() / n
    var minLength:Long = 0
    var newLength:Long = (maxLength + minLength) / 2

    while (newLength != maxLength && newLength != minLength) {
        val num = check(arr, newLength)

        if (num >= n) {
            minLength = newLength
        } else {
            maxLength = newLength
        }
        newLength = (maxLength + minLength) / 2

    }

    if (newLength < maxLength) {
        val num = check(arr, maxLength)

        if (num >= n) {
            newLength = maxLength
        }
    }

    println(newLength)
}

private fun check(arr: LongArray, length: Long): Long {
    return arr.sumOf {
        val calc = calc(it, length)


        return@sumOf calc
    }
}
private fun calc(original: Long, to: Long): Long = original / to

private fun String.toTokenizer(): StringTokenizer = StringTokenizer(this)
private fun BufferedReader.readInt(): Int = readLine().toInt()
private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
private fun String.println() = println(this)
