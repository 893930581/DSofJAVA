package ALG.SORT;

public class ShellSortableArray extends MyArray{
    public static int[] shellSort(int[] arr){
        for (int delta = arr.length/2; delta > 0;delta = delta/2){
            for (int i = delta;i < arr.length;i++){
                int temp = arr[i],j;
                for(j = i - delta;j >= 0&&temp < arr[j];j-=delta){
                    arr[j+delta] = arr[j];
                }
                arr[j+delta] = temp;
            }
        }
        return arr;
    }
}
