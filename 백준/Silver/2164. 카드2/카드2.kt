import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()

    val queue: Queue<Int> = LinkedList()

    for (i in 1 .. n) {
        queue.offer(i)
    }

    while (queue.size > 1) {
        queue.poll()
        val poll = queue.poll()
        queue.offer(poll)
    }

    println(queue.poll())
}

fun StringTokenizer.nextInt(): Int = nextToken().toInt()
