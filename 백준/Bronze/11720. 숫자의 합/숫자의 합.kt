import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val num = sc.nextInt()
    val numStr = sc.next()
    val answer = numStr.sum()

    print(answer)
}

private fun String.sum(): Int {
    var result = 0
    forEach { result += it.digitToInt() }
    return result
}