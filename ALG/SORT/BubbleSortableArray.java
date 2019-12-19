package ALG.SORT;

public class BubbleSortableArray extends MyArray {
    public static int[] bubbleSort(int[] arr){
        boolean exchanged = true;
        for(int i=1; i<arr.length&&exchanged; i++){
            exchanged = false;
            //没有前后交换就说明每两个元素的前后顺序都是合理的说明已经是正序了。
            for(int j = 0;j < arr.length-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    exchanged = true;
                }
            }
        }
        return arr;
    }
}
