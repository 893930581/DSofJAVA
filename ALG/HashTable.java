package ALG;

public class HashTable<T>{
	private Object[] hashArray;
	private int arraySize;
	private int hashSize = 0;
	public HashTable(int length){
		this.hashArray = new Object[length];
		this.arraySize = length;
	}
	
	public HashTable(){
		this(10);
	}
	
	public HashTable(T[] values){
		this(values.length);
		this.insert(values);
	}
	
	private int hashFunc(T key){
		int x = Math.abs(key.hashCode());
		return x%this.arraySize;
	}
	
	public String toString(){
		String s = "{";
		for(int i = 0;i < this.hashArray.length;i++){
			if(this.hashArray[i] == null){continue;}
			s += this.hashArray[i].toString()+"\t";
		}
		s += "}";
		return s;
	}
	
	public void insert(T key){
		int hashKey = this.hashFunc(key);
		int count = 0;
		while(hashArray[hashKey] != null){
			count++;
			hashKey = (hashKey + 1)%arraySize;
		}
		count++;
		hashArray[hashKey] = key;
		System.out.println("一共尝试插入了"+count+"次");
	}
	
	public void insert(T[] values){
		for(int i = 0;i < values.length;i++){
			this.insert(values[i]);
		}
	}
	
	public T search(T key){
		int where = this.hashFunc(key);
		System.out.println(where);
		int c = 0;
		while(!this.hashArray[where].equals(key)){
			where = (where + 1)%arraySize;
			System.out.println(where);
			System.out.println(c);
			c++;
		}
		return (T)this.hashArray[where];
	}
	
	public T remove(T key){
		int where = this.hashFunc(key);
		while(!this.hashArray[where].equals(key)){
			where = (where + 1)%arraySize;
		}
		Object v = this.hashArray[where];
		this.hashArray[where] = null;
		return (T)v;
	}
	
	
	
//	private int getPrime(int num){
//		boolean isPrime;
//		for(int i = num; i > 0; i--){
//			for(int j = 2; j < i;i++){
//				if(i%j == 0){
//					isPrime = false;
//					break;
//				}
//			}
//		}
//	}
}
