// 백준_2564
// 2021.04.11
// 구현, case work
// brute force

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Security {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int square[] = {Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken())};
        st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int[][] shops = new int[N][2];
        int[] home = new int[2];
        int answer = 0;

        for (int i = 0; i < shops.length; i++) {
            st = new StringTokenizer(br.readLine());
            shops[i][0] = Integer.valueOf(st.nextToken());
            shops[i][1] = Integer.valueOf(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        home[0] = Integer.valueOf(st.nextToken());
        home[1] = Integer.valueOf(st.nextToken());

        if (home[0] / 2 <= 1) {
            for (int i = 0; i < shops.length; i++) {
                if(home[0] == shops[i][0])
                    answer += Math.abs(home[1] - shops[i][1]);
                if (home[0] + shops[i][0] == 3) {
                    answer += square[1];
                    answer += Math.min(shops[i][1] + home[1], square[0] * 2 - (shops[i][1] + home[1]));
                } else {
                    if (shops[i][0] == 3) {
                        if (home[0] == 1)
                            answer += shops[i][1];
                        else if (home[0] == 2)
                            answer += (square[1] - shops[i][1]);
                        answer += home[1];
                    } else if (shops[i][0] == 4) {
                        if (home[0] == 1)
                            answer += shops[i][1];
                        else if (home[0] == 2)
                            answer += square[1] - shops[i][1];
                        answer += (square[0] - home[1]);
                    }
                }
            }
        } else {
            for (int i = 0; i < shops.length; i++) {
                if(home[0] == shops[i][0])
                    answer += Math.abs(home[1] - shops[i][1]);
                if (home[0] + shops[i][0] == 7 ) {
                    answer += square[0];
                    answer += Math.min(shops[i][1] + home[1], square[1] * 2 - (shops[i][1] + home[1]));
                } else {
                    if (shops[i][0] == 1) {
                        if (home[0] == 3)
                            answer += shops[i][1];
                        else if (home[0] == 4)
                            answer += (square[0] - shops[i][1]);
                        answer += home[1];
                    } else if (shops[i][0] == 2) {
                        if (home[0] == 3)
                            answer += shops[i][1];
                        else if (home[0] == 4)
                            answer += square[1] - shops[i][1];
                        answer += (square[1] - home[1]);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
