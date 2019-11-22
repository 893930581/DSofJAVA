package STACK;
public interface SqStack<T> {
    public abstract boolean isEmpty();
    public abstract void push(T x);
    public abstract T peek();
    public abstract T pop();
}
