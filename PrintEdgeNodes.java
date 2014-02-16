class PrintEdgeNodes{
	private static void printLeft(Node root, boolean print){
		if (root == null) return;
		if(print || (root.left == null && root.right == null)){
			System.out.println(root.value);
		}
		printLeft(root.left, print);
		printLeft(root.right, false);
	}
	private static void printRight(Node root, boolean print){
		if (root == null) return;
		printRight(root.left, false);
		printRight(root.right, print);
		if(print || (root.left == null && root.right == null)){
			System.out.println(root.value);
		}
		
	}
	public static void printEdges(Node root){
		System.out.println(root.value);
		printLeft(root.left, true);
		printRight(root.right, true);
	}

	public static void main(String[] args){
		Node root = Helper.generateTree(4, 1);
		printEdges(root);
	}
}
