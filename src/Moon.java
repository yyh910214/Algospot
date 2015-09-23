import java.util.Scanner;

/**
 * @file Moon.java
 * @date 2014. 10. 9.
 * @author yyh
 */

/**
 * @author yyh
 *
 */
public class Moon {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		for(int i = 0; i < T; i++)	{
			int M = scanner.nextInt();
			int S = scanner.nextInt();
			int C = scanner.nextInt();
			
			double circleArea = Math.pow(M, 2.0) * Math.acos(-1.0);
			double moonArea = circleArea - getCoveredArea(M,S,C);
			System.out.printf("%.3f\n", moonArea);
		}
	}
	
	public static double getCoveredArea(double r1, double r2, double distance)	{
//		double S = (0.5)*(
//				(Math.pow(r1, 2.0)*calPart1(distance, r1, r2) - Math.sin(calPart1(distance, r1, r2)))
//				+ (Math.pow(r2, 2.0)*calPart2(distance, r1, r2) - Math.sin(calPart2(distance, r1, r2))) );
//		return S;
		double t1 = getAngle1(r1,r2,distance);
		double t2 = getAngle2(r1,r2,distance);
		double S = Math.pow(r1, 2.0)*0.5*getAngle1(r1,r2,distance) +
				Math.pow(r2, 2.0)*0.5*getAngle2(r1,r2,distance) -
				distance*r1*Math.sin(getAngle1(r1,r2,distance)/2);
		return S;
	}
	
	public static double getAngle1(double r1, double r2, double distance)	{
		double temp = (Math.pow(distance, 2.0)-Math.pow(r1, 2.0)+Math.pow(r2, 2.0))/(2*r1*distance);
		return 2*Math.acos((Math.pow(r1, 2.0)-Math.pow(r2, 2.0)+Math.pow(distance, 2.0))/(2*r1*distance));
	}
	public static double getAngle2(double r1, double r2, double distance)	{
		return 2*Math.acos((Math.pow(r2, 2.0)-Math.pow(r1, 2.0)+Math.pow(distance, 2.0))/(2*r2*distance));
	}
	
	public static double calPart1(double a, double b, double c)	{
		double temp = (Math.pow(a, 2.0)-Math.pow(b, 2.0)+Math.pow(c, 2.0))/(2*b*a);
		return 2*Math.acos((Math.pow(a, 2.0)-Math.pow(b, 2.0)+Math.pow(c, 2.0))/(2*b*a));
	}
	
	public static double calPart2(double a, double b, double c)	{
		return 2*Math.acos((Math.pow(a, 2.0)+Math.pow(b, 2.0)-Math.pow(c, 2.0))/(2*c*a));
	}
	
	
}
