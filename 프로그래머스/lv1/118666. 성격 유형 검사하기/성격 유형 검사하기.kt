

class Solution {

    private val map = hashMapOf<String, Int>(("R" to 0), ("T" to 0), ("F" to 0), ("C" to 0), ("M" to 0), ("J" to 0), ("A" to 0), ("N" to 0))

    fun solution(survey: Array<String>, choices: IntArray): String {

        var answer: String = ""

        survey.forEachIndexed { index, q ->
            val temp = choices[index]
            if (temp == 4) return@forEachIndexed
            val (score, key) = when {
                (temp < 4) -> (4 - temp to q[0].toString())
                (temp > 4) -> (temp - 4 to q[1].toString())
                else -> (0 to "")
            }
            map[key] = (map[key]?: 0) + score
        }.run {
            answer = "${appendAnswer("R", "T")}${appendAnswer("F", "C")}${appendAnswer("M", "J")}${appendAnswer("A", "N")}"
        }

        return answer
    }

    private fun appendAnswer(first: String, second: String): String {
        return if ((map[first] ?: 0) > (map[second] ?: 0)) first
        else if ((map[first] ?: 0) < (map[second] ?: 0)) second
        else arrayOf(first, second).minOf { it }
    }
    
}