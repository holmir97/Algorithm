// pivot 은 median of three로 설정
public class QuickSortVer3 extends HelpSorting {
    static void sort(int[]arr, String sortName){
        cnt = 0;

        quickSortMedianOfThreePivot(arr,0,arr.length-1);
        //정렬된 배열 출력
        printArrVer1(arr,sortName);
    }

    private static void quickSortMedianOfThreePivot(int[] arr, int left, int right){
        if(left >= right)
            return;

        int mid = partitionMOT(arr,left,right);
        quickSortMedianOfThreePivot(arr,left,mid-1);
        quickSortMedianOfThreePivot(arr,mid +1,right);
    }



    private static int partitionMOT(int[] arr, int left, int right) {
        int center = (left+right)/2;
        if(Compare(arr[left],arr[right])!=-1) {
            if(Compare(arr[center],arr[right])!=-1)
                swap(arr,center,right);
        }
        else {
            if(Compare(arr[center],arr[left])!=-1)
                swap(arr,center,right);
            else
                swap(arr,left,right);

        }
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
