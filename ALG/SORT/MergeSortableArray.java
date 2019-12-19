package ALG.SORT;

public class MergeSortableArray {
    public static int[] mergeSort(int[] arr,int start,int end,int[] temp){
        if(start < end){
            int mid = (start+end)/2;
            mergeSort(arr,start,mid,temp);
            mergeSort(arr,mid+1,end,temp);
            //将数组以二叉树的形式不断分割，最后分割成两个一组的子数组。
            merge(arr,start,mid,end,temp);
            //从最小的（两个元素）的子数组开始排序合并一直到最后所有的元素。
        }
        return arr;
    }
    /**
     *
     * @param   arr     数组（包含两个子数组）
     * @param   start   子数组一的开头
     * @param   mid     子数组一的结尾
     * @param   end     子数组二的结尾
     * @param   temp    临时数组
     */
    public static void merge(int[] arr,int start,int mid,int end,int[] temp){
        int i = start;
        int j = mid+1;
        int t = 0;
        //初始化临时变量，j表示子数组二的开头，i表示子数组一的开头。
        while(i <= mid && j <= end){
            //将子数组内容比较大小之后不断填入临时数组，知道有一个数组的所有元素都已经被填入。
            if(arr[i] <= arr[j]){
                //注意这里如果左右两个子数组元素相同的时候永远都是左边的先填入数组。
                temp[t] = arr[i];
                t += 1;
                i += 1;
            }else{
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        //将没全填入临时数组的元素都填进去。
        while(i <= mid){
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while(j <= end){
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        //将临时数组元素都填入元素组。
        t = 0;
        int tempstart = start;
        while(tempstart <= end){
            arr[tempstart] = temp[t];
            t += 1;
            tempstart += 1;
        }
    }
}
