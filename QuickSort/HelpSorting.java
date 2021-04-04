public class HelpSorting {
    static int cnt;

    // Sort 배열 결과 출력
    static void printArrVer1(int[] arr, String sortName) {

        System.out.println(sortName + "[" + arr.length + "]인 배열 정렬 결과.");
        System.out.println("Count the number of Key comparisons : " + cnt);
        if (arr.length < 40) {
            System.out.print("정렬된 값: ");
            for (int n = 0; n < arr.length; n++)
                System.out.print(arr[n] + " ");
            System.out.print("\n");
        }
    }

    // Sort 클래스 안에서 count를 독립적으로 계산했을때 사용하는 배열 출력 메소드
    static void printArrVer2(int[] arr, String sortName,int cnt) {

        System.out.println(sortName + "[" + arr.length + "]인 배열 정렬 결과.");
        System.out.println("Count the number of Key comparisons : " + cnt);
        if (arr.length < 40) {
            System.out.print("정렬된 값: ");
            for (int n = 0; n < arr.length; n++) {
                System.out.print(arr[n] + " ");
            }
            System.out.print("\n");
        }
    }

    // a,b의 값을 비교하여 결과 반환
    static int Compare(int a, int b) {
        cnt++;
        if (a < b)
            return 1;
        else if (a == b)
            return 0;
        else
            return -1;
    }

    //단순 스왑 함수
    static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
