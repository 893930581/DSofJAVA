package TREE;

public class TriElement {
    int data;
    int parent,left,right;
    public TriElement(int data, int parent, int left, int right){
        this.data = data;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
    public TriElement(int data) {
        this(data,-1,-1,-1);
    }

    public String toString(){
        return "("+this.data+","+this.parent+","+this.left+","+this.right+")";
    }

    public Boolean isLeaf(){
        return this.left == -1 && this.right == -1;
    }
}
