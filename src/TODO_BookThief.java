import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @file BookThief.java
 * @date 2015. 4. 21.
 * @author yyh
 */

public class TODO_BookThief {
	// �� ���Ը��� �ִ� ����ġ�� ������ �迭
	static int[] maxValue;
	static int[][] bookAmount;
	static Book[] books;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		maxValue = new int[10001];
		bookAmount = new int [10001][100];
		books = new Book[100];
		
		int T = Integer.parseInt(br.readLine());
		
		int maxWeight;
		int bookCount;
		while(T-->0)	{
			String[] inputs = br.readLine().split(" ");
			
			bookCount = Integer.parseInt(inputs[0]);
			maxWeight = Integer.parseInt(inputs[1]);
			
			// maxValue�ʱ�ȭ
			for(int i = 0; i <= maxWeight; ++i)	{
				maxValue[i] = 0;
			}
			
			//book���� �Է�
			for(int i = 0; i < bookCount; ++i)	{
				String[] bookInfo = br.readLine().split(" ");
				books[i] = new Book(Integer.parseInt(bookInfo[0]), Integer.parseInt(bookInfo[1]));
				int amount = Integer.parseInt(bookInfo[2]);
				
				// �� ���Ը��� ���� å�� ��
				for(int j = 0; j <= maxWeight; ++j)	{
					bookAmount[j][i] = amount;
					
				}
				
			}
			
			int maxVal = 0;
			int maxIndex = 0;
			
			for(int i = 0; i <= maxWeight; ++i)	{
				int useBookIndex = -1;
				int max = -1;
				int beforeIndex = -1;
				
				for(int j = 0; j < bookCount; ++j)	{
					//�迭 ������ �ʰ��ϴ���, å�� ���� �ִ��� �˻�
					int nextIndex = i - books[j].size;
					if((nextIndex >= 0) && (bookAmount[nextIndex][j] != 0))	{
						int temp = maxValue[i - books[j].size] + books[j].value;
						if(temp > max)	{
							max = temp;
							useBookIndex = j;
							beforeIndex = nextIndex;
						}
					}
				}
				
				// ���� �� �ִ� å�� ã�� ���
				if(useBookIndex != -1)	{
					// ���� å �迭�� ����
					for(int j = 0; j < bookCount; ++j)	{
						bookAmount[i][j] = bookAmount[beforeIndex][j];
					}
					// ����� å�� �ϳ� ����
					bookAmount[i][useBookIndex]--;
					maxValue[i] = max;
				}
			}

			//System.out.println(result);
				
		}
		
		
	}
	
	public static class Book	{
		int size;
		int value;
		
		public Book(int size, int value)	{
			this.size = size;
			this.value = value;
		}
	}
}
