
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        ArrayList<Room> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Room(Integer.parseInt(st.nextToken()), 's'));
            arr.add(new Room(Integer.parseInt(st.nextToken()), 'e'));
        }

        Collections.sort(arr);

        int cnt = 0, answer = Integer.MIN_VALUE;

        for (Room room : arr) {

            if (room.state == 's') cnt++;
            else cnt--;

            answer = Math.max(cnt, answer);
        }

        System.out.println(answer);

    }


    static class Room implements Comparable<Room> {

        final int time;
        final char state;

        public Room(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Room o) {
            if (this.time == o.time) return this.state - o.state;
            return this.time - o.time;
        }
    }

}

