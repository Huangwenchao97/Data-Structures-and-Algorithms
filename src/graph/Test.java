package graph;

public class Test {
	public static void main(String[] args) {
		int[][] matrix = {{0, 10, -1, -1, -1, 11, -1, -1, -1},
						  {10, 0, 18, -1, -1, -1, 16, -1, 12},
						  {-1, -1, 0, 22, -1, -1, -1, -1, 8},
						  {-1, -1, 22, 0, 20, -1, -1, 16, 21},
						  {-1, -1, -1, 20, 0, 26, -1, 7, -1},
						  {11, -1, -1, -1, 26, 0, 17, -1, -1},
						  {-1, 16, -1, -1, -1, 17, 0, 19, -1},
						  {-1, -1, -1, 16, 17, -1, 19, 0, -1},
						  {-1, 12, 8, 21, -1, -1, -1, -1, 0}};
		
		String[] node = {"v0", "v1", "v2", "v3", "v4", "v5", "v6", "v7", "v8"};
		
		Graph graph = new Graph(matrix, node);
		
		graph.DFSTraverse();
		graph.BFSTraverse();
	}
}
