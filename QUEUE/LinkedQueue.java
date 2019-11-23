package QUEUE;

import LIST.Node;

public class LinkedQueue<T> implements Queue<T> {
		protected Node<T> front,rear;
		public LinkedQueue(){
			this.rear = this.front = null;
		}
		
		public LinkedQueue(T[] values){
			this();
			for(int i=0;i<values.length;i++){
				this.add(values[i]);
			}
		}
		
		public boolean isEmpty(){
			return this.front == null&&this.rear == null;
		}
		
		public boolean add(T x){
			if(x == null){
				return false;
			}
			Node<T> q = new Node<T>(x,null);
			if(this.front == null){
				this.front = this.rear = q;
			}else{
				this.rear.next = q;
			}
			this.rear = q;
			return true;
		}
		
		public T peek(){
			return this.front.data;
		}
		
		public T poll(){
			if(this.isEmpty()){
				return null;
			}
			T x = this.front.data;
			this.front = this.front.next;
			if(this.front == null){
				this.rear = null;
				//记住了front和rear是两个指向相同的指针,需要两个都进行修改.
			}
			return (T)x;
		}
}
