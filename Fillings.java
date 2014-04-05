import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class Fillings{
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("fillings.dat"));	
		int numTimes = in.nextInt();
		in.nextLine();


		for (int its = 1; its <= numTimes; its++){
			int a = in.nextInt();
			int b = in.nextInt();
			int c = 1;

			for(int i = 0; i < a; i++){
				c *= (b - i);
			}
			out.println(c);
		}
	}
}
