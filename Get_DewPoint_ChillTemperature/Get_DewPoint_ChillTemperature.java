public class Get_DewPoint_ChillTemperature {
    public static double calculateDewPointTemperature(double T , double RH) {
        double v = Math.log(RH / 100) + (17.62 * T / (243.12 + T));
        return ( 243.12* v) / ( 17.62 - v );
    }
    public static double calculateWindChillTemperature(double T , double V) {
        double Vc = Math.pow(V,0.16);
        return 13.12 + 0.6215*T - (11.37*Vc)+(0.3965*Vc*T);
    }
    static void printDewPointTemperatureTable(double T1, double RH) {
        System.out.print((int)calculateDewPointTemperature(T1,RH));
    }
    static void printWindChillTemperatureTable(double T, double V) {
        System.out.print(Math.round(calculateWindChillTemperature(T,V)));
    }


    public static void main(String[] args) {
        while(true){
            double t, rh, v;

            if(UserInput.getExitKey())
                break;
            System.out.print("T(온도) 입력: ");
            t = UserInput.getDouble();
            System.out.print("RH(상대습도) 입력: ");
            rh = UserInput.getDouble();
            System.out.print("V(풍속) 입력: ");
            v = UserInput.getDouble();

            System.out.print("이슬점 결과: ");
            printDewPointTemperatureTable(t,rh);
            System.out.println();

            System.out.print("체감온도 결과: ");
            printWindChillTemperatureTable(t,v);
            System.out.println();
        }


    }
}