
class Solution {

    companion object {
        var count = 0
    }

    fun solution(numbers: IntArray, target: Int): Int {
        DFS(numbers, target, 0, 0)
        return count
    }

    private fun DFS(numbers: IntArray, target: Int, sum: Int, index: Int) {

        if (numbers.size == index) {
            if (target == sum) count ++
            return
        }

        DFS(numbers, target, sum + numbers[index], index + 1)
        DFS(numbers, target, sum - numbers[index], index + 1)

    }

}