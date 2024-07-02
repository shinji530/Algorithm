package Math;
import java.io.*;
// 4375번
// 2와 5로 나누어 떨어지지 않는 정수 n(1 ≤ n ≤ 10000)가 주어졌을 때, 
// 각 자릿수가 모두 1로만 이루어진 n의 배수를 찾는 프로그램을 작성하시오.

// 11 = 10 * 1 + 1 
// 111 = 10 * 11 + 1  ==> 주어진 숫자가 111로 이루어진 숫자와 나누어 떨어질 때까지 구함

public class B4375 {
    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuilder ans = new StringBuilder();
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            int base = 1;
            int cnt = 1;
            while ((base = base % n) != 0) {
                cnt++;
                base=base*10+1;
            }
            ans.append(cnt).append("\n");
        }
        System.out.print(ans);
    }

    public static void main(String[] arg) throws Exception{
        new B4375().solution();
    }
}
