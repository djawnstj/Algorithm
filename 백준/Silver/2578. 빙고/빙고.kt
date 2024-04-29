import java.io.*
import java.util.*

private val disX = intArrayOf(1, 0, -1, 0)
private val disY = intArrayOf(0, 1, 0, -1)
private var cheese: Int = 0

fun main() {
    val br = System.`in`.bufferedReader()
    lateinit var st: StringTokenizer

    val bingo = Array(5) {
        st = StringTokenizer(br.readLine())
        IntArray(5) { st.nextInt() }
    }

    var result = 0

    repeat(5) {
        st = StringTokenizer(br.readLine())
        repeat(5) {
            result++
            check(bingo, st.nextInt())
            val count = count(bingo)

            if (count >= 3) {
                println(result)
                br.close()
                return
            }
        }
    }

    br.close()
}

private fun check(bingo: Array<IntArray>, value: Int) {
    repeat(5) { x ->
        repeat(5) { y ->
            if (bingo[x][y] != value) return@repeat

            bingo[x][y] = -1
            return
        }
    }
}

private fun count(bingo: Array<IntArray>): Int {
    var count = 0
    var rowBingo = 0
    var colBingo = 0
    var xyBingo = 0
    var yxBingo = 0
    var index = 0

    repeat(5) { x ->
        rowBingo = 0
        colBingo = 0

        repeat(5) { y ->
            rowBingo += bingo[x][y]
            colBingo += bingo[y][x]

            if (x == y) xyBingo += bingo[x][y]

            if (x == index && y == 4 - index) {
                yxBingo += bingo[x][y]
                index++
            }
        }

        if (rowBingo == -5) count++

        if (colBingo == -5) count++

        if (xyBingo == -5) count++

        if (yxBingo == -5) count++
    }


    return count
}

private fun BufferedReader.readInt(): Int = readLine().toInt()
private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
private fun String.println() = println(this)
