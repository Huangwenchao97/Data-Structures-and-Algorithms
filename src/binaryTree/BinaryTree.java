package binaryTree;

import java.util.Stack;

public class BinaryTree<T> {

	// 根节点
	private TreeNode<T> root = null;
	// 用来进行非递归遍历的栈
	private Stack<TreeNode<T>> stack = new Stack<>();
	/**
	 *.构造器
	 * @param arr 存放完全二叉树所有结点信息的数组， 采用按层序存储，值null表示该节点不存在。
	 *  .如{A, B, C, D, E, null, F}表示
	 * 			   A
	 * 		B		      C
	 * 	D		E	  			F
	 */
	public BinaryTree(T[] nodes) {
		root = createBinaryTree(nodes, 0, nodes.length);
	}
	
	private TreeNode<T> createBinaryTree(T[] nodes, int i, int length) {
		// 若nodes为空数组
		if(nodes.length == 0)
			return null;
		// 若为叶子节点, 或者nodes[i]值为null
		// nodes[i]值为null表示该节点不存在
		if(i >= length || nodes[i] == null) {
			return null;
		}
		TreeNode<T> subRoot = new TreeNode<T>(i, nodes[i]);
		subRoot.setLeftChild(createBinaryTree(nodes, 2*i+1, length));
		subRoot.setRightChild(createBinaryTree(nodes, 2*i+2, length));
		return subRoot;
	}

	/**
	 * .获取根节点
	 * @return root
	 */
	public TreeNode<T> getRoot(){
		return root;
	}
	
	/**
	 * .获取树的结点数
	 * @param node
	 * @return
	 */
	public int getSize() {
		return getSize(root);
	}
	private int getSize(TreeNode<T> node) {
		if(node == null) {
			return 0;
		} else {
			return getSize(node.getLeftChild()) + getSize(node.getRightChild()) + 1;
		}
	}
	
	/**
	 *.获取树的深度
	 *.1.根据树的结点个数size, 通过公式deep = log2(n) + 1 
	 *.2.采用递归,这里使用这个方法
	 */
	public int getDeep() {
		return getDeep(root);
	}
	private int getDeep(TreeNode<T> node) {
		// TODO Auto-generated method stub
		if(node == null) {
			return 0;
		} else {
			int left = getDeep(node.getLeftChild());
			int right = getDeep(node.getRightChild());
			return (left>right) ? (left+1) : (right+1);
		}
	}
	
	/**
	 * .递归的前序遍历
	 * @param node
	 */
	public void recProTraverse() {
		System.out.println("------------------递归前序遍历--------------------------");
		recProTraverse(root);
		System.out.print("\n");
	}
	private void recProTraverse(TreeNode<T> node) {
		if(node == null)
			return;
		else {
			System.out.print(node.getData() + "\t");
			recProTraverse(node.getLeftChild());
			recProTraverse(node.getRightChild());
		}
	}
	
	/**
	 * .非递归的前序遍历,利用栈的特性来实现,步骤如下
	 * .1.将根结点压入栈
	 * .2.循环判断，若栈不为空：
	 * .  2.1.根节点出栈
	 * .  2.2.若存在右子结点，将右子结点压入栈
	 * .  2.3.若存在左子节点，将左子结点压入栈
	 * @param node
	 */
	public void nonRecProTraverse(TreeNode<T> node) {
		System.out.println("------------------非递归前序遍历--------------------------");
		if(node == null)
			return;
		TreeNode<T> tmp;
		stack.push(node);
		TreeNode<T> leftChild, rightChild;
		while(!stack.isEmpty()) {
			tmp = stack.pop();
			System.out.print(tmp.getData() + "\t");
			if((rightChild = tmp.getRightChild()) != null)
				stack.push(rightChild);
			if((leftChild = tmp.getLeftChild()) != null)
				stack.push(leftChild);
		}
		System.out.print("\n");
	}
	

	/**
	 * .递归的中序遍历
	 * @param node
	 */
	public void recInorderTraverse() {
		System.out.println("------------------递归中序遍历--------------------------");
		recInorderTraverse(root);
		System.out.print("\n");
	}
	private void recInorderTraverse(TreeNode<T> node) {
		if(node == null)
			return;
		else {
			recInorderTraverse(node.getLeftChild());
			System.out.print(node.getData() + "\t");
			recInorderTraverse(node.getRightChild());
		}
	}
	
	/**
	 *. 非递归的中序遍历, 步骤如下：
	 *.1.循环判断(若栈为空且node为空，表示已经遍历完)
	 *.  1.1.若根节点不为空，则将根结点压入栈，继续判断根节点的左子节点
	 *.  1.2.若根节点为空，表示该结点没有左子节点，将其出栈，继续判断其右子节点
	 *.  注：若1.2中的根结点的右子结点为空，则应输出该根结点的父结点，再判断该根结点父结点的右子结点。而此时栈顶就是该根结点的父结点，所以将其出栈再判断其右结点
	 */
	public void nonRecInorderTraverse(TreeNode<T> node) {
		System.out.println("------------------非递归中序遍历--------------------------");
		TreeNode<T> tmp;
		while(!stack.isEmpty() || node != null) {
			if(node != null) {
				stack.push(node);
				node = node.getLeftChild();
			} else {
				tmp = stack.pop();
				System.out.print(tmp.getData() + "\t");
				node = tmp.getRightChild();
			}
		}
		System.out.print("\n");
	}
	

	/**
	 * .递归的后序遍历
	 * @param node
	 */
	public void recPostorderTraverse() {
		System.out.println("------------------递归后序遍历--------------------------");
		recPostorderTraverse(root);
		System.out.print("\n");
	}
	private void recPostorderTraverse(TreeNode<T> node) {
		if(node == null)
			return;
		else {
			recPostorderTraverse(node.getLeftChild());
			recPostorderTraverse(node.getRightChild());
			System.out.print(node.getData() + "\t");
		}
	}
	
	/**
	 *. 非递归的后序遍历
	 */
	public void nonRecPostorderTraverse(TreeNode<T> node) {
		System.out.println("------------------非递归后序遍历--------------------------");
		if(node == null) {
			return;
		}
		TreeNode<T> tmp = node;
		TreeNode<T> lastAccess = null;
		while(!stack.isEmpty() || tmp != null) {
			while(tmp != null) {
				stack.push(tmp);
				tmp = tmp.getLeftChild();
			}
			if(!stack.isEmpty()) {
				node = stack.pop();
				if(node.getRightChild() == null || node.getRightChild() == lastAccess) {
					System.out.print(node.getData() + "\t");
					lastAccess = node;
				} else {
					stack.push(node);
					tmp = node.getRightChild();
				}
			}
		}
		System.out.print("\n");
	}

	/**
	 * .结点类
	 * @author asus
	 *
	 * @param <T>
	 */
	public static class TreeNode<T>{
		private int index;
		private T data;
		private TreeNode<T> leftChild;
		private TreeNode<T> rightChild;
		
		public TreeNode(int index, T data) {
			 this.index = index;
			 this.data = data;
			 this.leftChild = null;
			 this.rightChild = null;
		}
		
		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public TreeNode<T> getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(TreeNode<T> leftChild) {
			this.leftChild = leftChild;
		}

		public TreeNode<T> getRightChild() {
			return rightChild;
		}

		public void setRightChild(TreeNode<T> rightChild) {
			this.rightChild = rightChild;
		}
	}

}
