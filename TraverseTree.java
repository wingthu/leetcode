public class TraverseTree {

	private static class Node{
		int value;
		Node left;
		Node right;
		Node(int value){
			this.value = value;
		}
	}

	private static HashMap<Integer, Integer> generateIndexMap(int[] inorder){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int len = inorder.length;
		for(int i = 0; i < len; i++){
			map.put(inorder[i], i);
		}
		return map;
	}

	//build a tree from root from index i to index j in preorder
	//the corresponding tree has index from m to n in inorder
	private static Node traverse(int[] preorder, int i, int j, int m, int n, HashMap<Integer, Integer> map){
		if(i > j) return null;
		Node root = new Node(preorder[i]);
		int index = map.get(preorder[i]);
		int num_nodes_left = index - m;
		int num_nodes_right = n - index; 
		root.left = traverse(preorder, i + 1, i + num_nodes_left, m, index - 1, map);
		root.right = traverse(preorder, j - num_nodes_right + 1, j, index + 1, n, map);
		return root;
	}

	public static Node solution(int[] inorder, int[] preorder){
		int len = inorder.length;
		HashMap<Integer, Integer> map = generateIndexMap(inorder);
		return traverse(preorder, 0, len - 1, 0, len - 1, map);
	}
	
	public static void inorderTraverse(Node n){
		if(n == null) return;
		else{
			System.out.println(n.value);
			inorderTraverse(n.left);
			inorderTraverse(n.right);
		}
	}
	public static void main(String[] args) {
		int[] inorder = {4,10,3,1,7,11,8,2};
		int[] preorder = {7,10,4,3,1,2,8,11};
		Node n = TraverseTree.solution(inorder, preorder);
		inorderTraverse(n);
	}

}
