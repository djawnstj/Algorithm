class Solution {

    private inner class Char(
        val index: Int,
        val char: kotlin.Char
    )

    fun solution(s: String, skip: String, index: Int): String {
        var answer: String = ""

        var curChar = 96.toChar()
        val chars = Array(26 - skip.length) { index ->
            curChar++
            while (skip.any { it == curChar }) curChar++

            Char(index, curChar)
        }

        s.forEach {  char ->
            var newIndex = ((chars.find { it.char == char }?.index ?: 0) + index)

            while (newIndex > chars.size-1) newIndex -= (chars.size)

            answer += chars[newIndex].char
        }

        return answer
    }
}
