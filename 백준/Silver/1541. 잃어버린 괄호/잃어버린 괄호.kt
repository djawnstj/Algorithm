import java.util.*
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val sik = st.nextToken()

    val list = ArrayList<Int>()
    var temp = 0
    var foo = "0"

    sik.forEach {
        if (it == '-') {
            list.add(temp + foo.toInt())
            temp = 0
            foo = "0"
        } else if (it == '+') {
            temp += foo.toInt()
            foo = "0"
        } else {
            foo += it
        }
    }

    list.add(temp + foo.toInt())

    var result = list[0]
    for (i in 1 until list.size) {
        result -= list[i]
    }

    println(result)
}

private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
