package GRAPH;

import LIST.SeqList;
import QUEUE.LinkedQueue;

public abstract class AbstractGraph<T> {
	//图的有向和无向是由你传入的Triple来决定的。
	protected static final int MAX_WEIGHT = 0x0000ffff;
	protected SeqList<T>  vertexList;
	//用线性表储存顶点。
	public AbstractGraph(int length){
		this.vertexList = new SeqList<T>(length);
	}
	public AbstractGraph() {
		this(10);
	}
	public int vertexCount(){
		return this.vertexList.size();
	}
	public String toString(){
		return "顶点集合"+ this.vertexList.toString() + '\n';
	}
	//返回顶点集合。
	public int insertVertex(T data){
		return this.vertexList.insert(data);
	}
	//尾插入（因为我没写重载）
	public T getVertex(int x){
		return this.vertexList.get(x);
	}
	//获取
	protected abstract int next(int i ,int j);
	public void setVertex(int x,T data){
		this.vertexList.set(x, data);
	}

	//DFS深度优先遍历
	public void DFSTraverse(int i){
		Boolean[] visited = new Boolean[this.vertexCount()];
		for(int k = 0;k<visited.length;k++){
			visited[k] = false;
		}
		int j = i;
		//这里的j和i只是为了确定是否所有元素都被遍历，和实际的边无关。
		do{
			if(!visited[j]){
				System.out.print("{");
				this.depthfs(j,visited);
				System.out.print("}");
			}
			j= (i+1)%this.vertexCount();
		}while(j!=i);
		System.out.println();
	}

	private void depthfs(int i,Boolean[] visited){
		System.out.print("\t"+this.getVertex(i)+"\t");
		visited[i] = true;
		int j = this.next(i,-1);
		while(j!=-1){
			if(!visited[j]){
				this.depthfs(j,visited);
				//先忽略掉最后一行，这一行就是从顶点用next一直得到可访问的最后一个元素。
			}
			//从最后一个开始，往前返回，很符合递归的思想。
			j = this.next(i,j);
		}
	}

	//广度优先遍历，这里因为非连同图在使用广度优先遍历的时候可能拿不到所有的元素，所以就需要遍历所有起点。
	public void BFSTraverse(int i){
		Boolean[] visited = new Boolean[this.vertexCount()];
		for(int k = 0;k<visited.length;k++){
			visited[k] = false;
		}
		int j = i;
		do{
			if(!visited[j]){
				System.out.print("{");
				this.breathfs(j,visited);
				System.out.print("}");
			}
			j = (j+1)%this.vertexCount();
		}while(j!=i);
	}
	/**
	 * 广度优先遍历的过程就是先打印然后入队列设置以访问，然后将其所有可访问节点入队列，
	 * 之后将首个元素出队列再执行一遍一直到队列空空。
	 */
	private void breathfs(int i,Boolean[] visited){
		System.out.print("\t"+this.getVertex(i)+"\t");
		//打印第一个元素
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		visited[i] = true;
		//设置已访问
		queue.add(i);
		//入队列
		while(!queue.isEmpty()){
			i = queue.poll();
			//第一个元素出队列，将他的所有可达元素入队列，访问并且设置以访问
			for(int j = next(i,-1);j!=-1;j=next(i,j)){
				if(!visited[j]){
					System.out.print(this.getVertex(j)+"\t");
					visited[j] = true;
					queue.add(j);
				}
			}
		}
	}
}
