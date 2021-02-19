
public class Max69Num {
    public static void main(String[] args) {
        System.out.println(maximum69Number(9699));
    }
    public static int maximum69Number (int num) {
        String tmp="";
        String strNum = Integer.toString(num);
        String[] arrStrNum = strNum.split("");

        for(int i = 0; i<arrStrNum.length; i++){
            if(arrStrNum[i].equals("6")){
                arrStrNum[i] = "9";
                break;
            }
        }
        for(int i =0 ;i<arrStrNum.length;i++)
            tmp = tmp.concat(arrStrNum[i]);

        strNum = tmp;
        num = Integer.parseInt(strNum);
        return num;
    }
}
