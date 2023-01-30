class Solution {
    fun solution(n: Int): IntArray {
        var answer: IntArray = intArrayOf()
        for (i in 0 .. n) {
            if (i.isOdd()) answer += i
        }
        return answer
    }
    
    fun Int.isOdd(): Boolean = ((this%2) == 1)
}