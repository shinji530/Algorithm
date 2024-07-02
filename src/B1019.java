import java.io.*;

public class B1019 {
    private static final int[] CNT = new int[10];

    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        solution(N);

        StringBuilder sb = new StringBuilder();

        for (int item : CNT) {
            sb.append(item).append(" ");
        }

        bw.write(sb.toString().trim());
        bw.newLine();
        bw.flush();

        br.close();
        bw.close();
    }

    private static void solution(int num) {
        int start = 1;
        int cnt = 1;

        while (start <= num) {
            while (num % 10 != 9 && start <= num) {
                count(num, cnt);
                num --;
            }
            if (num < start) {
                break;
            }
            while (start % 10 != 0 && start <= num) {
                count(start, cnt);
                start++;
            }
            start /= 10;
            num /= 10;

            for (int i = 0; i < 10; i++) {
                CNT[i] += (num - start + 1) * cnt;
            }

            cnt *= 10;
        }
    }
    private static void count(int num, int cnt) {
        while (num >  0) {
            CNT[num % 10] += cnt;
            num /= 10;
        }
    }
}
