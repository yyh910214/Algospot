import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @file B.java
 * @date 2014. 11. 7.
 * @author yyh
 */

/**
 * @author yyh
 * 
 */
public class B {
	private static int EDGE = 5;
	private static int CROSS = 1;
	private static int NOCROSS = 0;
	private static int INFINITY = 4;
	private static int YET = -2;
	
	private static Map<String, Integer> map ;
	private static Set<String> set;
	private static Iterator iter;
	private static Scanner scanner = new Scanner(System.in);
	private static double minX, minY, maxX, maxY, startX, startY, endX, endY;

	public static void main(String[] args) {
		int Testcase = scanner.nextInt();
		
		map.keySet();
		iter = set.iterator();
		ArrayList<Double> list;

		while (Testcase-- > 0) {
			minX = scanner.nextDouble();
			minY = scanner.nextDouble();
			maxX = scanner.nextDouble();
			maxY = scanner.nextDouble();

			startX = scanner.nextDouble();
			startY = scanner.nextDouble();
			endX = scanner.nextDouble();
			endY = scanner.nextDouble();

			if(checkInfinity() == INFINITY)
				System.out.println(4);
			else if(checkInfinity() == NOCROSS)	{
				System.out.println(0);
			} else if(checkInfinity() == EDGE)	{
				System.out.println(1);
			}
			else	{
				int total = 0;
				total += isCrossX(startX, startY, endX, endY, minX);
				total += isCrossX(startX, startY, endX, endY, maxX);
				total += isCrossY(startX, startY, endX, endY, minY);
				total += isCrossY(startX, startY, endX, endY, maxY);
				
				int answer = (total/10)+(total%10);
				System.out.println(answer);
			}
		}
	}

	public static int checkInfinity() {
		boolean line;
		if (startX == endX) {
			if(startX > maxX || startX < minX)
				return NOCROSS;
			if((minX == startX) || (maxX == startX))
				line = true;
			else line = false;
			

			double max = Math.max(startY, endY);
			double min = Math.min(startY, endY);
			
			if(!line)	{
				if(min <= minY && max >= maxY)
					return CROSS*2;
				else if((max <= minY) || (min >= maxY) || ((minY > min) && (maxY < max)))
					return NOCROSS;
			}

			if ((max >= maxY && min < maxY) || (max < minY && min >= minY)) {
				return INFINITY;
			} else if((min == maxY) || (max == minY))	{
				return EDGE;
			} else
				return NOCROSS;

		} else if (startY == endY) {
			if(startY > maxY || startY < minY)
				return NOCROSS;
			
			if((minY == startY) || (maxY == startY))
				line = true;
			else line = false;

			double max = Math.max(startX, endX);
			double min = Math.min(startX, endX);
			
			if(!line)	{
				if(min <= minX && max >= maxX)
					return CROSS*2;
				else if((max <= minX) || (min >= maxX) || ((minX > min) && (maxX < max)))
					return NOCROSS;
			}

			if ((max >= maxX && min < maxX) || (max < minX && min >= minX)) {
				return INFINITY;
			} else if((min == maxX) || (max == minX))	{
				return EDGE;
			} else
				return NOCROSS;
		}
		
		return YET;
	}
	
	// X 값을 줄때
	public static int isCrossX(double startX, double startY, double endX, double endY, double value)	{
		double resultVal = (1-startX)*(endY-startY)*value/(endX-startX) + startY;
		
		double max = Math.max(startY, endY);
		double min = Math.min(startY, endY);
		
		if(resultVal < max && resultVal > min)
			return CROSS;
		else if(resultVal == max && resultVal == min)
			return EDGE;
		return NOCROSS;
	}
	
	public static int isCrossY(double startX, double startY, double endX, double endY, double value)	{
		double resultVal = (value-startY)*(endX-startX)/(1-startX)/(endY-startY);
		
		double max = Math.max(startX, endX);
		double min = Math.min(startX, endX);
		
		if(resultVal < max && resultVal > min)
			return CROSS;
		else if(resultVal == max && resultVal == min)
			return EDGE;
		return NOCROSS;
	}
}
