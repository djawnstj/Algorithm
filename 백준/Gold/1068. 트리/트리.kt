import java.util.*
import java.io.*
import kotlin.collections.ArrayList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val n = st.nextInt()

    val arr = Array<Node?>(n) { Node(it) }

    st = StringTokenizer(br.readLine())

    lateinit var root: Node

    for (i in 0 until n) {
        val parentNum = st.nextInt()
        val curNode = arr[i]

        curNode!!.parent = parentNum
        if (parentNum != -1) arr[parentNum]?.children?.add(curNode)
        else root = curNode
    }

    st = StringTokenizer(br.readLine())

    val removeNode = st.nextInt()

    val removedNode = arr[removeNode]!!
    if (!removedNode.isRoot()) arr[removedNode.parent]!!.children.remove(removedNode)
    arr[removeNode] = null

    val result = arr[root.num]?.let { dfs(arr, it, 0) } ?: run { 0 }

    println(result)
}

fun dfs(nodes: Array<Node?>, curNode: Node, leafNodes: Int): Int {
   if (curNode.isLeaf()) return 1

    var result = leafNodes

    curNode.children.forEach {
        if (nodes[it.num] == null) return@forEach

        result += dfs(nodes, it, leafNodes)
    }

    return result
}

data class Node(
    val num: Int,
    var parent: Int = -1,
    val children: ArrayList<Node> = arrayListOf()
) {
    fun isLeaf(): Boolean = this.children.isEmpty()
    fun isRoot(): Boolean = this.parent == -1
}

private fun BufferedReader.readInt(): Int = readLine().toInt()

private fun StringTokenizer.nextInt(): Int = nextToken().toInt()
