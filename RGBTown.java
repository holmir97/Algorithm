// 백준_1149
// 2021.04.07
// Dynamic Programming

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class RGBTown {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());

        int[][] cost = new int[N][3];
        int[][] memory = new int[N][3];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.valueOf(st.nextToken());
            cost[i][1] = Integer.valueOf(st.nextToken());
            cost[i][2] = Integer.valueOf(st.nextToken());
        }

        memory[0][0] = cost[0][0];
        memory[0][1] = cost[0][1];
        memory[0][2] = cost[0][2];

        for (int i = 1; i < N; i++) {
            memory[i][0] = Math.min(memory[i - 1][1], memory[i - 1][2]) + cost[i][0];
            memory[i][1] = Math.min(memory[i - 1][0], memory[i - 1][2]) + cost[i][1];
            memory[i][2] = Math.min(memory[i - 1][1], memory[i - 1][0]) + cost[i][2];
        }

        System.out.println(Math.min(Math.min(memory[N - 1][0], memory[N - 1][1]), memory[N - 1][2]));
    }
}


/*
// USE Recursive
// 출처_https://st-lab.tistory.com/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

	final static int Red = 0;
	final static int Green = 1;
	final static int Blue = 2;

	static int[][] Cost;
	static int[][] DP;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Cost = new int[N][3];
		DP = new int[N][3];

		StringTokenizer st;
		for(int i = 0; i < N; i++) {

			st = new StringTokenizer(br.readLine(), " ");

			Cost[i][Red] = Integer.parseInt(st.nextToken());
			Cost[i][Green] = Integer.parseInt(st.nextToken());
			Cost[i][Blue] = Integer.parseInt(st.nextToken());
		}

		// DP의 첫번째 값(집)은 각 색상비용의 첫번째 값으로 초기화
		DP[0][Red] = Cost[0][Red];
		DP[0][Green] = Cost[0][Green];
		DP[0][Blue] = Cost[0][Blue];


		System.out.println(Math.min(Paint_cost(N- 1, Red), Math.min(Paint_cost(N - 1, Green), Paint_cost(N - 1, Blue))));
	}

	static int Paint_cost(int N, int color) {

		// 만약 탐색하지 않은 배열이라면
		if(DP[N][color] == 0) {

			// color의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최솟값과 현재 집의 비용을 더해서 DP에 저장한다
			if(color == Red) {
				DP[N][Red] = Math.min(Paint_cost(N - 1, Green), Paint_cost(N - 1, Blue)) + Cost[N][Red];
			}
			else if(color == Green) {
				DP[N][Green] = Math.min(Paint_cost(N - 1, Red), Paint_cost(N - 1, Blue)) + Cost[N][Green];
			}
			else {
				DP[N][Blue] = Math.min(Paint_cost(N - 1, Red), Paint_cost(N - 1, Green)) + Cost[N][Blue];
			}

		}

		return DP[N][color];
	}
}
 */