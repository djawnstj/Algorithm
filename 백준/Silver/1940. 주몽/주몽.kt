import java.util.Arrays
import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val N = sc.nextInt()
    val M = sc.nextInt()

    val arr = IntArray(N)

    for (i in 0 until N) arr[i] = sc.nextInt()

    Arrays.sort(arr)

    var lt = 0
    var rt = arr.size - 1

    var result = 0

    while (lt < rt) {
        val sum = arr[lt] + arr[rt]
        if (sum < M) lt++
        else if (sum > M) rt--
        else {
            result++
            lt++
            rt--
        }
    }

    println(result)

}

