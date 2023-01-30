class Solution {
    fun solution(array: IntArray): Int {
        val index = (array.size/2)
        array.sort()
        return array[index]
    }
}