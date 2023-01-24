import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    val num = sc.nextInt()

    var lt = 1
    var rt = 1

    var sum = 0
    var result = 0

    while (lt <= num) {
        sum += rt
        if (sum >= num) {
            if (sum == num) result++
            lt++
            sum = 0
            rt = lt
        }
        else rt++
    }

//    for (i in 1 .. num) {
//        val lt = i
//        var temp = 0
//        for (j in i .. num) {
//            temp += j
//            if (temp > num) break
//            else if (temp == num) {
//                result++
//                break
//            }
//        }
//    }

    println(result)

}

