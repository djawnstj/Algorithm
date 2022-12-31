
class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = intArrayOf()

        val stageMap = HashMap<Int, Stage>()

        // 스테이지 별 실패한 유저 수 구하기
        stages.forEach { stage ->
            for (i in 1..stage) {
                if (i > N) continue
                if (stageMap[i] == null) stageMap[i] = Stage(i, 0, 0)
                if (i < stage) {
                    stageMap[i]!!.players ++
                } else {
                    stageMap[i]!!.players ++
                    stageMap[i]!!.fail ++
                }
            }
        }

        if (stageMap.size != N) {
            for (i in 1 ..N) {
                if (stageMap[i] == null) stageMap[i] = Stage(i, 0, 0)
            }
        }

        stageMap.values.sortedBy { it.stage }.sortedByDescending { (it.getFailureRate()) }.forEach {
            if (it.stage <= N) answer += it.stage
        }

        return answer
    }

    data class Stage(
        val stage: Int,
        var players: Int,
        var fail: Int,
    ) {
        fun getFailureRate(): Double { return (if (fail == 0 || players == 0) 0.0 else (fail.toDouble()/players.toDouble())) }
    }

}