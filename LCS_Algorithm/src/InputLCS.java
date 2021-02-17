//랜덤 DNA 출력
public class InputLCS {
    public static String makeString(){
        String dna="";
        int lenth;

        // 15~25 개의 염기서열을 가진 DNA 생성
        lenth = (int)((Math.random()*10) +15);
        while(lenth >= 0){
            int tmp = (int)(Math.random()*4);
            switch (tmp){
                case 0:
                    dna += "A";
                    break;
                case 1:
                    dna += "G";
                    break;
                case 2:
                    dna += "C";
                    break;
                case 3:
                    dna += "T";
                    break;
            }
            lenth--;
        }
        return dna;
    }
}
