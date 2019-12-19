package ALG.SORT;

public class test {
    public static void main(String[] agrs){
        int[] arr = MyArray.createRandomArray(100,5);
        MyArray.PrintArray(arr);
        MyArray.PrintArray(InsertSortableArray.insertSort(arr));

        arr = MyArray.createRandomArray(100,5);
        MyArray.PrintArray(arr);
        MyArray.PrintArray(ShellSortableArray.shellSort(arr));

        arr = MyArray.createRandomArray(100,5);
        MyArray.PrintArray(arr);
        MyArray.PrintArray(BubbleSortableArray.bubbleSort(arr));

        int[] ar = {78,64,31,56,31};
        MyArray.PrintArray(QuickSortableArray.quickSort(ar,0,ar.length-1));

        arr = MyArray.createRandomArray(100,5);
        MyArray.PrintArray(arr);
        MyArray.PrintArray(SelectSortableArray.selectSort(arr));

        arr = MyArray.createRandomArray(100,5);
        MyArray.PrintArray(arr);
        int[] temp = new int[arr.length];
        MyArray.PrintArray(MergeSortableArray.mergeSort(arr,0,arr.length-1,temp));
    }
}
