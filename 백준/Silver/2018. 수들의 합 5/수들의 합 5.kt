import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val num = sc.nextInt()

    var result = 0

    for (i in 1 .. num) {
        val lt = i
        var temp = 0
        for (j in i .. num) {
            temp += j
            if (temp > num) break
            else if (temp == num) {
                result++
                break
            }
        }
    }

    println(result)

}

