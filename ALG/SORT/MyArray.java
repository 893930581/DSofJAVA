package ALG.SORT;

public class MyArray {
    public static int[] createRandomArray(int n,int size){
        int[] arr = new int[size];
        for (int i = 0; i < size;i++){
            arr[i] = (int) (Math.random()*n+1);
        }
        return arr;
    }

    public static void PrintArray(int[] arr){
        System.out.print("{\t");
        for (int ele : arr) {
            System.out.print(ele+"\t");
        }
        System.out.print("}\n");
    }
}
