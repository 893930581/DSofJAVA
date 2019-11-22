package STACK;
public class SeqStack<T> implements SqStack<T> {
    int MaxStackSize;
    Object element[];
    int top;
    public SeqStack(int length){
        int top = 0;
        this.MaxStackSize = length;
        this.element = new Object[length];
    }
    public boolean isEmpty(){
        return this.top == 0;
    }
    public void push(T x){
        if(this.top == this.MaxStackSize){
            throw new NullPointerException("不好意思满员了");
        }
        this.element[top] = x;
        this.top++;
    }
    public T peek(){
        if(this.top == 0){
            return null;
        }
        return (T)element[top-1];
    }
    public T pop(){
        if(this.top==0){
            throw new NullPointerException("栈内空空如也");
        }
        this.top--;
        return (T)element[top];
        //这里看似没有元素删除的操作，但是在下一次入栈的时候新元素会顶掉旧元素。
        //这样看似只是改变了下标,没有实际删除元素,但是其实在你下一次进行push的时候要被移除的元素就会被覆盖.
    }
}
