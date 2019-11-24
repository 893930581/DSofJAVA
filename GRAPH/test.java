//package GRAPH;
//
//import MATRIX.LinkedMatrix;
//import MATRIX.Triple;
//
//public class test {
//    public static void main(String[] agrs){
//    	/**
//    	 * 测试链式稀疏矩阵图。
//    	 */
//        Triple[] tris = {new Triple(1,1,5),new Triple(2,2,3),new Triple(3,3,4)};
//        LinkedMatrix matrix = new LinkedMatrix(4,4,tris);
//        //创建矩阵
//        matrix.printMatrix();
//        //打印矩阵
//        matrix.set(new Triple(0,0,6));
//        //设置边（出了问题（在singlelist的search方法上。））
//        System.out.println(matrix.get(1,1));
//        //打印值（出了问题（在singlelist的search方法上。））
//        matrix.printMatrix();
//        //打印矩阵
//        System.out.print(matrix.toString());
//        //打印矩阵
//        
//        /**
//         * 测试二维数组邻接矩阵图。
//         */
//    	String[] vertexs = {"A","B","C","D","E"};
//    	Triple[] edges = {	new Triple(0,1,29),new Triple(0,3,16),new Triple(0,4,7),
//	            			new Triple(1,3,46),new Triple(1,2,9),new Triple(1,0,27),
//	            			new Triple(2,3,12),new Triple(3,4,67),new Triple(4,2,56)	};
//    	Matrixraph<String> graph = new Matrixraph<String>(vertexs,edges);
//    	//创建图
//    	System.out.println(graph.toString());
//    	//打印图
//    	graph.insertEdge(new Triple(4,3,7225));
//    	//插入边
//    	System.out.println(graph.toString());
//    	//打印图
//    	System.out.println(graph.weight(0, 3));
//    	//调用weight方法
//    	System.out.println("临界下一个元素是"+graph.next(0,-1));
//    	//调用next方法
//        graph.BFSTraverse(0);
//        graph.DFSTraverse(0);
//    }
//}
