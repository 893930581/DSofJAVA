package ALG.SORT;

public class InsertSortableArray extends MyArray {
    public static int[] insertSort(int[] arr){
        for(int i = 1;i < arr.length;i++){
            int temp = arr[i],j;
            for(j = i-1; j>=0 && temp<arr[j]; j--){
                arr[j+1] = arr[j];
                //这里相当于把第j个元素往后挪。
            }
            arr[j+1] = temp;
        }
        return arr;
    }
}
