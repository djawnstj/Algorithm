class Solution {
    fun solution(slice: Int, n: Int): Int = Math.ceil(n.toDouble()/slice.toDouble()).toInt()
}