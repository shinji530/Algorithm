package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B23364 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            Long x = Long.parseLong(st.nextToken());
            if (!map.containsKey(x)) {
                map.put(x, i);
            } else {
                System.out.println(map.get(x) + " " + i);
                return;
            }
        }
    }
}
