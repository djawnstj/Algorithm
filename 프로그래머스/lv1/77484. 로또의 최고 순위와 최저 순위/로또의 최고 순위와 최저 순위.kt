

class Solution {

    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer: IntArray = intArrayOf()

        var check = 0
        var what = 0

        lottos.sort()
        win_nums.sort()

        lottos.forEach {
            if (it == 0) {
                what++
                return@forEach
            }
            if (win_nums.indexOf(it) >= 0) check++
        }

        val best = when (check + what) {
            6 -> 1
            5 -> 2
            4 -> 3
            3 -> 4
            2 -> 5
            else -> 6
        }
        val worst = when (check) {
            6 -> 1
            5 -> 2
            4 -> 3
            3 -> 4
            2 -> 5
            else -> 6
        }

        answer += best
        answer += worst

        return answer
    }
}