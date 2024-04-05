import java.util.*
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()
    val m = st.nextInt()

    if (m == 0) {
        println(0)
        return
    }

    val classes = Array(n) { classNum ->
        st = StringTokenizer(br.readLine())

        (Array(m) { Player(classNum, st.nextInt()) }).apply { sort() }
    }

    val q: Queue<Player> = PriorityQueue()

    val arr = IntArray(n)
    var max = Int.MIN_VALUE
    var result = Int.MAX_VALUE

    for (i in 0 until n) {
        val player = classes[i][0]
        q.add(player)

        max = Math.max(max, player.power)
    }

    while (true) {
        val minPlayer = q.poll()

        result = Math.min(result, max - minPlayer.power)

        if (++arr[minPlayer.classNum] == m) break
        val nextPlayer = classes[minPlayer.classNum][arr[minPlayer.classNum]]
        q.add(nextPlayer)

        max = Math.max(max, nextPlayer.power)
    }

    println(result)

}

data class Player(val classNum: Int, val power: Int): Comparable<Player> {
    override fun compareTo(other: Player): Int {
        return this.power - other.power
    }
}

private fun StringTokenizer.nextInt() = nextToken().toInt()
