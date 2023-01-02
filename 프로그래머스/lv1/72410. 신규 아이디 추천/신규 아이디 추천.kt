class Solution {

    fun solution(new_id: String): String {
        var answer: String = ""

        // 1단계 
        answer = new_id.lowercase()

        // 2단계
        val charset = ('a'..'z') + ('0'..'9') + '_' + '-' + '.'

        answer = answer.filter { charset.indexOf(it) >= 0 }

        // 3단계            
        while (true) {
            if (answer.indexOf("..") >= 0) answer = answer.replace("..", ".")
            else break
        }

        // 4단계
        if (answer.startsWith(".")) answer = answer.replaceFirst(".", "")
        answer = answer.replaceLast(".", "")

        // 5단계
        if (answer.isEmpty()) answer = "a"

        // 6단계
        if (answer.length >= 16) answer = answer.substring(0, 15)
        answer = answer.replaceLast(".", "")

        // 7 단계
        while (true) {
            if (answer.length <= 2) answer += answer[answer.length-1]
            if (answer.length >= 3) break
        }

        return answer
    }

    fun String.replaceLast(oldValue: String, newValue: String): String{
        return if (endsWith(oldValue)) dropLast(oldValue.length) + newValue
        else this
    }

}