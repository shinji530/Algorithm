package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1003 {
    static int zero;
    static int one;
    static int result;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            fibonacci(N);
            sb.append(zero).append(' ').append(one).append('\n');
        }
        System.out.println(sb);
    }

    public static void fibonacci(int N) {
        zero = 1;
        one = 0;
        result = 1;

        for (int i = 0; i < N; i++) {
            zero = one;
            one = result;
            result = zero + one;
        }
    }
}
