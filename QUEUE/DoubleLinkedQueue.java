package QUEUE;

import LIST.DoubleNode;

final class DoubleLinkedQueue<T> implements Queue<T> {
	protected DoubleNode<T> front;
	public DoubleLinkedQueue() {
		this.front = new DoubleNode<T>();
	}
	
	public boolean isEmpty(){
		return this.front.next == null && this.front.prev == null;
	}
	
	public boolean add(T x){
		if(x == null){
			return false;
		}
		
		if(this.front.prev == null){
			DoubleNode<T> newRear = new DoubleNode<T>(x,this.front,this.front);
			this.front.next = this.front.prev = newRear;
		}else{
			DoubleNode<T> newRear = new DoubleNode<T>(x,this.front.prev,this.front);
			this.front.prev.next = newRear;
			this.front.prev = newRear;
		}
		return true;
	}
	
	public T peek(){
		return this.front.prev.data;
	}
	
	public T poll(){
		T polledValue = this.front.prev.data;
		this.front.prev.prev.next = this.front;
		this.front.prev = this.front.prev.prev;
		return polledValue;
	}
}
