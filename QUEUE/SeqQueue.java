package QUEUE;

//记住在循环队列中,rear储存的是最后一个元素的下一个元素,而front储存的是第一个元素
public final class SeqQueue<T> implements Queue<T>{
    private Object element[];
    private int front,rear;
    public SeqQueue(int length){
        if(length < 64){
            length = 64;
        }
        this.element = new Object[length];
        this.front = this.rear = 0;

    }
    public SeqQueue(){
        this(64);
    }
    public boolean isEmpty(){
        return this.rear == this.front;
    }
    public boolean add(T x){
        if(x==null){
            return false;
        }
        if(this.front == (this.rear+1)%this.element.length){
            Object[] temp = this.element;
            this.element = new Object[temp.length*2];
            int j = 0;
            for(int i = this.front;i!=this.rear;i=(i+1)%temp.length){
                this.element[j++] = temp[i];
            }
            this.front = 0;
            this.rear = j;
        }
        this.element[this.rear] = x;
        this.rear = (this.rear+1)%this.element.length;
        return false;
    }
    public T peek(){
        return this.isEmpty()?null:(T)this.element[this.front];
    }
    public T poll(){
        if(this.isEmpty()){
            return null;
        }
        T temp = (T)this.element[this.front];
        this.front = (this.front+1)%this.element.length;
        return temp;
    }
}
