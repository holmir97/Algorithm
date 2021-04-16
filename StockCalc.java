// Java Programming
// 2021.04.16

public class StockCalc {
    public static void main(String[] args) {
        System.out.println("최종가격: "+ new StockCalc().stock(new int[]{4, 3, 7, 5, 4, 2, 3, 5, 6, 8, 5, 4, 3, 6, 4, 5, 8, 2, 3}, 20));
    }

    public int stock(int[] T, int w) {
        int answer = w;
        int stockNum = 0;
        int[] checkStock = new int[T.length];

        for(int i = 0; i<checkStock.length-1;i++){
            checkStock[i] = T[i+1]-T[i];
            if(checkStock[i] == 0)
                checkStock[i] = checkStock[i-1];
        }
        checkStock[checkStock.length-1] = checkStock[checkStock.length-2];


        for (int i = 0; i < T.length; i++) {
            // 처음 주식 결정
            if(i == 0){
                if(checkStock[i] < 0)
                    continue;
                stockNum = answer / T[i];
                answer %= T[i];
                continue;
            }

            // 마지막 주식 결정
            if (i == T.length-1) {
                if(checkStock[i] >= 0){
                    answer += stockNum * T[i];
                    stockNum = 0;
                }
                continue;
            }
//            if (i + 1 == T.length) {
//                if(checkStock[i] > 0){
//                    answer += stockNum * T[i];
//                    stockNum = 0;
//                }
//                continue;
//            }

            // 중간 주식 결정
            // 판매
            if (checkStock[i-1] > 0 && checkStock[i] <0) {
                answer += stockNum * T[i];
                stockNum = 0;
                continue;
            }

            // 구매
            if (checkStock[i-1] < 0 && checkStock[i] > 0) {
                stockNum = answer / T[i];
                answer %= T[i];
                continue;
            }
        }

        return answer;
    }
}
