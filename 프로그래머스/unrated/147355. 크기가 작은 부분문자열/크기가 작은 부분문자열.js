function solution(t, p) {
    var answer = 0;

    var lt = 0;
    var rt = p.length - 1;

    var target = Number(p);

    while (rt < t.length) {
        var temp = ""
        for (var i = lt; i <= rt; i++) {
            temp += t[i]
        }
        var tempNum = Number(temp);

        if (tempNum <= target) answer++;
        lt++;
        rt++;
    }

    return answer;
}