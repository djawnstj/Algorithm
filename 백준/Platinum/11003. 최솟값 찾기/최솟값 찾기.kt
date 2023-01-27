import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val L = st.nextToken().toInt()

    // Deque: 앞/뒤 양쪽으로 값을 추가하거나 삭제할 수 있음
    val deq: Deque<Node> = ArrayDeque(N)

    st = StringTokenizer(br.readLine())

    // N개의 수만큼 받아서 바로 비교함으로써, 시간복잡도를 줄일 수 있음
    for (i in 0 until N) {
        val cur = st.nextToken().toInt()

        // 최소값을 구하는 문제이므로, 현재 deque 내에서 입력받은 값보다 큰 값이 존재하면 삭제하면서 정렬 효과를 냄
        while (deq.isNotEmpty() && deq.last.value >= cur) deq.removeLast()

        // deque의 최대값으로 최근 입력받은 값 추가
        deq.addLast(Node(i, cur))

        // 가장 첫번째 값이 현재 index로부터 L 이상 멀어졌으면 슬라이딩 윈도우를 벗어난것이므로 가장 첫번째 값 삭제
        if (deq.first.index <= i - L) deq.removeFirst()

        // 가장 첫번째 값이 최소값이므로 첫번째 값을 공백과 함께 문자열에 추가
        bw.write(deq.first.value.toString() + " ")
    }

    bw.flush()
    bw.close()

}

class Node(
    val index: Int,
    val value: Int
)

