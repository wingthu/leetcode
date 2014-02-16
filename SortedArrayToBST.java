class SortedArrayToBST{
	private static Node convert(int[] array, int i, int j){
		if (i < j) return null;
		int m = (i + j)/2;
		Node root = new Node(array[m]);
		root.left = convert(array, i, m - 1);
		root.right = convert(array, m + 1, j);
		return root;
	}
	public static Node convertToBST(int[] array){
		int len = array.length;
		if (len == 0) return;
		return convert(array, 0, len - 1);
	}
	public static void main(String[] args){
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Node root = convertToBST(array);
		Helper.printTree(root);
	}
}