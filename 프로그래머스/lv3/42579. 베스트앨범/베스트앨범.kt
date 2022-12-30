class Solution {

    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = intArrayOf()

        val genreMap = HashMap<String, MutableList<Song>>()
        val genrePlayMap = HashMap<String, Int>()

        genres.forEachIndexed { index, genre ->

            genreMap[genre]?.add(Song(index, plays[index])) ?: run { genreMap[genre] = mutableListOf();  genreMap[genre]?.add(Song(index, plays[index])) }

            genrePlayMap[genre]?.let { genrePlayMap[genre] = genrePlayMap[genre]!! + plays[index] } ?: let { genrePlayMap[genre] = plays[index] }

        }

        genreMap.forEach { 
            it.value.sortBy{ it.no }
            it.value.sortByDescending { it.play }
        }

        genrePlayMap.toList().sortedByDescending { (_, value) -> value}.toMap().forEach { 
            val genre = it.key
            
            genreMap[genre]?.forEachIndexed { index, song -> 
                if (index > 1) return@forEachIndexed
                answer += song.no
            }
        }

        return answer
    }

    data class Song(
        val no: Int,
        val play: Int
    ) {

    }

}