package GRAPH;

import LIST.SeqList;
import QUEUE.LinkedQueue;

public abstract class AbstractGraph<T extends Comparable> {
	//ͼ����������������㴫���Triple�������ġ�
	protected static final int MAX_WEIGHT = 0x0000ffff;
	protected SeqList<T>  vertexList;
	//�����Ա��涥�㡣
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
		return "���㼯��"+ this.vertexList.toString() + '\n';
	}
	//���ض��㼯�ϡ�
	public int insertVertex(T data){
		return this.vertexList.insert(data);
	}
	//β���루��Ϊ��ûд���أ�
	public T getVertex(int x){
		return this.vertexList.get(x);
	}
	//��ȡ
	protected abstract int next(int i ,int j);
	public void setVertex(int x,T data){
		this.vertexList.set(x, data);
	}

	//DFS������ȱ���
	public void DFSTraverse(int i){
		Boolean[] visited = new Boolean[this.vertexCount()];
		for(int k = 0;k<visited.length;k++){
			visited[k] = false;
		}
		int j = i;
		//�����j��iֻ��Ϊ��ȷ���Ƿ�����Ԫ�ض�����������ʵ�ʵı��޹ء�
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
				//�Ⱥ��Ե����һ�У���һ�о��ǴӶ�����nextһֱ�õ��ɷ��ʵ����һ��Ԫ�ء�
			}
			//�����һ����ʼ����ǰ���أ��ܷ��ϵݹ��˼�롣
			j = this.next(i,j);
		}
	}

	//������ȱ�����������Ϊ����ͬͼ��ʹ�ù�����ȱ�����ʱ������ò������е�Ԫ�أ����Ծ���Ҫ����������㡣
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
	 * ������ȱ����Ĺ��̾����ȴ�ӡȻ������������Է��ʣ�Ȼ�������пɷ��ʽڵ�����У�
	 * ֮���׸�Ԫ�س�������ִ��һ��һֱ�����пտա�
	 */
	private void breathfs(int i,Boolean[] visited){
		System.out.print("\t"+this.getVertex(i)+"\t");
		//��ӡ��һ��Ԫ��
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		visited[i] = true;
		//�����ѷ���
		queue.add(i);
		//�����
		while(!queue.isEmpty()){
			i = queue.poll();
			//��һ��Ԫ�س����У����������пɴ�Ԫ������У����ʲ��������Է���
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
