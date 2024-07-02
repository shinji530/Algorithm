package BOJ.BF;
import java.io.*;
import java.util.*;

public class B1107 {
    static int N, size;
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        size = Integer.parseInt(br.readLine());

        if (size == 0) {
            int count = Math.abs(100 - N);
            System.out.println(Math.min(String.valueOf(N).length(), count));
        } else {
            List<Integer> newButton = new ArrayList<>();
            List<Integer> button = new ArrayList<>();

            String[] split = br.readLine().split(" ");
            for (int i = 0; i < size; i++) {
                newButton.add(Integer.parseInt(split[i]));
            }
            for (int i = 0; i < 10; i++){
                if (!newButton.contains(i)) {
                    button.add(i);
                }
            }
            int count = Math.abs(100 - N);

            int closeNum = 0;
            for (int i = 0; i < 1000000; i++) {
                if ((Math.abs(N-i) + String.valueOf(i).length()) < count) {
                    char[] charArray = String.valueOf(i).toCharArray();
                    boolean broken = false;
                    for (char c : charArray) {
                        if (!button.contains(Integer.parseInt(String.valueOf(c)))) {
                            broken = true;
                            break;
                        }
                    }
                    if (!broken) {
                        closeNum = i;
                        count = Math.abs(N - i) + String.valueOf(closeNum).length();
                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
