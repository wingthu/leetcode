public class SplittingLinkedList{
	public static Node split(Node list){
		if(list == null) return null;
		Node fast = list;
		Node slow = list;
		boolean slow_move = false;
		while(fast.right != null){
			if(slow_move){
				slow = slow.right;
				slow_move = false;
			}
			else{
				slow_move = true;
			}
			fast = fast.right;
		}
		Node list2 = slow.right;
		slow.right = null;
		return list2;
	}

	public static void main(String[] args){
		Node root = new Node(1);
		root.right = new Node(2);
		root.right.right = new Node(3);
		root.right.right.right = new Node(4);
		root.right.right.right.right = new Node(5);
		System.out.println(split(root).value);
	}
}