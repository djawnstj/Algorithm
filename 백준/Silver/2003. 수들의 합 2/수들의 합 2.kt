import java.io.BufferedReader
import java.util.StringTokenizer

/*
4 2
1 1 1 1
answer: 3

10 5
1 2 3 4 2 5 3 1 1 2
answer: 3

4 101
99 1 1 99
answer: 2

4 6
2 3 5 4
answer: 0

3 2
1 3 1
answer: 0

1 1
1
answer: 1

3 46
2 23 23
answer: 1

3 1
1 2 1
answer: 2

5 2
5 2 1000 1 1
answer: 2

6 13
2 3 5 7 11 13
answer: 1

* */

fun main() {
    val bf = System.`in`.bufferedReader()

    val (n, m) = bf.nextIntPair()
    val a = bf.nextIntArray()

    var lt = 0
    var rt = 1

    var sum = a[0]
    var result = 0

    while (rt < n && lt < rt) {
        while (sum >= m && lt <= rt) {
            if (sum >= m) {
                if (sum == m) result++
                sum -= a[lt++]
                continue
            }
        }

        if (rt < n) {
            sum += a[rt++]
        }
    }

    while (lt < rt - 1) {
        if (sum == m) result++
        sum -= a[lt++]
        continue
    }

    if (sum == m) result++

    println(result)
}

private fun BufferedReader.nextIntPair(): Pair<Int, Int> = StringTokenizer(readLine()).let { it.nextInt() to it.nextInt() }

private fun BufferedReader.nextIntArray(): IntArray {
    val st = StringTokenizer(readLine())
    val n = st.countTokens()

    return IntArray(n) { st.nextInt() }
}

private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
