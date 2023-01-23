import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val num = sc.nextInt()
    val q = sc.nextInt()

    val arr = Array(num + 1) { IntArray(num + 1) }
    val sumArr = Array(num + 1) { IntArray(num + 1) }

    for (i in 1 .. num) {
        for (j in 1 .. num) {
            val temp = sc.nextInt()
            arr[i][j] = temp
            sumArr[i][j] = sumArr[i][j - 1] + sumArr[i-1][j] - sumArr[i - 1][j - 1] + arr[i][j]
        }
    }

    for (i in 0 until q) {
        val startX = sc.nextInt()
        val startY = sc.nextInt()
        val endX = sc.nextInt()
        val endY = sc.nextInt()
        println(sumArr[endX][endY] - sumArr[startX - 1][endY] - sumArr[endX][startY - 1] + sumArr[startX - 1][startY - 1])
    }

}

