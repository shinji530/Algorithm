package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B2149 {
    static char[][] arr;
    static char[] cipherArr;
    static char[] origin;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String cipher = br.readLine();
        String input = br.readLine();

        arr = new char[(input.length() / cipher.length()) + 1][cipher.length()];
        cipherArr = new char[cipher.length()];
        origin = new char[cipher.length()];

        for (int i = 0; i < cipher.length(); i++) {
            origin[i] = cipher.charAt(i);
            cipherArr[i] = cipher.charAt(i);
        }

        int index = 0;
        for (int i = 0; i < cipher.length(); i++) {
            for (int j = 1; j <= (input.length() / cipher.length()); j++) {
                arr[j][i] = input.charAt(index++);
            }
        }

        Arrays.sort(cipherArr);
        for (int i = 0; i < cipher.length(); i++) {
            arr[0][i] = cipherArr[i];
        }

        visited = new boolean[cipher.length()];

        for (int i = 1; i < arr.length; i++) {
            for (int k = 0; k < cipher.length(); k++) {
                for (int j = 0; j < cipher.length(); j++) {
                    if (!visited[j] && origin[k] == arr[0][j]) {
                        visited[j] = true;
                        bw.write(arr[i][j]);
                        break;
                    }
                }
            }
            for (int k = 0; k < cipher.length(); k++) {
                visited[k] = false;
            }
        }

        br.close();
        bw.close();
    }
}
