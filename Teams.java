import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class Teams{
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("teams.dat"));	
		int numTimes = in.nextInt();
		in.nextLine();

		ArrayList<Contestant> young = new ArrayList<Contestant>();
		ArrayList<Contestant> old = new ArrayList<Contestant>();


		ArrayList<Contestant> contestants = new ArrayList<Contestant>();

		for (int its = 1; its <= numTimes; its++){
			int age = in.nextInt();
			int rating  = in.nextInt();


			Contestant n = new Contestant(age, rating);

			contestants.add(n);
			Collections.sort(contestants);

			int youngSum = 0;
			int oldSum = 0;

			int cutoff = contestants.size()/2 + contestants.size()%2;

			for(int i =0; i < contestants.size(); i++){
				Contestant c = contestants.get(i);
				if(i < cutoff)
					youngSum += c.rating;
				else
					oldSum+= c.rating;
			}
			out.println(Math.abs(oldSum - youngSum));

		}
	}
}
class Contestant implements Comparable<Contestant>{
	int age;
	int rating;

	public Contestant(int x, int y){
		age = x;
		rating = y;
	}

	public int compareTo(Contestant o){
		return this.age - o.age;	
	}



}
