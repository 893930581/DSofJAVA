package TREE;

import STACK.SeqStack;

public class BinaryTree<T> {
    public BinaryNode<T> root;//根节点建立；

    public int level;

    public int leafNum = 0;

    public BinaryTree(){
        this.root = null;
    }

    public BinaryTree(T[] prelist){
        this.root = create(prelist);
        int i = 0;
        for(T ele : prelist){
            if(ele != null){ i++; }
        }
        this.level = (int)Math.floor(Math.log(i)+1);
    }

    private int i = 0;

    private BinaryNode<T> create(T[] prelist){//递归算法求先序遍历
        BinaryNode<T> p = null;
        if(i < prelist.length){
            T ele = prelist[i];
            i++;
            if(ele != null){
                p = new BinaryNode<T>(ele);
                p.left = create(prelist);
                p.right = create(prelist);
            }
        }
        return p;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public void getLeafs(){//判断叶子结点数
        BinaryNode<T> p = this.root;
        if( p!=null ){
            inOrder(p.left);
            if(p.isLeaf()){
                this.leafNum++;
            }
            inOrder(p.right);
        }else{
            System.out.print(this.leafNum);
        }
    }

    public BinaryNode<T> insert(T x){
        //在上面插，原根节点默认作为左子树。
        return this.root = new BinaryNode<T>(x,this.root,null);
    }

    public BinaryNode<T> insert(T x,BinaryNode<T> parent,boolean LeftChild){
        //在下面插则可能在做也可能在右。
        if(x == null){
            return null;
        }
        if(LeftChild == true){
            return parent.left = new BinaryNode<T>(x,parent.left,null);//创建一个新的结点
        }else{
            return parent.right = new BinaryNode<T>(x,parent.right,null);
        }
    }

    public void remove(BinaryNode<T> parent,boolean leftChild){//删除结点
        if(leftChild){
            parent.left = null;
        }else{
            parent.right = null;
        }
    }

    public void clear(){//清空树
        this.root = null;
    }

    public void preOrder(BinaryNode<T> p){//输出先根次序的遍历操作
        if( p!=null ){
            System.out.println(p.data + " ");
            preOrder(p.left);
            preOrder(p.right);
        }
    }

    public void inOrder(BinaryNode<T> p){//输出中序次序的遍历操作
        if( p!=null ){
            inOrder(p.left);
            System.out.println(p.data + "");
            inOrder(p.right);
        }
    }

    public void postOrder(BinaryNode<T> p){//输出后序次序的遍历操作
        if( p!=null ){
            postOrder(p.left);
            postOrder(p.right);
            System.out.println(p.data + "");
        }
    }

    public void inOrderTraverse2(BinaryNode node){
        if(node == null){
            return;
        }
        SeqStack lStack = new SeqStack(100);

        BinaryNode p =node;
        while(p!=null || !lStack.isEmpty())
        {
            if(p!=null){//遍历左子树，向左走到尽头，并将走过的节点入栈
                lStack.push(p);
                p=p.left;
            }else{//访问节点，向右走一步
                p=(BinaryNode) lStack.pop();
                System.out.print(p.data);
                p=p.right;
            }
        }
    }

//    public void levelLoader(){
//        System.out.print("层次遍历的顺序为：");
//        LinkedQueue<BinaryNode<T>> queue = new LinkedQueue<BinaryNode<T>>();
//        BinaryNode<T> p = this.root;

//        while(p!=null){
//            System.out.println(p.data+" ");
//            if(p.left != null) queue.add(p.left);
//            if(p.right != null) queue.add(p.right);
//            p = queue.poll();
//        }
//    }

}
