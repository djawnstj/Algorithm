import java.lang.StringBuilder
import java.util.*

fun main() {

    val sc = Scanner(System.`in`)

    val N = sc.nextInt()

    val arr = IntArray(N) { sc.nextInt() }

    val stack = Stack<Int>()
    val answer = StringBuilder()

    var temp = 0

    for (i in 0 until N) {

        while (temp < arr[i]) {
            if (stack.isNotEmpty() && stack.peek() > arr[i]) {
                answer.append("-").append("\n")
                stack.pop()
            } else if (stack.isNotEmpty() && stack.peek() < arr[i]) {
                answer.append("+").append("\n")
                stack.push(++temp)
            } else if (stack.isEmpty()) {
                answer.append("+").append("\n")
                stack.push(++temp)
            }
        }

        if (stack.isNotEmpty() && stack.peek() == arr[i]) {
            answer.append("-").append("\n")
            stack.pop()
        } else {
            println("NO")
            return
        }

    }

    println(answer.toString().trim())

}
