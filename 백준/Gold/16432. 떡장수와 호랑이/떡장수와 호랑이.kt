import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

//    var st = StringTokenizer(br.readLine())

    val n = br.readInt()

    val arr = Array(n) {
        val st = StringTokenizer(br.readLine())
        IntArray(st.nextInt()) { st.nextInt() }
    }
    val ch = Array(n) { BooleanArray(9) }

    arr[0].forEach {
        val dducks = ArrayList<Int>()
        val result = dfs(arr, dducks, ch, 0, null)

        if (result) {
            dducks.forEach(::println)
            return
        }
    }

    println("-1")
}

fun dfs(arr: Array<IntArray>, list: MutableList<Int>, ch: Array<BooleanArray>, num: Int, before: Int?): Boolean {

    arr[num].forEachIndexed { index, it ->
        if (ch[num][index]) return@forEachIndexed
        if (before == it) return@forEachIndexed

        ch[num][index] = true

        list.add(it)
        if (list.size == arr.size) return true
        val temp = dfs(arr, list, ch, num + 1, it)
        if (temp) return true
        list.removeLast()

    }

    return false
}


fun StringTokenizer.nextInt(): Int = nextToken().toInt()

fun BufferedReader.readInt(): Int = readLine().toInt()
