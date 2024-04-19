import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws Exception {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		final int n = Integer.parseInt(st.nextToken());
		final int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		final ArrayList<Integer>[] graph = new ArrayList[n];
		final long[] comps = new long[n];

		for (int i = 0; i < n; i++) {
			final int upperNum = Integer.parseInt(st.nextToken());
			graph[i] = new ArrayList<>();
			comps[i] = 0;

			if (upperNum == -1) {
				continue;
			}

//			arr[upperNum - 1].lowers.add(emp);
			graph[upperNum - 1].add(i);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			final int num = Integer.parseInt(st.nextToken()) - 1;
			final long comp = Long.parseLong(st.nextToken());

			comps[num] += comp;
//			dfs(arr[num - 1], comp);
		}

		dfs(comps, graph, 0);

		for (final long comp : comps) System.out.print(comp + " ");
	}

	private static void dfs(long[] comps, ArrayList<Integer>[] graph, int num) {
		graph[num].forEach(child -> {
			comps[child] += comps[num];
			dfs(comps, graph, child);
		});
	}

}
