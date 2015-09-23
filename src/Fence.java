import java.util.Scanner;


public class Fence {
	private static long[] fences;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int C = scanner.nextInt();
		
		for(int i = 0; i < C; i++)	{
			int N =  scanner.nextInt();
			fences = new long[N];
			for(int j = 0; j < N; ++j)	{
				fences[j] = scanner.nextLong();
			}
			System.out.println(getArea(0, N - 1));
		}
	}
	
	public static long getArea(int start, int end)	{
		long maxArea;
		long minHeight;
		
		if(start == end)	{
			// BaseCase
			maxArea = fences[start];
		} else if((end-start) == 1)	{
			// 바료 옆으로 하나만 늘리는 경우
			maxArea = max(fences[start],fences[end]);
			minHeight = min(fences[start],fences[end]);	
			maxArea = max(maxArea, 2*minHeight);
		} else	{
			int mid = (start + end) / 2;
			int left = mid - 1, right = mid + 1;
			maxArea = fences[mid];
			minHeight = fences[mid];
			while((left >= start) || (right <= end))	{
				if(left < start)	{
					minHeight = min(minHeight, fences[right++]);
					maxArea = max(maxArea, (right - left - 1) * minHeight);
				} else if(right > end)	{
					minHeight = min(minHeight, fences[left--]);
					maxArea = max(maxArea, (right - left - 1) * minHeight);
				} else if(fences[left] > fences[right])	{
					minHeight = min(minHeight, fences[left--]);
					maxArea = max(maxArea, (right - left - 1) * minHeight);
				} else	{
					minHeight = min(minHeight, fences[right++]);
					maxArea = max(maxArea, (right - left - 1) * minHeight);
				}
			}
		
			long leftMaxArea = getArea(start, mid - 1);
			long rightMaxArea = getArea(mid + 1, end);
			
			maxArea = max(maxArea, leftMaxArea);
			maxArea = max(maxArea, rightMaxArea);
		}
		
		return maxArea;
	}
	public static long min(long a, long b)	{
		if(a < b)
			return a;
		else
			return b;
	}
	public static long max(long a, long b)	{
		if(a > b)
			return a;
		else
			return b;
	}
}
