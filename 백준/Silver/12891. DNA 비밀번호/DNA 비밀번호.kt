import java.util.Scanner

// 유효한 비밀번호인지 체크하는 조건이 담긴 배열
val checkArr by lazy { IntArray(4) }
// 돌고있는 슬라이딩 윈도우의 문자열에서 체크한 필요 알파벳의 개수를 담은 배열
val myArr by lazy { IntArray(4) }
// 돌고있는 슬라이딩 윈도우의 문자열에서 조건을 만족하는 알파벳 개수
var checkSecret = 0

fun main() {

    val sc = Scanner(System.`in`)

    // DNA 문자열 개수
    val S = sc.nextInt()
    // 암호로 만들 문자열 개수
    val P = sc.nextInt()
    // 조건을 만족하는 암호 개수
    var result = 0

    // DNA 알파벳을 담은 문자열
    val A = sc.next().toCharArray()

    // 암호 입력받기
    for (i in 0 until 4) {
        checkArr[i] = sc.nextInt()
        if (checkArr[i] == 0) checkSecret++
    }

    // 입력받은 문자열의 앞 P개만큼 먼저 체크
    for (i in 0 until P) add(A[i])

    // 알파벳 네개가 모두 조건을 만족하면 암호 개수 +1
    if (checkSecret == 4) result++

    // 2번째 알파벳부터 슬라이딩 윈도우를 돌며 조건 체크
    for (i in P until S) {
        // 이전 슬라이딩 윈도우에서 가장 첫 인덱스를 찾아 제거
        val j = i - P
        // 새로운 슬라이딩 윈도우에서 마지막에 해당하는 인텍스 알파벳 추가
        add(A[i])
        // 이전 슬라이딩 윈도우에서 첫번째 인덱스 알파벳 제거
        remove(A[j])
        // 알파벳 네개가 모두 조건을 만족하면 암호 개수 +1
        if (checkSecret == 4) result++
    }

    println(result)

}

/**
 * 새로 추가된 알파벳이 암호 조건을 만족하는지 확인하는 함수
 * 새로 알파벳이 추가되어 해당 알파벳이 조건을 만족하게 된 경우 +1
 */
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

/**
 * 지나간 알파벳을 제거하는 함수
 * 기존에 암호 조건을 만족하고 있었다면 암호 조건 만족하는 알파벳 개수에서 -1
 */
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
