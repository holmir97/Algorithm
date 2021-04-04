// 랜덤pivot 퀵소트
public class QuickSortVer2 extends HelpSorting {
    static void sort(int[]arr, String sortName){
        cnt = 0;

        quickSortRandomPivot(arr,0,arr.length-1);
        //정렬된 배열 출력
        printArrVer1(arr,sortName);
    }

    private static void quickSortRandomPivot(int[] arr, int left, int right){
        if(left >= right) {
            return;
        }

        int mid = partitionRandom(arr,left,right);
        quickSortRandomPivot(arr,left,mid-1);
        quickSortRandomPivot(arr,mid +1,right);
    }

    //피벗을 랜덤으로 고른 다음 맨마지막 위치로 이동시켜 기존의 파티션 코드 실행
    public static int partitionRandom(int[] arr, int left, int right) {
        int index = (int)(Math.random()*(right+1-left)+left);
        int pivot = arr[index];
        int i = left -1;

        swap(arr,right,index);
        return partition(arr,left,right);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left -1;
        for(int j=left;j<right;j++) {
            if(Compare(arr[j],pivot)!=-1) {
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,right);
        return i+1;
    }
}
