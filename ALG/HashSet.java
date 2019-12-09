package ALG;

import LIST.SinglyList;
import LIST.Node;

public class HashSet<T> {
	//链地址法，hash数组只储存不同的元素值。
	private SinglyList<T>[] table;
	private static final float LOAD_FACTOR = 0.75f;
	//实际数组和hash散列数组的最好比例是3比4.
	public int count = 0;
	public HashSet(int length){
		if(length < 10){
			length = 10;
		}
		this.table = new SinglyList[length];
		for(int i = 0;i < this.table.length; i++){
			this.table[i] = new SinglyList<T>();
		}
	}
	
	public HashSet(){
		this(16);
	}
	
	public void printHashSet(){
		for(int i = 0;i < this.table.length;i++){
			System.out.println(this.table[i].toString());
		}
	}
	
	public HashSet(T[] values){
		this((int)(values.length/LOAD_FACTOR));
		this.count = values.length;
		for(int i = 0;i<values.length;i++){
			this.table[this.hash(values[i])].insertDifferent(values[i]);
			//相当于省去了开放地址法解除冲突。
		}
	}
	
	public int hash(T x){
		int key = Math.abs(x.hashCode());
					//为不同的数据类型生成hash int
		return key % this.table.length;
					//不需要避免冲突，所以说直接除以实际数组长度。
	}
	
	public T search(T key){
		//通过数据搜索。
		Node<T> find = this.table[this.hash(key)].search(key);
		return find != null ? find.data : null;
	}
	
	public T remove(T key){
		//通过数据删除
		T x = this.table[this.hash(key)].remove(key);
		if (x != null){
			this.count--;
		}
		return x;
	}
	
	public boolean add(T x) {
		if(this.count >= this.table.length*LOAD_FACTOR){
			SinglyList<T>[] temp = this.table;
			this.table = new SinglyList[this.table.length*2];
			for(int i=0; i < this.table.length*2;i++){
				this.table[i] = new SinglyList<T>();
			}
			this.count = 0;
			for(int i = 0;i< temp.length;i++){
				for(Node<T> p = temp[i].head.next;p!=null;p = p.next){
					this.add(p.data);
					//递归重新分配所有元素。
				}
			}
		}
		boolean insert = this.table[this.hash(x)].insertDifferent(x) != null;
		//重新分配地址，确保hash地址在新数组里均匀分布。
		if(insert){
			this.count++;
		}
		return insert;
	}
}
