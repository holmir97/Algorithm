class KeepDecibel {
    public int Deicbel(int n, int m) {
        int answer = 0;
        int tmp = 0;

        if (m - n < 0)
            tmp = -(m - n);
        else if (m - n > 0)
            tmp = (m - n);
        if(tmp % 10 == 9  || tmp % 10 == 4){
            tmp++;
            answer++;
        }else if(tmp % 10 == 8 || tmp % 10 == 3){
            tmp +=2;
            answer +=2;
        }

        while (tmp != 0) {
            if (tmp >= 10) {
                tmp -= 10;
                answer++;
                continue;
            } else if (tmp >= 5) {
                tmp -= 5;
                answer++;
                continue;
            } else {
                tmp -= 1;
                answer++;
                continue;
            }
        }
        return answer;
    }
}