
class Solution {

    companion object {
        private lateinit var ch: IntArray
    }

    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0

        ch = IntArray(n)

        for (i in 0 until n) {
            if (ch[i] == 0) {
                DFS(computers, ch, i)
                answer++
            }
        }

        return answer
    }

    private fun DFS(computers: Array<IntArray>, ch: IntArray, i: Int) {
        ch[i] = 1

        computers.forEachIndexed { j, com ->
            if (ch[j] == 0 && com[i] == 1) DFS(computers, ch, j)
        }
    }
}