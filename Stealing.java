import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class Stealing{
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("stealing.dat"));	
		int numTimes = in.nextInt();
		in.nextLine();


		for (int its = 1; its <= numTimes; its++){
			int n = in.nextInt();
			int m = in.nextInt();
			int t = in.nextInt();

			int x = n/m * 2;
			x = (n % m > 0)? x + 1: x - 1;

			out.println(x * t);
		}
	}
}
