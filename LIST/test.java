package LIST;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5};
		SeqList<Integer> list = new SeqList<Integer>();
		for(int ele : array){
			list.insert(ele);
		}
		System.out.println(list.binarysearch(2));
	}

}
