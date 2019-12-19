package ALG.SORT;

public class QuickSortableArray extends MyArray {
    public static int[] quickSort(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int pivot = arr[(l+r)/2];
        //基准值
        while(l < r){
            while(arr[l] < pivot){
               l += 1;
            }
            while(arr[r] > pivot){
                r -= 1;
            }
            //在左边和右边各找一个与基准值规则相异的元素并且交换两个元素。
            if(l >= r){
                break;
            }
            //这里说明两边都已经符合规则，不需要进行交换。
            arr[r] = arr[r]^arr[l];
            arr[l] = arr[l]^arr[r];
            arr[r] = arr[r]^arr[l];
            //交换

            if(arr[l] == pivot){
                r -= 1;
            }
            // 类似{97,31,31,64,78,31}这种情况，防止两个31一直换位形成死循环.
            if(arr[r] == pivot){
               l += 1;
            }
            // 其实这两个只需要写一个，因为最后会出现问题的一定是r或者是l和基准重合并且和另一个l或者r相等形成的死循环。
        }
        if (l == r){
            l += 1;
            r -= 1;
        }

        if(left < r){
            quickSort(arr,left,r);
        }
        if(right > l){
            quickSort(arr,l,right);
        }
        return arr;
    }
}
