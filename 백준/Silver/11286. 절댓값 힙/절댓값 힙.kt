import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    PriorityQueue<Int>(Collections.reverseOrder())

    val queue: Queue<Int> = PriorityQueue() { o1, o2 ->
        val f = abs(o1)
        val s = abs(o2)

        return@PriorityQueue if (f == s && o1 > o2) 1 else if (f == s && o1 <= o2) -1 else f-s
    }

    for (i in 0 until N) {
        val x = br.readLine().toInt()

        if (x == 0) {
            if (queue.isEmpty()) println(0) else println(queue.poll().toString())
        } else queue.add(x)
    }

}
