import java.util.*
import java.io.*

/*
1
xyyyyxy

1


1
abca

1

1
abc

2


6
aba
abba
abac
caba
acbccba
abccbca

0
0
1
1
1
1
 */

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val t = st.nextInt()

    for (i in 0 until t) {
        st = StringTokenizer(br.readLine())

        val str = st.nextToken()

        if (str.isPalindrome()) println(0)
        else println(if (str.isSimilarPalindrome()) 1 else 2)
    }

}

private fun String.isSimilarPalindrome(): Boolean {
    return isSimilarPalindrome1() || isSimilarPalindrome2()
}

private fun String.isSimilarPalindrome1(): Boolean {

    var lt = 0
    var rt = length - 1
    var count = 0

    while (lt < rt) {
        if (this[lt] != this[rt]) {
            if (count >= 1) return false

            val curLt = this[lt]
            val curRt = this[rt]
            val nextLt = this[lt + 1]
            val nextRt = this[rt - 1]

            if (curLt == nextRt) rt--
            else if (curRt == nextLt) lt++
            else return false

            count++
        }

        lt++
        rt--
    }

    return true
}

private fun String.isSimilarPalindrome2(): Boolean {

    var lt = 0
    var rt = length - 1
    var count = 0

    while (lt < rt) {
        if (this[lt] != this[rt]) {
            if (count >= 1) return false

            val curLt = this[lt]
            val curRt = this[rt]
            val nextLt = this[lt + 1]
            val nextRt = this[rt - 1]

            if (curRt == nextLt) lt++
            else if (curLt == nextRt) rt--
            else return false

            count++
        }

        lt++
        rt--
    }

    return true
}

private fun String.isPalindrome(): Boolean {

    var lt = 0
    var rt = length - 1

    while (lt < rt) {
        if (this[lt] != this[rt]) return false
        lt++
        rt--
    }

    return true
}

private fun StringTokenizer.nextInt() = nextToken().toInt()
