package BOJ.Math;
import java.io.*;
import java.util.*;

public class B17425 {
    final static int MAX = 1000001;
    
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        long[] fx = new long[MAX];
        long[] gx = new long[MAX];

        // 1은 반드시 들어감
        Arrays.fill(fx, 1);

        // i는 2부터 n까지 i를 약수로 갖는 모든 수
        for (int i = 2; i < MAX; i++) {
            // j는 i*j까지만 반복
            for (int j = 1; i*j < MAX; j++) {
                fx[i*j] += i;
            }
        }

        // gx, x보다 작거나 같은 모든 자연수 y의 fy를 더한 변수
        for (int i = 1; i < MAX; i++) {
            gx[i] = gx[i-1] + fx[i];
        }

        // 답만 도출
        for (int i = 0; i < n; i++) {
            sb.append(gx[Integer.parseInt(br.readLine())] + "\n");
        }
        System.out.println(sb);
    }    
    public static void main(String[] arg) throws Exception {
        new B17425().solution();
    } 
}
