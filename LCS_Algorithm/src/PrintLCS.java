public class PrintLCS {
    public static void printLCS(String b[][], String s1, int s1len, int s2len){

        if(s1len == 0 || s2len ==0)
            return;

        // "↖"을 만났을 때
        if(b[s1len-1][s2len-1].equals("↖")){
            printLCS(b,s1,s1len-1,s2len-1);
            System.out.print(s1.charAt(s1len-1));
        }
        // "↑"를 만났을 때
        else if(b[s1len-1][s2len-1].equals("↑"))
            printLCS(b, s1, s1len - 1, s2len);
        // "←"를 만났을 때
        else
            printLCS(b,s1,s1len,s2len-1);

    }

    public static void printArr(String arr[][], String a, String b){
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                System.out.print(arr[i][j]);
            }System.out.print("\n");
        }
    }
}
