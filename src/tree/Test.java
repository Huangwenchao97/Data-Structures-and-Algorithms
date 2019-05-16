package tree;

import tree.BinaryTree.TreeNode;

public class Test {

	public static void main(String[] args) {
		String[] nodes = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
		BinaryTree<String> tree = new BinaryTree<String>(nodes);
		
//		System.out.println(tree.getDeep());
//		System.out.println(tree.getSize());
		TreeNode<String> root = tree.getRoot();
		
		tree.recProTraverse();
		tree.nonRecProTraverse(root);
		
		tree.recInorderTraverse();
		tree.nonRecInorderTraverse(root);
		
		tree.recPostorderTraverse();
		tree.nonRecPostorderTraverse(root);
	}
}
