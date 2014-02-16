class PopulateNextRight{
	static class Node{
		int value;
		Node left;
		Node right;
		Node nextRight;
		Node(int value){
			this.value = value;
		}
	}
	private static void connect(Node root){
		if(root == null) return;
		Node left = root.left;
		Node right = root.right;
		while(left != null && right != null){
			left.nextRight = right;
			left = left.right;
			right = right.left;
		}
		connect(root.left);
		connect(root.right);
	}
	private static Node generateTree(int depth, int i){
		if(depth == 0) return null;
		Node root = new Node(i);
		root.left = generateTree(depth - 1, 2 * i);
		root.right = generateTree(depth - 1, 2 * i + 1);
		return root;
	}

	private static void printTree(Node n){
		if(n == null) return;
		int right = (n.nextRight == null? 0 : n.nextRight.value);
		System.out.print(n.value);
		System.out.print(":");
		System.out.print(right);
		System.out.print("\r\n");
		printTree(n.left);
		printTree(n.right);
	}

	public static void main(String[] args){
		Node root = generateTree(4, 1);
		connect(root);
		printTree(root);
		//System.out.println(root.nextRight);
	}

}