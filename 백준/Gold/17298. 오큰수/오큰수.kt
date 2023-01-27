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
    // 오큰수를 담을 배열
    val answer = IntArray(N)

    // 배열의 인덱스를 담을 스택
    val stack = Stack<Int>()
    // 0번째 인덱스 추가
    stack.push(0)

    // 1번 인덱스의 수가 0번 인덱스의 수의 오큰수가 될 수 있는지 확인하면 되기 때문에 1부터 시작
    for (i in 1 until N) {
        // 현재(i)번째 수와 i번째 이전의 수들의 크기를 비교하여 i번째 수가 이전 수들의 오큰수가 될 수 있는지 확인하며 시간복잡도에서 이득
        // 스택의 top에 들어있는 인덱스번째 수보다 i 번째 수가 작으면 스택에 들어있는 다른 인덱스번째 수들에도 오큰수가 될 수 없음
        // 스택의 top에 들어있는 인덱스번째 수와 i번째 수를 계속 비교하며 i 번째 수가 더 크다면 스택의 top에 들어있는 인덱스 번째 수의 오큰수는 i번째 수가 됨
        while (stack.isNotEmpty() && arr[stack.peek()] < arr[i]) answer[stack.pop()] = arr[i]
        // 현재(i)번째 수의 오큰수는 다음(i+1)번째 수부터 확인해야하기 때문에 stack의 top부분에 i를 추가
        stack.push(i)
    }

    // 오큰수를 찾지 못한 인덱스(stack에 남아있는 인덱스)번째는 -1을 넣어줌
    while (stack.isNotEmpty()) {
        answer[stack.pop()] = -1
    }

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    answer.forEach { bw.write("$it ") }

    bw.write("\n")
    bw.flush()
    bw.close()
}
