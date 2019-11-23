package STACK;

import LIST.SinglyList;

public class SinglyStack<T> implements Sgstack<T> {
    private SinglyList<T> list;
    public SinglyStack(){
        this.list = new SinglyList<T>();
    }
    public boolean isEmpty(){
        return this.list.isEmpty();
    }
    public void push(T x){
        this.list.insert(0,x);
    }
    public T peek(){
        return this.list.get(0);
    }
    public T pop(){
        return this.list.remove(0).data;
    }
}
