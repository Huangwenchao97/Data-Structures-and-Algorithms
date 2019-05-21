package graph;

import java.util.LinkedList;

public class Graph {

	private int size;
	// �������
	private String[] node;
	// �ڽӾ���, ֵΪȨֵ, -1��ʾ����ͨ, 
	private int[][] matrix;
	// �洢����Ƿ񱻷��ʹ�, ��Ҫ������������
	private boolean[] visited;
	
	public Graph(int[][] matrix, String[] node) {
		this.size = node.length;
		this.matrix = matrix;
		this.node = node;
		visited = new boolean[size];
	}
	
	// �������
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
	
	// �������
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
	
	// ������ȵݹ��㷨
	private void DFS(int i) {
		visited[i] = true;
		System.out.print(node[i] + "\t");
		for (int j = 0; j < size; j++) {
			if(matrix[i][j] >= 1 && !visited[j]) {
				DFS(j);
			}
		}
	}
	// ������ȱ���
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
	
	// ������ȱ���
	public void BFSTraverse() {
		System.out.println("BFS:");
		// ��ʼ��visited��
		for (int j = 0; j < size; j++) {
			visited[j] = false;
		}
		LinkedList<String> queue = new LinkedList<>();
		// ����һ��������
		queue.offer(node[0]);
		visited[0] = true;
		// �����в�Ϊ��
		while(!queue.isEmpty()) {
			// ������, �����
			String tmp = queue.poll();
			System.out.print(tmp + "\t");
			int index = -1;
			// ��ѯ���ӽ���������ж�Ӧ���±�
			for (int i = 0; i < size; i++) {
				if(node[i] == tmp)
					index = i;
			}
			// ������ӽ�������Ľ�����
			for(int i = 0; i < size; i++) {
				if(matrix[index][i] >= 1 && !visited[i]) {
					queue.offer(node[i]);
					visited[i] = true;
				}
			}
		}
		
		System.out.println("\n");
	}
	
	// ��ȡ�����֮���Ȩֵ
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
