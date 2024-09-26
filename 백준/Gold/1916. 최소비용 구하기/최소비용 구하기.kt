import java.util.*

data class Edge(val to: Int, val cost: Int)

fun main() {
    val n = readLine()!!.toInt()  // 도시의 수
    val m = readLine()!!.toInt()  // 버스의 수
    
    val graph = Array(n + 1) { ArrayList<Edge>() }
    
    repeat(m) {
        val (from, to, cost) = readLine()!!.split(" ").map { it.toInt() }
        graph[from].add(Edge(to, cost))
    }
    
    val (start, end) = readLine()!!.split(" ").map { it.toInt() }
    
    val dist = IntArray(n + 1) { Int.MAX_VALUE }
    dist[start] = 0
    
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    pq.offer(Pair(start, 0))
    
    while (pq.isNotEmpty()) {
        val (curr, cost) = pq.poll()
        
        if (cost > dist[curr]) continue
        
        for (edge in graph[curr]) {
            val nextCost = cost + edge.cost
            if (nextCost < dist[edge.to]) {
                dist[edge.to] = nextCost
                pq.offer(Pair(edge.to, nextCost))
            }
        }
    }
    
    println(dist[end])
}
