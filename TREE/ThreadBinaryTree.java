package TREE;

public class ThreadBinaryTree<T> {
    private ThreadBinaryNode<T> root;

    public ThreadBinaryTree(T[] array, int index){
        this.root = this.creatTree(array, index);
    }

    public ThreadBinaryNode<T> creatTree(T[] array,int index){
        ThreadBinaryNode<T> p = null;
        if(index<array.length){
            p = new ThreadBinaryNode<T>(array[index]);
            p.left = creatTree(array,2*index+1);
            p.right = creatTree(array,2*index+2);
            return p;
        }else{
            return null;
        }
    }

    public ThreadBinaryNode<T> front = null;

    public void inorderThread(ThreadBinaryNode<T> p){
        if(p!=null){
            inorderThread(p.left);
            //要知道这是中序线索化树，所以说p一开始会索值到最左边的节点，而他的左线索树一定是false；
            if(p.left == null){
                p.ltag = true;
                p.left = front;
            }
            if(p.right == null){
                p.rtag = false;
            }
            if(front != null && front.rtag == true){
                front.right = p;
            }
            front = p;
            inorderThread(p.right);
        }
    }

}
