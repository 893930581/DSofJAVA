package MATRIX;

public class Triple implements Comparable<Triple> {
    public int row,col,data;
    public Triple(int m, int n, int d){
        if(m>=0 && n>=0){
            this.row = m;
            this.col = n;
            this.data = d;
        }else{
            throw new IllegalArgumentException("行列数不能为负数。");
        }

    }

    public Triple(Triple tri){
        this(tri.row,tri.col,tri.data);
    }

    public String toString(){
        return "("+this.row+","+this.col+","+this.data+")";
    }

    @Override
    public int compareTo(Triple tri) {
        //这里我们用triple实现compareable接口，来实现Triple的实例在比较时只比较行和列。
        if(this.row == tri.row && this.col == tri.col){
            return 0;
        }
        return (this.row < tri.row || this.row == tri.row && this.col < tri.col)?-1:1;
    }

    public Triple toSymmetry(){
        //获取位置对称的元素
        return new Triple(this.col,this.row,this.data);
    }
}
