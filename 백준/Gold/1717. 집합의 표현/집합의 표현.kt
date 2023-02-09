import java.util.*

lateinit var parent: IntArray

fun main(args: Array<String>) {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    parent = IntArray(n + 1)
    for (i in 0..n) {
        parent[i] = i
    }
    for (i in 0 until m) {
        val q = sc.nextInt()
        val a = sc.nextInt()
        val b = sc.nextInt()
        if (q == 0) {
            union(a, b)
        } else {
            if (checkSame(a, b)) {
                println("YES")
            } else {
                println("NO")
            }
        }
    }
}

fun union(a: Int, b: Int) {
    var a = a
    var b = b
    a = find(a)
    b = find(b)
    if (a != b) {
        parent[b] = a
    }
}

fun find(a: Int): Int {
    return if (a == parent[a]) a else find(parent[a]).also { parent[a] = it }
}

fun checkSame(a: Int, b: Int): Boolean {
    var a = a
    var b = b
    a = find(a)
    b = find(b)
    return a == b
}
