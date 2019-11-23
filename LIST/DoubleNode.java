package LIST;
public class DoubleNode<T> {
	public T data;
	public DoubleNode<T> prev,next;
	public DoubleNode(){
		this.data = null;
		this.prev = null;
		this.next = null;
	}
	public DoubleNode(T data, DoubleNode<T> prev, DoubleNode<T> next){
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	public DoubleNode(T data){
		this.data = data;
		this.prev = null;
		this.next = null;
	}
	public String toString(){
		return this.data.toString();
	}
}
