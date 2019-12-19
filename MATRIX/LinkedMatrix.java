package MATRIX;

import LIST.Node;
import LIST.SeqList;
import LIST.SinglyList;
import LIST.PolySinglyList;

public class LinkedMatrix {
    public int rows,cols;
    //最大值
    public SeqList<PolySinglyList<Triple>> rowList;
    //这里我们用顺序表来实现矩阵的垂直结构但是实际的行和列其实还是由链表来实现的。
    public LinkedMatrix(int m, int n){
        if(m>0&&n>0){
            this.rows = m;
            this.cols = n;
            this.rowList = new SeqList<PolySinglyList<Triple>>();
            for(int i = 0 ;i < m;i++){
                this.rowList.insert(i,new PolySinglyList< Triple >());
            }
        }else{
            throw new Error("你家矩阵长这样？");
        }
    }
    public LinkedMatrix(int m ){
        this(m,m);
    }

    public LinkedMatrix(int m, int n, Triple[] tris){
        this(m,n);
        for(int i = 0;i < tris.length;i++){
            this.set(tris[i]);
        }
    }

    public int getCols(){
        return this.cols;
    }

    public int getRows(){
        return this.rows;
    }

    public void set(int i,int j,int x){
        this.set(i,j,x);
    }

    public void set(Triple tri){
        int i = tri.row;
        int j = tri.col;
        if(i>=0&&i<this.rows&&j>=0&&j<this.cols){
            SinglyList<Triple> link = this.rowList.get(i);
            if(tri.data == 0){
                //link.remove(tri);
                //对于稀疏矩阵来说是不储存0这个数据的，所以你把一个矩阵的元素值设置为0就相当于是和他说再见啦。
            }else{
                Node<Triple> find = null;
                //找到这个元素，我们的Triple实现了Compareable接口所以说比较的其实是位置col和row。
                if(find!=null){
                    find.data.data = tri.data;
                    //如果相同的位置上有数据就改值就行了。
                }else{
                    link.insert(tri);
                    //插入
                }
            }
        }else{
            throw new Error("下标越界了。");
        }
    }

    public int get(int i,int j){
        if(i >= 0 && i < this.rows && j >= 0 && j <this.cols){
            Node<Triple> find = this.rowList.get(i).search(new Triple(i,j,5));

            return (find!=null) ? find.data.data : 0;
        }else{
            throw new IndexOutOfBoundsException("i="+i+"j="+j);
        }
    }

    public String toString(){
        String str = "稀疏矩阵为：\n";
        for(int i = 0; i < this.rows; i++){
            str += i + "->" + this.rowList.get(i).toString() + "\n";
        }
        return str;
    }

    public void printMatrix(){
        System.out.println("("+this.rows+"×"+this.cols+")稀疏矩阵：");
        for(int j = 0;j < this.rows;j++){
            Node<Triple> p = this.rowList.get(j).head.next;
            for(int i = 0;i < this.cols;i++){
                if(p != null&&p.data.col == i){
                    System.out.print(p.data.data+"\t");
                }else{
                    System.out.print(0+"\t");
                }
            }
            System.out.println();
        }
    }

    public void setRowsCols(int m,int n){
        if(m>0 && n>0){
            if(m > this.rows && n >= this.cols){
                for(int i = this.rows; i < m; i++){
                    this.rowList.insert(i,new PolySinglyList< Triple >());
                    this.rows = m ;
                    this.cols = n ;
                }
            }else{
                throw new IllegalArgumentException("新的宽高不能小于现在的值。");
            }
        }
    }
}
