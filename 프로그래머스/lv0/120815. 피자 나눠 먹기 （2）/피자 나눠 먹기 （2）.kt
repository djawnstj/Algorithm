class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        val gcd = getGcd(n, 6)
        
        return (n)/gcd
    }
    
    fun getGcd(n1: Int, n2: Int): Int {
        return if (n2 == 0) n1 else getGcd(n2, n1%n2)
    }
    
}