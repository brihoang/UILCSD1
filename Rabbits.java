import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class Rabbits{
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("rabbits.dat"));	
		int numTimes = in.nextInt();
		in.nextLine();

		long[] rabbits = new long[115];

		rabbits[0] = 1;
		rabbits[1] = 1;
		rabbits[2] = 2;
		rabbits[3] = 3;

		for(int i = 4; i < 115; i++){
			rabbits[i] = rabbits[i-4] + rabbits[i-2] + rabbits[i-3];	
		}

		for (int its = 1; its <= numTimes; its++){
			int x = in.nextInt();

			System.out.println(rabbits[x-1]);
		}
	}
}
