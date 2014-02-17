class UniquePath{
	private static int countUniquePath(int i, int j, int m, int n){
		if(i == m || j == n) return 1;
		else return countUniquePath(i + 1, j, m, n) + countUniquePath(i, j + 1, m, n);
	}
	public static int countPath(int m, int n){
		if(m < 1 || n < 1) return 0;
		else return countUniquePath(1, 1, m, n);
	}
	public static void main(String[] args){
		System.out.println(countPath(5, 5));
	}

}