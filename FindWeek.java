import java.text.*;
import java.util.*;

public class FindWeek {
    public static void main(String[] args) throws ParseException {
        System.out.println(new FindWeek().solution(new FindWeek().getDate()));
    }

    public String solution(String input) throws ParseException {
        String answer = "";
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = dataFormat.parse(input);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        switch (cal.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                answer = "일요일";
                break;
            case 2:
                answer = "월요일";
                break;
            case 3:
                answer = "화요일";
                break;
            case 4:
                answer = "수요일";
                break;
            case 5:
                answer = "목요일";
                break;
            case 6:
                answer = "금요일";
                break;
            case 7:
                answer = "월요일";
                break;
        }

        return answer;
    }
    public String getDate(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("연월일입력(yyyymmdd): ");
        return scanner.nextLine();
    }
}
