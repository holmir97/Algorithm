// 마지막 값을 pivot으로 하는 퀵소트
public class QuickSortVer1 extends HelpSorting {

    static void sort(int[]arr, String sortName){
        cnt = 0;
        quickSortLastPivot(arr,0,arr.length-1);
        //정렬된 배열 출력
        printArrVer1(arr,sortName);
    }

    private static void quickSortLastPivot(int[] arr, int left, int right){
        if(left >= right)
            return;

        int mid = partitionLast(arr,left,right);
        quickSortLastPivot(arr,left,mid-1);
        quickSortLastPivot(arr,mid +1,right);
    }

    private static int partitionLast(int[] arr, int left, int right){
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
