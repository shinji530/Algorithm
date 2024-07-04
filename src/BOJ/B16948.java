package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Knight {
    int kx;
    int ky;

    public Knight(int ky, int kx) {
        this.ky = ky;
        this.kx = kx;
    };
}

public class B16948 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static Knight start, end;

    static int[] dx = {-1, 1, -2, 2, -1, 1};
    static int[] dy = {-2, -2, 0, 0, 2, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = new Knight(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        end = new Knight(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        BFS(start);
    }

    public static void BFS(Knight start) {
        Queue<Knight> queue = new LinkedList<>();
        queue.add(start);
        visited[start.ky][start.kx] = true;
        
        while(!queue.isEmpty()) {
            Knight cur = queue.poll();

            for (int i = 0; i < 6; i++) {
                int newKx = cur.kx + dx[i];
                int newKy = cur.ky + dy[i];

                if (newKx >= 0 && newKx < N && newKy >= 0 && newKy < N && !visited[newKy][newKx]) {
                    if (newKx == end.kx && newKy == end.ky) {
                        System.out.println(map[cur.ky][cur.kx] + 1);
                        return;
                    }
                    visited[newKy][newKx] = true;
                    queue.add(new Knight(newKy, newKx));
                    map[newKy][newKx] = map[cur.ky][cur.kx] + 1;
                }
            }
        }
        System.out.println("-1");
    }    
}
