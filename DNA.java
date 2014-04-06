import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class DNA{
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("dna.dat"));	
		int numTimes = in.nextInt();
		in.nextLine();


		for (int its = 1; its <= numTimes; its++){
			String strand1 = in.nextLine().toUpperCase().trim();
			String strand2 = in.nextLine().toUpperCase().trim();

			//make sure lengths of strands are the same. 
			if(strand1.length() != strand2.length()){
				out.println("BAD");
				continue;
			}

			boolean good = true;
			for(int i = 0; i < strand1.length(); i++){
				char c1 = strand1.charAt(i);
				char c2 = strand2.charAt(i);

				// make sure pairings are correct
				if(!(c1 == 'A' && c2 == 'T' || c1 == 'T' && c2 == 'A' || c1 == 'C' && c2 == 'G' || c1 == 'G' && c2 == 'C')){
					out.println("BAD");
					good = false;
					break;
				}
					
			}

			if(good)
				out.println("GOOD");
		}
	}
}
