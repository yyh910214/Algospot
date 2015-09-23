/**
 * @file CompareTwoFile.java
 * @date 2015. 4. 13.
 * @author yyh
 */
package Codejam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CompareTwoFile {
	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedReader br2 = null;
		try {
			br = new BufferedReader(new FileReader("output.txt"));
			br2 = new BufferedReader(new FileReader("output2.txt"));

			int c1;
			int line = 1;
			int width = 1;
			boolean isIncorrect = false;
			while((c1 = br.read()) != -1)	{
				width++;
				char ch1 = (char)c1;
				char ch2 = (char)br2.read();
				if(ch1 == '\n')	{
					line++;
					width = 1;
				}
				if(ch1 != ch2){
					isIncorrect = true;
					break;
				}
			}
			
			if(isIncorrect)	{
				System.out.println("INCORRECT");
				System.out.println(line);
				System.out.println(width);
			} else	{
				System.out.println("CORRECT");
			}

			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (br2 != null)
					br2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
