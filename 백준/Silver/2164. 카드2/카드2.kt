import java.util.*

fun main() {

    val sc = Scanner(System.`in`)
    val N = sc.nextInt()

    val queue: Queue<Int> = LinkedList()

    for (i in 1 .. N) queue.add(i)

    while (queue.size > 1) {
        queue.poll()
        queue.add(queue.poll())
    }

    println(queue.peek())

}
