import java.util.Scanner;

/**
 * @file WeeklyCalendar.java
 * @date 2015. 4. 9.
 * @author yyh
 */

public class WeeklyCalendar {
	static String[] weekDay = {
			"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
	};
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int T = Integer.parseInt(input.nextLine());
		int[] lastDay = {
				31,31,28,31,30,31,30,31,31,30,31,30,31
		};
		
		while(T-->0)	{
			
			String[] strings = input.nextLine().split(" ");
			int month = Integer.parseInt(strings[0]);
			int date = Integer.parseInt(strings[1]);
			int day = findDay(strings[2]);
			
			int i;
			/*
			 * 오늘보다 앞의 요일 출력하기
			 * 일요일 - 오늘까지
			 */
			for(i = 0; i <= day; ++i)	{
				int diff = date-day+i;
				if(diff < 1)	{
					System.out.print(lastDay[month-1]+diff);
					//이전달 출력하기
				} else	{
					System.out.print(diff);
				}
				
				if(i != 6)	{
					System.out.print(" ");
				}
			}
			
			/*
			 * 오늘 이후 출력하기
			 */
			for(; i < 7; ++i)	{
				int temp = date + (i-day); 
				if(temp - lastDay[month] > 0)	{
					System.out.print(temp - lastDay[month]);
				} else	{
					System.out.print(temp);
				}
				
				if(i != 6)	{
					System.out.print(" ");
				}
			}
			
			System.out.println();
		}
	}
	
	public static int findDay(String dayString)	{
		int day = 0;
		for(int i = 0; i < 7; ++i)	{
			if(weekDay[i].equals(dayString))	{
				day = i;
			}
		}
		
		return day;
	}
}
