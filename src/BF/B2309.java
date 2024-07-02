package BF;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2309 {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 난쟁이 9명
        int [] arr = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
            sum += arr[i];
        }

        // 정렬
        Arrays.sort(arr);

        int a = 0, b = 0;

        // BF 방식으로 색출
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    a = i;
                    b = j;
                    break;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i != a && i != b) {
                System.out.println(arr[i]);
            }
        }

    }
    public static void main(String[] arg) throws Exception {
        new B2309().solution();
    }
}
