package ALG.SORT;

public class SelectSortableArray {
    public static int[] selectSort(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            //每次选出数组中最小的元素填入第i位，所以一共需要进行n次循环。
            int min = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[min] > arr[j]){
                    min = j;
                    //从第i+1位开始找出最小的元素，并且将其下标暂存起来。
                }
            }
            if(min != i){
                //如果说i已经是最小的元素了，min就会和i相等这个时候就需要进行判断防止交换。
                arr[i]   = arr[min]^arr[i];
                arr[min] = arr[i]^arr[min];
                arr[i]   = arr[min]^arr[i];
            }
        }
        return arr;
    }
}
