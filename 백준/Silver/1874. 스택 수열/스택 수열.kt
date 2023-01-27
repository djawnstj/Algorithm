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

        // 수열을 만들어야하는 숫자보다 temp가 같아질때까지 계속 반복(수열을 만들 수랑 같은 수가 stack에 들어갈때까지)
        while (temp < arr[i]) {
            // stack의 마지막 수가 수열을 만들 수보다 큰경우 제거
            if (stack.isNotEmpty() && stack.peek() > arr[i]) {
                answer.append("-").append("\n")
                stack.pop()
            } 
            // stack의 마지막 수가 수열을 만들 수보다 작은경우 temp+1을 stack에 추가
            else if (stack.isNotEmpty() && stack.peek() < arr[i]) {
                answer.append("+").append("\n")
                stack.push(++temp)
            } 
            // stack이 비어있는 경우 temp+1을 stack에 추가
            else if (stack.isEmpty()) {
                answer.append("+").append("\n")
                stack.push(++temp)
            }
        }

        // stack의 마지막 수가 수열을 만들 수와 같으면 stack에서 제거
        if (stack.isNotEmpty() && stack.peek() == arr[i]) {
            answer.append("-").append("\n")
            stack.pop()
        } 
        // stack이 비어있거나, stack의 마지막 수와 수열을 만들 수가 다르면 NO 출력하고 return
        else {
            println("NO")
            return
        }

    }

    println(answer.toString().trim())

}
