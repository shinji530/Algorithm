package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 //implementation
public class B1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] king = st.nextToken().toCharArray();
        char[] stone = st.nextToken().toCharArray();
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            char[] k_pos = king.clone();
            char[] s_pos = stone.clone();
            move(line, k_pos);
            if (range(k_pos)) 
                continue;
            if (Arrays.equals(k_pos, s_pos)) {
                move(line, s_pos);
                if (range(s_pos)) 
                    continue;
            }
            king = k_pos;
            stone = s_pos;
        }
        System.out.println(king);
        System.out.println(stone);
    }
    
    public static boolean range(char[] nxt) {
        return (nxt[0] < 'A' || nxt[0] > 'H' || nxt[1] < '1' || nxt[1] > '8');
    } 

    public static void move(String pos, char[] nxt) {
        switch (pos) {
            case "R": nxt[0]++; break;
            case "L": nxt[0]--; break;
            case "T": nxt[1]++; break;
            case "B": nxt[1]--; break;
            case "RT": nxt[0]++;nxt[1]++;break;
            case "LT": nxt[0]--;nxt[1]++;break;
            case "RB": nxt[0]++;nxt[1]--;break;
            case "LB": nxt[0]--;nxt[1]--;break;
        }
    }
}
