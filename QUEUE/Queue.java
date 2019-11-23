package QUEUE;
public interface Queue<T> {
    public abstract boolean isEmpty();
    public abstract boolean add(T x);//入队返回布尔值
    public abstract T peek();//返回队头元素或者null
    public abstract T poll();//出队返回对头元素或者null
}
