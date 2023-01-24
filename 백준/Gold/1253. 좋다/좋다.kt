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

    for (k in 0 until N) {
        val find = arr[k]
        var i = 0
        var j = N - 1
        while (i < j) {
            if (arr[i] + arr[j] == find) {
                if (i != k && j != k) {
                    result++
                    break
                } else if (i == k) i++
                else if (j == k) j--
            } else if (arr[i] + arr[j] < find) i++
            else j--
        }
    }

    println(result)

}

