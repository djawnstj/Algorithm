

class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = 0

        words.forEachIndexed { i, cur ->
            val ch = IntArray(words.size)
            ch[i] = 1
            if (check(begin, cur)) {
                val temp = DFS(cur, target, words, 1, ch, i)
                answer = if (answer != 0) Math.min(answer, temp) else temp
            }
        }

        return answer
    }

    private fun DFS(cur: String, target: String, words: Array<String>, count: Int, ch: IntArray, index: Int): Int {
        var result = 0
        ch[index] = 1
        if (cur == target) {
            ch[index] = 0
            return count
        }

        words.forEachIndexed { j, it ->
            if (ch[j] == 0 && check(cur, it)) {
                val temp = DFS(it, target, words, count + 1, ch, j)
                result = if (result != 0) Math.min(result, temp) else temp
            }
        }

        ch[index] = 0
        return result
    }

    private fun check(begin: String, target: String): Boolean {
        var cnt = 0

        begin.forEachIndexed { i, c ->
            if (target[i] == c) cnt ++
        }

        return (cnt == begin.length - 1)
    }
}