class Solution {
    fun solution(s: String): Boolean = (s.isNumeric() && (s.length == 4 || s.length == 6))
    
    fun String.isNumeric(): Boolean {
        return try {
            toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }
}