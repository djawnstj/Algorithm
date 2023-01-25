import java.util.Scanner

val checkArr by lazy { IntArray(4) }
val myArr by lazy { IntArray(4) }
var checkSecret = 0

fun main() {

    val sc = Scanner(System.`in`)

    val S = sc.nextInt()
    val P = sc.nextInt()
    var result = 0

    val A = sc.next().toCharArray()

    for (i in 0 until 4) {
        checkArr[i] = sc.nextInt()
        if (checkArr[i] == 0) checkSecret++
    }

    // 초기 P부분 문자열 처리
    for (i in 0 until P) add(A[i])

    if (checkSecret == 4) result++

    // 슬라이딩 윈도우 처리
    for (i in P until S) {
        val j = i - P
        add(A[i])
        remove(A[j])
        if (checkSecret == 4) result++
    }

    println(result)

}

private fun add(c: Char) {
    when (c) {
        'A' -> {
            myArr[0]++
            if (myArr[0] == checkArr[0]) checkSecret++
        }
        'C' -> {
            myArr[1]++
            if (myArr[1] == checkArr[1]) checkSecret++
        }
        'G' -> {
            myArr[2]++
            if (myArr[2] == checkArr[2]) checkSecret++
        }
        'T' -> {
            myArr[3]++
            if (myArr[3] == checkArr[3]) checkSecret++
        }
    }
}

private fun remove(c: Char) {
    when (c) {
        'A' -> {
            if (myArr[0] == checkArr[0]) checkSecret--
            myArr[0]--
        }
        'C' -> {
            if (myArr[1] == checkArr[1]) checkSecret--
            myArr[1]--
        }
        'G' -> {
            if (myArr[2] == checkArr[2]) checkSecret--
            myArr[2]--
        }
        'T' -> {
            if (myArr[3] == checkArr[3]) checkSecret--
            myArr[3]--
        }
    }
}
