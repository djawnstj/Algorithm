import Direction.Companion.rotate
import java.io.*
import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readInt()

    val k = br.readInt()

    val apples = Array(n) { BooleanArray(n) }

    repeat(k) {
        val st = StringTokenizer(br.readLine())
        val x = st.nextInt() - 1
        val y = st.nextInt() - 1

        apples[x][y] = true
    }

    val l = br.readInt()

    val directionChanges: Queue<DirectionChange> = LinkedList()

    repeat(l) {
        val st = StringTokenizer(br.readLine())
        val x = st.nextInt()
        val c = st.nextToken()

        directionChanges.add(DirectionChange(x, c))
    }

    val bam: Deque<Bam> = LinkedList()

    var result = 0
    var direction = Direction.RIGHT

    bam.add(Bam(0, 0))

    while (true) {
        result++

        val directionChange = directionChanges.peek()

        val head = bam.peekFirst()
        val nextHead = head.next(direction)

        if (bam.contains(nextHead)) break
        if (nextHead.checkCrush(n)) break

        bam.addFirst(nextHead)

        if (!apples[nextHead.x][nextHead.y]) bam.pollLast()
        else apples[nextHead.x][nextHead.y] = false

        if (directionChange != null && directionChange.time == result) {
            direction = direction.rotate(directionChange.direction)
            directionChanges.poll()
        }
    }

    println(result)

    br.close()
}

enum class Direction(
    val num: Int
) {
    UP(0), RIGHT(1), DOWN(2), LEFT(3);

    companion object {
        fun Direction.rotate(direction: String): Direction {
            val directionTemp = if (direction == "L") num - 1
            else num + 1

            val directionNum = if (directionTemp < 0) 3
            else if (directionTemp >= 4) 0
            else directionTemp

            return values()[directionNum]
        }
    }
}

data class DirectionChange(
    val time: Int,
    val direction: String
)

data class Bam(
    val x: Int,
    val y: Int
) {
    fun next(direction: Direction): Bam {
        return when (direction) {
            Direction.UP -> Bam(x - 1, y)
            Direction.RIGHT -> Bam(x, y + 1)
            Direction.DOWN -> Bam(x + 1, y)
            Direction.LEFT -> Bam(x, y - 1)
        }
    }

    fun checkCrush(n: Int): Boolean = (x < 0 || x >= n || y < 0 || y >= n)
}

private fun BufferedReader.readInt(): Int = readLine().toInt()
private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
private fun String.println() = println(this)
