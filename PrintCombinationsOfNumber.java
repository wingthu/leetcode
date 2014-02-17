import java.util.*;

class PrintCombinationOfNumber{
	private static void getCombination(int[] sortedCandidates, int max_index, int[] solution, int residual){
		if (residual == 0){
			printSolution(sortedCandidates, solution);
			return;
		}
		else if (residual < 0 || max_index < 0) return;
		else{
			while(max_index >= 0 && sortedCandidates[max_index] > residual){
				max_index--;
			}
			if(max_index < 0) return;
			else{
				int i = residual / sortedCandidates[max_index];
				for(int k = 0; k <= i; k++){
					int add = k * sortedCandidates[max_index];
					int residual2 = residual - add;
					solution[max_index] = k;
					for(int j = 0; j < max_index; j++) solution[j] = 0;
					getCombination(sortedCandidates, max_index - 1, solution, residual2);
				}				
			}
		}
	}
	private static void printSolution(int[] sortedCandidates, int[] solution){
		int len = solution.length;
		boolean first = true;
		for(int i = 0; i < len; i++){
			if(solution[i] != 0) {
				if(first){
					first = false;
					System.out.printf("%d * %d", solution[i], sortedCandidates[i]);
				}
				else{
					System.out.printf("+ %d * %d", solution[i], sortedCandidates[i]);
				}
			}
		}
		System.out.printf("\r");
	}

	public static void printCombination(int[] candidates, int target){
		int len = candidates.length;
		if(len == 0) return;
		int[] solution = new int[len];
		Arrays.sort(candidates);
		getCombination(candidates, len - 1, solution, target);
	}

	public static void main(String[] args){
		int[] candidates = {2, 3, 6, 7};
		int target = 6;
		printCombination(candidates, target);
	}
}