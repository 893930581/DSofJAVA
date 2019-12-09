package ALG;

import LIST.SinglyList;
import LIST.Node;

public class HashSet<T> {
	//����ַ����hash����ֻ���治ͬ��Ԫ��ֵ��
	private SinglyList<T>[] table;
	private static final float LOAD_FACTOR = 0.75f;
	//ʵ�������hashɢ���������ñ�����3��4.
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
			//�൱��ʡȥ�˿��ŵ�ַ�������ͻ��
		}
	}
	
	public int hash(T x){
		int key = Math.abs(x.hashCode());
					//Ϊ��ͬ��������������hash int
		return key % this.table.length;
					//����Ҫ�����ͻ������˵ֱ�ӳ���ʵ�����鳤�ȡ�
	}
	
	public T search(T key){
		//ͨ������������
		Node<T> find = this.table[this.hash(key)].search(key);
		return find != null ? find.data : null;
	}
	
	public T remove(T key){
		//ͨ������ɾ��
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
					//�ݹ����·�������Ԫ�ء�
				}
			}
		}
		boolean insert = this.table[this.hash(x)].insertDifferent(x) != null;
		//���·����ַ��ȷ��hash��ַ������������ȷֲ���
		if(insert){
			this.count++;
		}
		return insert;
	}
}
