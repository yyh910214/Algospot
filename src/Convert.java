import java.util.Scanner;

/**
 * @file Convert.java
 * @date 2015. 4. 3.
 * @author yyh
 */

public class Convert {
	
	public static final String KILOGRAMS = "kg";
	public static final String POUNDS = "lb";
	public static final String LITERS = "l";
	public static final String GALLONS = "g";
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		
		int i = 1;
		while(T-->0)	{
			double N = input.nextDouble();
			String measurement = input.next();
			System.out.print(i++);
			convert(N, measurement);
		}
		
	}
	
	public static void convert(double n, String measurement)	{
		double result = 0;
		String resultMeasurement = "";
		switch(measurement){
		case KILOGRAMS:
			result = n * 2.2046;
			resultMeasurement = POUNDS;
			break;
		case POUNDS:
			result = n * 0.4536;
			resultMeasurement = KILOGRAMS;
			break;
		case LITERS:
			result = n * 0.2642;
			resultMeasurement = GALLONS;
			break;
		case GALLONS:
			result = n * 3.7854;
			resultMeasurement = LITERS;
			break;
		}
		
		System.out.printf(" %.4f " + resultMeasurement + "\n",result);
	}
}
