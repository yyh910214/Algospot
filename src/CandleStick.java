import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @file CandleStick.java
 * @date 2015. 4. 24.
 * @author yyh
 */

public class CandleStick {
	static int[] high = new int[2000];
	static int[] low = new int[2000]; 
	static int N;
	
	public static void main(String[] args) throws Exception {
		InputReader input = new InputReader(System.in);
		int T = input.nextInt();
		
		while(T-->0)	{
			N = input.nextInt();
			for(int i = 0; i < N; ++i)	{	
				low[i] = input.nextInt();
				high[i] = input.nextInt();
			}
			
			System.out.println(getScore());
		}
	}

	public static int getScore()	{
		int maxScore = 0;
		for(int i = 0; i < N; ++i)	{
			int max = high[i] - low[i];
			int maxHigh = high[i];
			int maxLow = low[i];
			
			for(int j = i+1; j < N; ++j)	{
				if(high[j] < maxHigh)	{
					maxHigh = high[j];
				}
				if(low[j] > maxLow)	{
					maxLow = low[j];
				}
				
				int temp = (maxHigh - maxLow) * (j - i + 1);
				if(temp > max)	{
					max = temp;
				}
			}
			
			if(maxScore < max)	{
				maxScore = max;
			}
		}
		
		return maxScore;
	}
}

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