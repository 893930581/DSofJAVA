package TREE;

public class ThreadBinaryNode<T> {
    public T data;
    public ThreadBinaryNode<T> left,right;
    public boolean ltag,rtag;
    public ThreadBinaryNode(T data, ThreadBinaryNode<T> left, ThreadBinaryNode<T> right, boolean ltag, boolean rtag){
        this.data = data;
        this.left = left;
        this.right = right;
        this.ltag = ltag;
        this.rtag = rtag;
    }
    public ThreadBinaryNode(T data){
        this(data,null,null,false,false);
    }
    public boolean isLeaft(){
        return this.left == null && this.right == null;
    }
    public String toString(){
        return this.data.toString();
    }
}
