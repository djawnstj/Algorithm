import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()
    val m = st.nextInt()

    val A = ArrayList<ArrayList<Int>>()
    val inte = IntArray(n + 1)

    (0 .. n).forEach { A.add(ArrayList()) }

    for (i in 0 until m) {
        st = StringTokenizer(br.readLine())

        val a = st.nextInt()
        val b = st.nextInt()

        A.get(a).add(b)
        inte[b]++
    }

    val queue: Queue<Int> = LinkedList()

    A.forEachIndexed { index, value ->
        if (index == 0) return@forEachIndexed

        if (inte[index] == 0) queue.add(index)
    }

    val result = StringBuilder()

    while (queue.isNotEmpty()) {
        val current = queue.poll()

        result.append(current).append(" ")

        A.get(current).forEach {
            inte[it]--
            if (inte[it] == 0) queue.add(it)
        }
    }

    println(result.trim().toString())
}


private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
