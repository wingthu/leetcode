import java.util.*;

public class PrintZigZagBinaryTree{
	private static void printZigZagTree(Stack<Node> current, Stack<Node> next, boolean topRight){
		if(current.isEmpty()) return;
		while(!current.isEmpty()){
			Node n = current.pop();
			System.out.printf("%d ", n.value);
			if(topRight){
				if(n.right != null) next.push(n.right);
				if(n.left != null) next.push(n.left);
			}else{
				if(n.left != null) next.push(n.left);
				if(n.right != null) next.push(n.right);
			}
		}
		System.out.printf("\r");
		printZigZagTree(next, current, !topRight);
	}
	public static void printTree(Node root){
		if(root == null) return;
		Stack<Node> current = new Stack<Node>();
		Stack<Node> next = new Stack<Node>();
		current.push(root);
		printZigZagTree(current, next, false);
	}
	public static void main(String[] args){
		Node root = Helper.generateTree(5, 1);
		printTree(root);
	}
}