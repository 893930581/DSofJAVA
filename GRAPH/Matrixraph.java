//package GRAPH;
//
//import MATRIX.Matrix;
//import MATRIX.Triple;
//
//public class Matrixraph<T> extends AbstractGraph<T> {
//	protected Matrix matrix;
//	//储存邻接矩阵（有权图）。
//	public Matrixraph(int length) {
//		super(length);
//		//这里创建了一个长度为length的顶点线性表（空）
//		this.matrix = new Matrix(length);
//		//这里创建了一个空的邻接矩阵。
//	}
//	
//	public Matrixraph() {
//		this(10);
//	}
//	
//	public Matrixraph(T[] vertexs){
//		this(vertexs.length);
//		//创建线性表和邻接矩阵（初始化）
//		for(T x : vertexs){
//			this.insertVertex(x);
//		}
//		//给线性表赋值。
//	}
//	
//	public Matrixraph(T[] vertexs, Triple[] tri){
//		this(vertexs);
//		//创建线性表和邻接矩阵之后，给线性表赋值。
//		for(int i = 0;i<tri.length;i++){
//			this.insertEdge(tri[i]);
//			//因为这里我们传的是这样的一个数组 { new Triple(0,1,45) }
//		}
//		//给临界矩阵赋值。
//	}
//	
//	
//	public void insertEdge(int start,int end,int weight){
//		if(start != end){
//			if(weight < 0||weight > MAX_WEIGHT){
//				weight = MAX_WEIGHT;
//				//权重格式不正确就是∞。
//			}
//			this.matrix.set(start,end,weight);
//		}else{
//			throw new Error("不能形成自身环");
//		}
//	}
//	
//	public void insertEdge(Triple tri){
//		this.insertEdge(tri.row,tri.col,tri.data);
//		//重载
//	}
//	
//	public int insVertex(T x){
//		int i = this.vertexList.insert(x);
//		//在线性表中插入，并且返回新的行数（i+1）。
//		if(i >= this.matrix.getRows()){
//			//临界矩阵扩容
//			this.matrix.setRowCol(i+1, i+1);
//		}
//		for(int j = 0;j<i;j++){
//			this.matrix.set(i, j, MAX_WEIGHT);
//			this.matrix.set(j, i, MAX_WEIGHT);
//			//将最外面的一圈，赋值∞
//		}
//		return i;
//	}
//	
//	
//	public void removeEdge(int i,int j){
//		if(i!=j){
//			this.matrix.set(i, j, MAX_WEIGHT);
//		}
//	}
//	
//	public void removeEdge(Triple tri){
//		this.removeEdge(tri.row,tri.col);
//	}
//	//移除边就是改值为无穷。
//	public void removeVertex(int i){
//		//移除顶点，就需要删除所有和顶点有关的边。
//		int n = this.vertexCount();
//		//获取当前的行列数。
//		if(i < n && i >= 0){
//			this.vertexList.del(i);
//			//在线性表中删除顶点。
//			for(int j = i+1;j < n;j++){
//				for(int k = 0;k < n;k++){
//					this.matrix.set(j-1, k, this.matrix.get(j,k));
//					//列前移。
//				}
//			}
//			for(int j = 0;j < n;j++){
//				for(int k = i+1;k < n;k++){
//					this.matrix.set(j, k-1, this.matrix.get(j,k));
//					//行上移。
//				}
//			}
//			this.matrix.setRowCol(n-1, n-1);
//			//矩阵缩水。
//		}else{
//			throw new Error("下标越界");
//		}
//	}
//	
//	public int weight(int i,int j){
//		return this.matrix.get(i, j);
//		//返回特定权重
//	}
//	
//    /**
//     * @param i	行数
//     * @param j	列数
//     * @return	比如我们有（0，1，2）（0，4，6），传入（0，1）返回 4，传入（0，-1）返回 1。
//     */
//	public int next(int i,int j){
//		int n = this.vertexCount();
//		if(i>=0&&i<n&&j>=-1&&j<n&&j!=i){
//			for(int k = j+1;k<n;k++){
//				//比如这里传入的j是-1，那么k的初始值就是0，就是从行头找到行尾。
//				if(this.matrix.get(i, k)>0 && this.matrix.get(i, k)<MAX_WEIGHT){
//					return k;
//				}
//			}
//		}
//		return -1;
//	}
//	
//	public String toString(){ 
//		String str = super.vertexList.toSting() +"邻接矩阵: \n";
//		int n = this.vertexCount();
//		for(int i = 0;i < n;i++){
//			for(int j = 0;j < n;j++){
//				if(i==j){
//					str+="\t0";
//				}else{
//					str += this.matrix.get(i, j) == MAX_WEIGHT ? "\t∞" : "\t"+this.matrix.get(i, j);	
//				}
//			}
//			str += "\n";
//		}
//		
//		return str;
//	}
//}
