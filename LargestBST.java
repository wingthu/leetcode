import java.util.*;

public class LargestBST{
	
	// find largest BST starting from root
	private static class Solution{
		int count;
		Node node = null;
		Solution(int count, Node node){
			this.count = count;
			this.node = node;
		}
		Solution(int count){
			this.count = count;
		}
	}
	
	private static Solution findLargestBSTfromRoot(Node root){
		if(root == null) return new Solution(0);
		int count = 1;
		if(root.left != null && root.left.value < root.value){
			count += findLargestBSTfromRoot(root.left).count;
			root.left = findLargestBSTfromRoot(root.left).node;
		}
		else root.left = null;
		if(root.right != null && root.right.value > root.value){
			count += findLargestBSTfromRoot(root.right).count;
			root.right = findLargestBSTfromRoot(root.right).node;
		}
		else root.right = null;
		return new Solution(count, root);
	}

	public static Node findLargestBST(Node root){
		if(root == null) return null;
		LinkedList<Node> nodeList = new LinkedList<Node>();
		LinkedList<Boolean> checkList = new LinkedList<Boolean>();
		int largest_count = 0;
		Node largest_root = null;
		nodeList.add(root);
		checkList.add(true);
		while(!nodeList.isEmpty()){
			Node currentRoot = nodeList.poll();
			boolean check = checkList.poll();
			if (check){
				Solution sol = findLargestBSTfromRoot(currentRoot);
				int count = sol.count;
				if(count > largest_count){
					largest_root = sol.node;
					largest_count = count;
				}
			}
			if(currentRoot.left != null){
				nodeList.add(currentRoot.left);
				if(currentRoot.left.value < currentRoot.value){
					checkList.add(false);
				}
				else checkList.add(true);
			}
			if(currentRoot.right != null){
				nodeList.add(currentRoot.right);
				if(currentRoot.right.value > currentRoot.value){
					checkList.add(false);
				}
				else checkList.add(true);
			}
		}
		return largest_root;		
	}
	public static void main(String[] args){
		int[] inorder = {5, 10, 0, 2, 8, 7, 3, 6, 15, 20};
		int[] preorder = {15, 10, 5, 7, 2, 0, 8, 6, 3, 20};
		Node root = TraverseTree.solution(inorder, preorder);
		root = findLargestBST(root);
		Helper.printTree(root);
	}
}