
public class Multiples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int summ = 0;
		for(int i = 0; i <= 1000000000; i++)
		{
			if (i % 3 == 0 || i % 5 == 0)
			{
				summ += i;
			}
		}
		System.out.println(summ);
		
		int sum = 0;
		for (int i = 1 ; i <= Math.floorDiv(1000000000, 3) ; i ++){
			sum += i*3;
		}
		for (int i = 1 ; i <= Math.floorDiv(1000000000, 5) ; i ++){
			sum += i*5;
		}
		for (int i = 1 ; i <= Math.floorDiv(1000000000, 15) ; i ++){
			sum -= i*15;
		}
		System.out.println(sum);

	}

}
