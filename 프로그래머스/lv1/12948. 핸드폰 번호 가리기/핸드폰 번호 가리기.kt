class Solution {
    fun solution(phone_number: String): String {
        var answer = ""

        phone_number.forEachIndexed { index, c ->
            answer += if (index < phone_number.length-4) "*" else c
        }

        return answer
    }
}