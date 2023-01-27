import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val arr = IntArray(N) { st.nextToken().toInt() }
    val answer = IntArray(N)

    val stack = Stack<Int>()
    stack.push(0)

    for (i in 1 until N) {
        while (stack.isNotEmpty() && arr[stack.peek()] < arr[i]) answer[stack.pop()] = arr[i]
        stack.push(i)
    }

    while (stack.isNotEmpty()) {
        answer[stack.pop()] = -1
    }

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    answer.forEach { bw.write("$it ") }

    bw.write("\n")
    bw.flush()
    bw.close()
}