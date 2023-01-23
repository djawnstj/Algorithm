import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val num = sc.nextInt()
    val q = sc.nextInt()

    val arr = IntArray(num)
    val sumArr = IntArray(num+1)

    for (i in 0 until num) {
        arr[i] = sc.nextInt()
        sumArr[i+1] = sumArr[i] + arr[i]
    }

    for (i in 0 until q) {
        val start = sc.nextInt() - 1
        val end = sc.nextInt()
        println(sumArr[end] - sumArr[start])
    }

}