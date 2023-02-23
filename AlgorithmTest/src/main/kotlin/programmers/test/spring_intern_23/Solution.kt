package programmers.test.spring_intern_23

class Solution {
}

fun main() {

    val arr1 = arrayOf(".....####", "..#...###", ".#.##..##", "..#..#...", "..#...#..", "...###...")
    val arr2 = arrayOf(".#.", "#..", ".#.")
    val arr3 = arrayOf("####", "##.#", ".#.#")

    val result = Solution2().solution(arr1)
    println(result)

}

class Solution1 {

    fun main() {
        // 1. 당첨 확률이 가장 높으면서
        // 2. 당첨 금액이 가장 높은 복권 구매하기

        // 당첨자 수, 복권 구매자 수, 당첨 금액
        val arr1 = arrayOf(intArrayOf(100, 100, 500), intArrayOf(1000, 1000, 100))
        val arr2 = arrayOf(intArrayOf(10, 19, 800), intArrayOf(20, 39, 200), intArrayOf(100, 199, 500))
        val arr3 = arrayOf(intArrayOf(50, 1, 50), intArrayOf(100, 199, 100), intArrayOf(1, 1, 500))

        Solution1().solution(arr3)
    }

    fun solution(lotteries: Array<IntArray>): Int {
        if (lotteries.size == 1) return 1
        var answer: Int = 0
        Array(lotteries.size) { index ->
            lotteries[index].let { Lottery(index + 1, it[0], it[1], it[2]) }
        }.sortedByDescending { it.winningProbability }
            .let { list ->
                list
                    .filter { list[0].winningProbability == it.winningProbability }
                    .sortedByDescending { it.winningMoney }
                    .let { answer = it[0].index }
            }

        return answer
    }

    private inner class Lottery(
        val index: Int,
        private val winnersNum: Int,
        private val buyersNum: Int,
        val winningMoney: Int
    ) {
        val winningProbability: Double
            get() = if (calcWinningProbability() <= 100) calcWinningProbability() else 100.0

        fun calcWinningProbability(): Double {
            return (winnersNum.toDouble())/(buyersNum+1).toDouble() * 100
        }
    }

}
/*

class Solution2 {

    fun main() {
        // 주어진 1차원 문자열 배열
        // .과 #으로 이루어진 문자열
        // #의 8방향으로 인접한 또다른 #이 있다면 선이 되고 선이 닫히면 도형으로 간주
        // 도형의 넓이를 구하라

        // .과 #으로 이루어진 1차원 문자열 배열이 주어질 때, #의 8방향으로 인접한 또다른 #이 있다면 선이 된다. 선의 길이를 구하는 알고리즘을 구하라


        // 1. #을 찾는다
        // 2. #의 8방향으로 인접한 또다른 #이 있는지 확인한다
        // 3. #의 8방향으로 인접한 또다른 #이 있다면 선이 된다
        // 4. 선의 길이를 구한다

        arrayOf(".....####", "..#...###", ".#.##..##", "..#..#...", "..#...#..", "...###...")
        arrayOf(".#.", "#..", ".#.")
        arrayOf("####", "##.#", ".#.#")

    }

    companion object {
        lateinit var checkedArr: Array<Int>
    }

    fun solution(grid: Array<String>): Int {
        var answer: Int = 0
        checkedArr = Array(grid.size) { 0 }

        grid.forEachIndexed { index, s ->
            s.forEachIndexed { index2, c ->
                if (c == '#') {
                    if (checkedArr[index] and (1 shl index2) == 0) {
                        answer += dfs(grid, index, index2)
                    }
                }
            }
        }

        return answer
    }

    fun dfs(grid: Array<String>, x: Int, y: Int): Int {
        if (x < 0 || x >= grid.size || y < 0 || y >= grid[0].length) return 0
        if (grid[x][y] == '.') return 0
        if (checkedArr[x] and (1 shl y) != 0) return 0

        checkedArr[x] = checkedArr[x] or (1 shl y)

        var result = 1
        result += dfs(grid, x - 1, y - 1)
        result += dfs(grid, x - 1, y)
        result += dfs(grid, x - 1, y + 1)
        result += dfs(grid, x, y - 1)
        result += dfs(grid, x, y + 1)
        result += dfs(grid, x + 1, y - 1)
        result += dfs(grid, x + 1, y)
        result += dfs(grid, x + 1, y + 1)

        return result
    }

}
*/

class Solution2 {

    fun main() {
        // 주어진 1차원 문자열 배열
        // .과 #으로 이루어진 문자열
        // #의 8방향으로 인접한 또다른 #이 있다면 선이 되고 선이 닫히면 도형으로 간주
        // 도형의 넓이를 구하라

        // .과 #으로 이루어진 1차원 문자열 배열이 주어질 때, #의 8방향으로 인접한 또다른 #이 있다면 선이 된다. 선의 길이를 구하는 알고리즘을 구하라


        // 1. #을 찾는다
        // 2. #의 8방향으로 인접한 또다른 #이 있는지 확인한다
        // 3. #의 8방향으로 인접한 또다른 #이 있다면 선이 된다
        // 4. 선의 길이를 구한다

        arrayOf(".....####", "..#...###", ".#.##..##", "..#..#...", "..#...#..", "...###...")
        arrayOf(".#.", "#..", ".#.")
        arrayOf("####", "##.#", ".#.#")

    }

    companion object {
        lateinit var checkedArr: Array<IntArray>
    }

    fun solution(grid: Array<String>): Int {
        var answer: Int = 0
        checkedArr = Array(grid.size) { IntArray(grid[0].length) { 0 } }

        grid.forEachIndexed { index, s ->
            s.forEachIndexed { index2, c ->
                if (c == '#') {
                    if (checkedArr[index][index2] == 0) {
                        answer += dfs(grid, index, index2)
                    }
                }
            }
        }

        return answer

    }

    fun dfs(grid: Array<String>, x: Int, y: Int): Int {
        if (x < 0 || x >= grid.size || y < 0 || y >= grid[0].length) return 0
        if (grid[x][y] == '.') return 0
        if (checkedArr[x][y] != 0) return 0

        checkedArr[x][y] = 1

        var result = 1
        result += dfs(grid, x - 1, y - 1)
        result += dfs(grid, x - 1, y)
        result += dfs(grid, x - 1, y + 1)
        result += dfs(grid, x, y - 1)
        result += dfs(grid, x, y + 1)
        result += dfs(grid, x + 1, y - 1)
        result += dfs(grid, x + 1, y)
        result += dfs(grid, x + 1, y + 1)

        return result
    }

}