
class Solution {
    fun solution(array: IntArray): Int {
        if (array.isEmpty()) return -1 else if (array.size == 1) return array[0]
        array.sort()
        var answer = array[0]
        var tempVal = array[0]
        var tempCount = 0
        var count = 0
        array.forEach {
            if (tempVal == it) {
                tempCount++
            } else if (tempVal != it) {
                answer = if (tempCount == count) -1 else if (tempCount > count) {
                    count = tempCount
                    tempVal
                } else answer
                tempVal = it
                tempCount = 1
            }
        }

        answer = if (tempCount == count) -1 else if (tempCount > count) tempVal else answer

        return answer
    }
}