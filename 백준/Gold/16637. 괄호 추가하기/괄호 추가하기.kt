import java.io.BufferedReader
import java.util.*
import kotlin.collections.ArrayList

var answer = Int.MIN_VALUE

fun main() {
    val br = System.`in`.bufferedReader()

    val n = br.readLine()

    val operations = ArrayList<Operation>()
    val nums = ArrayList<Int>()

    br.readLine().forEach {
        if (it.isOperation()) {
            operations.add(Operation(it))
            return@forEach
        }

        nums.add(it.digitToInt())
    }

    dfs(nums[0], 0, nums, operations)

    println(answer)

    br.close()
}

private fun dfs(result: Int, operationIndex: Int, nums: List<Int>, operations: List<Operation>) {
    // 주어진 연산자 개수를 초과
    if (operationIndex >= operations.size) {
        answer = Math.max(answer, result)
        return
    }

    // 괄호가 없는 경우
    val temp1 = operations[operationIndex].calc(result, nums[operationIndex + 1])
    dfs(temp1, operationIndex + 1, nums, operations)

    // 괄호가 있는 경우
    if (operationIndex + 1 < operations.size) {
        // result 의 오른쪽에 있는 값을 연산 함.
        val temp2 = operations[operationIndex + 1].calc(nums[operationIndex + 1], nums[operationIndex + 2])

        // 현재 result와 방금 구한 괄호 값을 연산한 결과와 괄호 오른쪽에 존재하는 연산자의 인덱스를 넘김.
        dfs(operations[operationIndex].calc(result, temp2), operationIndex + 2, nums, operations)
    }
}

private fun Char.isOperation(): Boolean = (this == '+' || this == '-' || this == '*')

private fun Operation(operation: Char): Operation {
    return when (operation) {
        '+' -> Plus()
        '-' -> Minus()
        '*' -> Multiply()
        else -> throw RuntimeException()
    }
}

interface Operation {
    fun calc(num1: Int, num2: Int): Int
}

class Plus: Operation {
    override fun calc(num1: Int, num2: Int): Int = num1 + num2
}

class Minus: Operation {
    override fun calc(num1: Int, num2: Int): Int = num1 - num2
}

class Multiply: Operation {
    override fun calc(num1: Int, num2: Int): Int = num1 * num2
}

private fun String.toTokenizer(): StringTokenizer = StringTokenizer(this)
private fun BufferedReader.readInt(): Int = readLine().toInt()
private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
private fun String.println() = println(this)
