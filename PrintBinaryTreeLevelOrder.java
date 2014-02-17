import java.util.*;

class PrintBinaryTreeLevelOrder{
	public static void printTree(Node root){
		if(root == null) return;
		LinkedList<Node> queue = new LinkedList<Node>();
		LinkedList<Integer> level = new LinkedList<Integer>();
		queue.add(root);
		level.add(1);
		int last_level = 1;
		while(!queue.isEmpty()){
			int l = level.poll();
			Node n = queue.poll();
			if(last_level != l){
				System.out.printf("\r");
				last_level = l; 
			}
			System.out.printf("%d  ", n.value);
			if(n.left != null) {
				queue.add(n.left);
				level.add(l + 1);
			}
			if(n.right != null) {
				queue.add(n.right);
				level.add(l+1);
			}
		}
	}
	public static void main(String[] args){
		int[] inorder = {5, 4, 3, 2, 1, 6};
		int[] preorder = {1, 2, 3, 4, 5, 6};
		Node root = TraverseTree.solution(inorder, preorder);
		printTree(root);
	}
}