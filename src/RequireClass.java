import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @file RequireClass.java
 * @date 2015. 4. 25.
 * @author yyh
 */

public class RequireClass {

	class InputReader	{
		static String DELIM = " ";
		BufferedReader br;
		String[] strings;
		int index;
		
		public InputReader(InputStream in)	{
			this(new InputStreamReader(in));
		}
		
		public InputReader(InputStreamReader reader)	{
			this(new BufferedReader(reader));
		}
		
		public InputReader(BufferedReader br)	{
			this.br = br;
		}
		
		public String nextString()	{
			readNextLine();
			return strings[index++];
		}
		
		public int nextInt()	{
			return Integer.parseInt(nextString());
		}
		
		public double nextDouble()	{
			return Double.parseDouble(nextString());
		}
		
		public void readNextLine()	{
			if(strings == null || strings.length == index)	{
				try {
					strings = br.readLine().split(DELIM);
					index = 0;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public String nextLine()	{
			try {
				return br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;
		}
	}
}


