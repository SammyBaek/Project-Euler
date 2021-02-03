
public class SmallestMultiple {
	public static void main (String [] args){
		long max = fib(20);
		for (long i = 1; i < max ; i ++){
			if (isDivisible(i,20)){
				System.out.println(i);
				break;
			}
		}
	}
	
	public static long fib(int n){
		long result;
		if (n ==1){
			return 1;
		}
		else{
			result = fib(n-1)*n;
			return result;
		}
	}
	
	public static boolean isDivisible(long a, long b){
		for(long i = 1; i < b; i++){
			if(a%i != 0)return false;
		}
		return true;
	}
}