import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

const val POST_OFFICE: Char = 'P'
const val HOUSE: Char = 'K'
const val GROUND: Char = '.'

val DR = intArrayOf(0, 1, 0, -1, 1, -1 ,1, -1)
val DC = intArrayOf(1, 0, -1, 0, 1, -1 ,-1, 1)

data class Pos(
    val r: Int,
    val c: Int,
    val type: Char
) {
    var altitude: Int = -1
    fun isPostOffice() = this.type == POST_OFFICE
    fun isHouse() = this.type == HOUSE
    fun isNotGround() = this.type != GROUND
}

class Main {
    private lateinit var start: Pos
    private lateinit var arr: Array<Array<Pos>>

    private var n = 0
    private var min = 0
    private var max = 0
    private var houseCount = 0

    private lateinit var ts: TreeSet<Int>

    private fun isPossible(low: Int, high: Int): Boolean {
        val v = Array(n) { BooleanArray(n) }
        var remain = houseCount

        val q: Queue<IntArray> = ArrayDeque()
        q.add(intArrayOf(start.r, start.c))
        v[start.r][start.c] = true

        while (q.isNotEmpty()) {
            val cur = q.poll()

            for (d in 0 until 8) {
                val nr = cur[0] + DR[d]
                val nc = cur[1] + DC[d]

                if (nr < 0 || nr >= n || nc < 0 || nc >= n || v[nr][nc]) continue

                val nextAltitude = arr[nr][nc].altitude

                if (nextAltitude < low || nextAltitude > high) continue

                if (arr[nr][nc].isHouse()) {
                    remain--
                }

                if (remain == 0) return true

                v[nr][nc] = true
                q.add(intArrayOf(nr, nc))
            }
        }

        return false
    }

    private fun getAnswer(): Int {
        var low = ts.pollFirst()
        var high = max
        var answer = 1_000_001

        while (low <= min) {
            if (isPossible(low, high)) {
                answer = Math.min(answer, high - low)

                if (ts.isEmpty()) break

                low = ts.pollFirst()
            } else {
                if (ts.isEmpty()) break
                if (ts.higher(high) == null) break

                high = ts.higher(high)
            }
        }

        return answer
    }

    fun solution() {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())

        n = st.nextInt()

        min = 1000001
        max = 0

        arr = Array(n) { r ->
            st = StringTokenizer(br.readLine())
            val row = st.nextToken()
            Array(n) { c ->
                val pos = Pos(r, c, row[c])
                if (pos.isPostOffice()) start = pos
                else if (pos.isHouse()) houseCount++
                pos
            }
        }

        ts = TreeSet()

        for (r in 0 until n) {
            st = StringTokenizer(br.readLine())
            for (c in 0 until n) {
                val height = st.nextInt()
                arr[r][c].altitude = height
                ts.add(height)

                if (arr[r][c].isNotGround()) {
                    min = Math.min(min, height)
                    max = Math.max(max, height)
                }
            }
        }

        println(getAnswer())
    }
}

fun main() {
    Main().solution()
}

private fun StringTokenizer.nextInt() = nextToken().toInt()
