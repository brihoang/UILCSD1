import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class Bank{
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("bank.dat"));	
		int numTimes = in.nextInt();
		in.nextLine();


		for (int its = 1; its <= numTimes; its++){
			int sum = 0;
			int num = 0;
			String line = in.nextLine();
	
			String[]  number= line.split("[^0-9]+");

			for( String s: number){
				try{
					int x = Integer.parseInt(s);
					System.out.print(x + " ");
					num++;
					sum+=x;
				}catch(Exception e){
						
				}
			}

			if( num == 0 )
				System.out.print("-");
			System.out.println();
			System.out.println(sum);
		}
	
	}
}
