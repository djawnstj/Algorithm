import java.util.*
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()

    val arr = Array(n) { x ->
        st = StringTokenizer(br.readLine())
        Array(3) { y -> Point(x, y, st.nextInt()) }
    }

    val dis = intArrayOf(-1, 0, 1)

    arr.forEachIndexed { index, points ->
        if (index == 0) {
            points.forEach {
                it.max = it.origin
                it.min = it.origin
            }
        } else {
            val prePoints = arr[index - 1]

            points.forEach { point ->
                dis.forEach { distance ->
                    val newY = point.y + distance
                    if (newY < 0 || newY >= 3) return@forEach

                    val prePoint = prePoints[newY]
                    point.max = Math.max(point.max, point.origin + prePoint.max)
                    point.min = Math.min(point.min, point.origin + prePoint.min)
                }
            }
        }


        if (index == n - 1) {
            val max = points.maxBy(Point::max).max
            val min = points.minBy(Point::min).min

            println("$max $min")
        }
    }

}

data class Point(
    val x: Int,
    val y: Int,
    val origin: Int,
    var max: Int = Int.MIN_VALUE,
    var min: Int = Int.MAX_VALUE
)

private fun BufferedReader.readInt(): Int = readLine().toInt()

private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
