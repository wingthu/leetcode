import java.util.*;

class PrimeNumbers{
	public static int[] generatePrimeNumbers(int n){
		if(n <= 1) return new int[0];
		boolean[] notPrime = new boolean[n + 1];
		int primeCount = 0;
		//LinkedList<Integer> primeList = new LinkedList<Integer>();
		for(int i = 2; i <= n; i++){
			if(notPrime[i] == false){
				primeCount++;
				//primeList.add(i);
				int k = 2;
				while(k * i <= n){
					notPrime[k*i] = true;
					k++;
				}
			}
		}
		int[] primeList = new int[primeCount];
		int j = 0;
		for(int i = 2; i <= n; i++){
			if(notPrime[i] == false){
				primeList[j] = i;
				j++;
			}
		}
		return primeList;
	}
	public static void main(String[] args){
		System.out.println(Arrays.toString(generatePrimeNumbers(100)));
	}
}