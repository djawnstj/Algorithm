import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Now{
	int x;
	int time;
	public Now(int _x, int _time) {
		x = _x;time = _time;
	}
}
class Main {
	static boolean[] visited;
	static boolean judge(int next) {
		if(next < 0 || next > 100000 || visited[next]) {return false;}
		return visited[next] = true;
	}
	static void bfs(int start, int end) {
		Queue<Now> q = new LinkedList<>();
		q.add(new Now(start, 0));
		visited[start] = true;
		while(!q.isEmpty()) {
			Now n = q.poll();
			if(n.x == end) {
				System.out.println(n.time);
				return;
			}
			int next1 = n.x * 2;
			int next2 = n.x - 1;
			int next3 = n.x + 1;
			if(judge(next1)) {q.add(new Now(next1, n.time));}
			if(judge(next2)) {q.add(new Now(next2, n.time + 1));}
			if(judge(next3)) {q.add(new Now(next3, n.time + 1));}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		visited = new boolean[100001];
		if(n > k) {System.out.println(n - k);}
		else {
			bfs(n, k);			
		}
	}
}