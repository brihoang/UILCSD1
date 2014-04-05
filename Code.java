import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class Code{
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("code.dat"));	
		int numTimes = in.nextInt();
		in.nextLine();


		for (int its = 1; its <= numTimes; its++){
			System.out.println("Protocol " + its);
			String shuffle = in.next().trim();
			int offset = in.nextInt();

			//express the offset as a positive number
			offset = (offset < 0)? 26 + offset: offset;

			//use two arrays to reduce time for decoding. Uses more space, but O(1) space is maintained, while O(n) time is maintained for both e/d
			char[] encode = new char[26];
			char[] decode = new char[26];

			//fill in arrays
			for(int i = 0; i < 26; i++){
				char c = shuffle.charAt(i);
				c = (char)((((c -'a') + offset)%26)+'a');
				encode[i] = c;
				decode[(int)c - 'a'] = (char)(i+'a');	
			}	

			//do the right amount of jobs for this key
			int numJobs = in.nextInt();

			for(int i = 0; i < numJobs; i++){
				char c = in.next().charAt(0);
				String line = in.nextLine().trim();
				String output = "";	
				for(int j = 0; j < line.length(); j++){
					char current = line.charAt(j);
					//only encode/decode lowercase letters
					if(current < 'a' || current > 'z')
						output+=current;
					else if(c == 'D')
						output+=decode[current - 'a'];
					else
						output += encode[current -'a'];
				} 
				out.println(output);
			}
			out.println();
		}
	}
}
