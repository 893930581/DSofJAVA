package GRAPH;

import LIST.Node;
import MATRIX.LinkedMatrix;
import LIST.PolySinglyList;
import MATRIX.Triple;

public class AdjListGraph<T> extends AbstractGraph<T> {
    public LinkedMatrix matrix;
    public AdjListGraph(int length){
        super(length);
        this.matrix = new LinkedMatrix(length);
    }
    
    public AdjListGraph(){
    	super(10);
    	this.matrix = new LinkedMatrix(10);
    }
    
    public AdjListGraph(T[] vertexs){
    	this(vertexs.length);
    	for(T ele : vertexs){
    		this.insertVertex(ele);
    	}
    }
    
    public AdjListGraph(T[] vertexs, Triple[] tris){
    	this(vertexs);
    	for(Triple tri : tris){
    		this.insertEdge(tri);
    	}
    }
    
    public void insertEdge(int i,int j,int weight){
    	if(j!=i){
    		if(weight<0||weight>MAX_WEIGHT){
    			weight = 0;
    		}
    		this.matrix.set(i,j,weight);
    		//这里我们用的是稀疏矩阵，稀疏矩阵的特点就是不会存0，所以权重为0（即无边）一定不会储存。
    	}else{
    		throw new Error("不能形成自身环");
    	}
    }
    
    public void insertEdge(Triple tri){
    	this.insertEdge(tri.row,tri.col,tri.data);
    }
    
    public int insertVertex(T x){
    	int i = this.vertexList.insert(x);
    	if(i >= this.matrix.getRows()){
    		this.matrix.setRowsCols(i+1,i+1);
    	}
    	return i;
    }
    
    public void removeEdge(int i,int j){
    	if(i!=j){
        	this.insertEdge(i, j, 0);
    	}
    }
    
    public void removeEdge(int i){
    	int n = this.vertexCount();
    	
    }
    
    public int weight(int i,int j){
    	if(i==j){
    		return 0;
    	}
    	int weight = this.matrix.get(i, j);
    	//如果说i和j越界，在linkedMatrix那里会有越界异常。
    	return weight != 0 ? weight : MAX_WEIGHT;
    }
    
    /**
     * @param i	行数
     * @param j	列数
     * @return	比如我们有（0，1，2）（0，4，6），传入（0，1）返回 4，传入（0，-1）返回 1。
     */
    protected int next(int i,int j){
    	int n = this.vertexCount();
    	//获取顶点总数
    	if(i>=0&&i<n&&j>=-1&&j<n&&j!=i){
    		//判断边是否合法
    		PolySinglyList<Triple> link = this.matrix.rowList.get(i);
    		//拿到行
    		Node<Triple> find = link.head.next;
    		//拿到行首元素
    		if(j == -1){
    			//如果j传的是-1就返回第一个。
    			return find != null ? find.data.col : -1;
    		}
    		//找到i，j
    		find = link.search(new Triple(i,j,0));
    		if(find!=null){
    			find = find.next;
    			//如果找到了i，j就拿到下一个同行的下一个边对应的后继节点。
    			if(find!=null){
    				return find.data.col;
    			}
    		}
    	}
    	//没拿到都返回-1.
    	return -1;
    }
    
}
