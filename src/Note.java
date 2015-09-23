import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @file Note.java
 * @date 2015. 4. 27.
 * @author yyh
 */

public class Note {
	static char[] ascending = {
		'1','2','3','4','5','6','7','8'
	};
	
	static char[] decending = {
		'8','7','6','5','4','3','2','1'
	};
	public static void main(String[] args) throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int state = 0;
		char[] target = null;
		String in = input.readLine();
		if(in.charAt(0) == '1')	{
			target = ascending;
		}
		else if(in.charAt(0) == '8')	{
			target = decending;
		} else	{
			System.out.println("mixed");
			return;
		}
		
		if(target != null)	{
			int j = 2;
			for(int i = 1; i < 8; ++i)	{
				if(target[i] != in.charAt(j))	{
					System.out.println("mixed");
					return;
				}
				j+=2;
			}
			
			if(target == ascending)	{
				System.out.println("ascending");
			} else	{
				System.out.println("descending");
			}
		}
		
	}
}
