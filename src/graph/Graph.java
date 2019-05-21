package graph;

import java.util.LinkedList;

public class Graph {

	private int size;
	// 结点数组
	private String[] node;
	// 邻接矩阵, 值为权值, -1表示不连通, 
	private int[][] matrix;
	// 存储结点是否被访问过, 主要用来辅助遍历
	private boolean[] visited;
	
	public Graph(int[][] matrix, String[] node) {
		this.size = node.length;
		this.matrix = matrix;
		this.node = node;
		visited = new boolean[size];
	}
	
	// 计算出度
	public int getOutDegree(int index) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			int weight = matrix[index][i];
			if(weight != -1 && weight != 0) {
				count++;
			}
		}
		return count;
	}
	
	// 计算入度
	public int getInDegree(int index) {
		int count = 0;
		for (int i = 0; i < size; i++) {
			int weight = matrix[i][index];
			if(weight != -1 && weight != 0) {
				count++;
			}
		}
		return count;
	}
	
	// 深度优先递归算法
	private void DFS(int i) {
		visited[i] = true;
		System.out.print(node[i] + "\t");
		for (int j = 0; j < size; j++) {
			if(matrix[i][j] >= 1 && !visited[j]) {
				DFS(j);
			}
		}
	}
	// 深度优先遍历
	public void DFSTraverse() {
		System.out.println("DFS:");
		for (int i = 0; i < size; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < size; i++) {
			if(!visited[i]) {
				DFS(i);
			}
		}
		System.out.println("\n");
	}
	
	// 广度优先遍历
	public void BFSTraverse() {
		System.out.println("BFS:");
		// 初始化visited表
		for (int j = 0; j < size; j++) {
			visited[j] = false;
		}
		LinkedList<String> queue = new LinkedList<>();
		// 将第一个结点入队
		queue.offer(node[0]);
		visited[0] = true;
		// 若队列不为空
		while(!queue.isEmpty()) {
			// 结点出队, 并输出
			String tmp = queue.poll();
			System.out.print(tmp + "\t");
			int index = -1;
			// 查询出队结点在数组中对应的下标
			for (int i = 0; i < size; i++) {
				if(node[i] == tmp)
					index = i;
			}
			// 将与出队结点相连的结点入队
			for(int i = 0; i < size; i++) {
				if(matrix[index][i] >= 1 && !visited[i]) {
					queue.offer(node[i]);
					visited[i] = true;
				}
			}
		}
		
		System.out.println("\n");
	}
	
	// 获取两结点之间的权值
	public int getWeight(int v1, int v2) {
		return matrix[v1][v2];
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
}
