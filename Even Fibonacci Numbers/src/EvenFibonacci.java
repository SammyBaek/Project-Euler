
public class EvenFibonacci {

	public static void main (String [] args)
	{
		int a = 1;
		int b = 1;
		int fib = 1;
		int sum = 0;
		while ( fib < 4000000)
		{
			fib = a+b;
			a = b;
			b = fib;
			System.out.println(fib);
			if (fib % 2 == 0){
				sum += fib;
			}
			
		}
		System.out.println("Sum: " + sum);
}
}