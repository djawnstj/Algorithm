class Solution {
    fun solution(numer1: Int, denom1: Int, numer2: Int, denom2: Int): IntArray {
        var answer: IntArray = intArrayOf()

        val numer = (numer1 * denom2) + (numer2 * denom1)
        val denom = (denom1 * denom2)

        val gcd = getGcd(numer, denom)

        
        answer += numer/gcd
        answer += denom/gcd

        return answer
    }

    fun getGcd(a: Int, b: Int): Int = if (a % b == 0) b else getGcd(b, a % b)

}