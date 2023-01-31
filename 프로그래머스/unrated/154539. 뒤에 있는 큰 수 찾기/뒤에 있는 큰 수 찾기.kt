import java.util.*

class Solution {
    fun solution(numbers: IntArray): IntArray {
        val answer: IntArray = IntArray(numbers.size) { -1 }
        val stack = Stack<Int>()
        stack.push(0)

        for (i in 1 until numbers.size) {
            val cur = numbers[i]
            while (stack.isNotEmpty() && numbers[stack.peek()] < cur) answer[stack.pop()] = numbers[i]
            stack.push  (i)
        }

        return answer
    }
}