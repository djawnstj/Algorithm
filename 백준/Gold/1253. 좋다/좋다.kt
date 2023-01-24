import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val N = sc.nextInt()
    val arr = IntArray(N)

    for (i in 0 until N) arr[i] = sc.nextInt()
    arr.sort()

    var lt = 0
    var rt = 0

    var result = 0

    for (i in 0 until N) {
        val find = arr[i]
        lt = 0
        rt = N - 1
        while (lt < rt) {
            if (arr[lt] + arr[rt] == find) {
                if (lt != i && rt != i) {
                    result++
                    break
                } else if (lt == i) lt++
                else if (rt == i) rt--
            } else if (arr[lt] + arr[rt] < find) lt++
            else rt--
        }
    }

    println(result)

}

