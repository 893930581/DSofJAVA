package ALG;

public class test {
	public static void main(String[] agrs){
		Integer[] arr = {10,289,231,32,56,77,44,72,45,11};
		HashSet<Integer> s = new HashSet<Integer>(arr);
		s.search(1);
		s.printHashSet();
		
		HashTable<Integer> s2 = new HashTable<Integer>(arr);
		System.out.print(s2.toString());
		System.out.print(s2.search(231));
		System.out.print(s2.remove(231));
		System.out.print(s2.toString());	
	}
}
