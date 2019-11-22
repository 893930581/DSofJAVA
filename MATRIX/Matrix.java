package MATRIX;

public class Matrix {
	public int mx[][], m, n;
	//矩阵类，二维数组实现。m表示行数，n表示列数。正常来说没有数据的地方应该什么都不储存（null），但是为了方便后文的图类，我还是在初始化的时候都储存了∞。
	public static final int MAX_WEIGHT = 0x0000ffff;
	//这里为了构造带权图的邻接矩阵我用一个变量储存无穷。
	public Matrix(int m, int n){
		this.m = m;
		this.n = n;
		mx = new int[m][n];
		initMatrix();
		//初始化
	}
	
	public Matrix(int length){
		this(length,length);
	}
	
	public Matrix() {
		this(10);
	}
	
	public Matrix(int m,int n,Triple[] tris){
		this(m,n);
		for(Triple tri : tris){
			this.set(tri);
		}
	}
	
	public void initMatrix(){
		for(int i=0;i<this.m;i++){
			for(int j=0;j<this.n;j++){
					mx[i][j] = this.MAX_WEIGHT;			
					//正常其实应该放的是0。
			}
		}
	}
	
	public void set(Triple tri){
		this.set(tri.row,tri.col,tri.data);
	}
	
	public void set(int i,int j,int x){
		if(i<0 || i>=this.m || j<0 || j>=this.n){
			throw new Error("下标越界了");
		}
		this.mx[i][j] = x;
	}
	
	public int get(int i,int j){
		if(i<0 || i>=this.m || j<0 || j>=this.n){
			throw new Error("下标越界了");
		}
		return this.mx[i][j];
	}
	
	public int getRows(){
		return this.m;
	}
	//获取行数
	public int getCols(){
		return this.n;
	}
	//获取列数
	public void setRowCol(int i,int j){
		//重新设置行数和列数。
		int[][] mc = new int[i][j];
		for(int k=0;k<this.m;k++){
			for(int o=0;o<this.m;o++){
				mc[k][o] = this.mx[k][o];
			}
		}
		this.mx = mc;
		this.m = i;
		this.n = j;
	}
	
	public String toString(){
		String str = "("+this.m+"*"+this.n+")矩阵：\n";
		for(int i = 0;i < m;i++){
			for(int j = 0;j < n;j++){
				str += "\t"+ this.mx[i][j];
			}
			str += "\n";
		}
		return str;
	}
	
	public void tranMatrix(){//矩阵转置
		int i, j, t;
		int mt[][] = new int[m][n];
		for (i = 0; i <= m - 1; i++)
		for (j = 0; j <= n - 1; j++)
		mt[i][j] = mx[i][j];
		t = m;
		m = n;
		n = t;
		mx = new int[m][n];
		for (i = 0; i <= m - 1; i++)
		for (j = 0; j <= n - 1; j++)
		mx[i][j] = mt[j][i];
	}

	//判断一个矩阵是否为上三角矩阵
	public boolean isUpperTriangularMatrix() {
		int i, j = 0;
		int c = this.mx[1][0];
		for(i=1; i<this.mx.length; i++)
			for(j=0; j<i; j++)
				if(this.mx[i][j] != c)
				break;
				if(i>=this.mx.length)
				return true;
				return false;
	}
	public void addMatrix(Matrix b)// 矩阵相加
	{
		int i, j;
		for (i = 0; i <= m - 1; i++)
		for (j = 0; j <= n - 1; j++)
		mx[i][j] = mx[i][j] + b.mx[i][j];
	}
}