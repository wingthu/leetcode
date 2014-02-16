import java.util.*;

public class Helper {
	public static Node generateTree(int depth, int i){
		if(depth == 0) return null;
		Node root = new Node(i);
		root.left = generateTree(depth - 1, 2 * i);
		root.right = generateTree(depth - 1, 2 * i + 1);
		return root;
	}
	
	public static void printTree(Node root){
		if (root == null) return;
		LinkedList<Node> q = new LinkedList<Node>();
		LinkedList<Integer> level = new LinkedList<Integer>();
		q.add(root);
		level.add(1);
		while(!q.isEmpty()){
			Node n = q.poll();
			int l = level.poll();
			if (n.left != null) {
				q.add(n.left);
				level.add(l+1);
			}
			if (n.right != null) {
				q.add(n.right);
				level.add(l+1);
			}
			System.out.printf("level: %d -- value: %d \n", l, n.value);
			//System.out.println(n.value);
		}
	}
}