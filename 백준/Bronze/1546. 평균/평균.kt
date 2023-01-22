import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    var maxVal = 0.0

    val num = sc.nextInt()
    val numArr = DoubleArray(num)

    var sum = 0.0

    for (i in 0 until num) {
        val temp = sc.nextInt().toDouble()
        numArr[i] = temp
        maxVal = maxVal.coerceAtLeast(temp)
    }

    numArr.forEach { sum += it/maxVal*100 }

    println(sum/num.toDouble())

}