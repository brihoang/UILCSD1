import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class MandMs{
	
	public static final HashSet<Integer> PRIMES = new HashSet<Integer>(); //improve efficiency
	public static final HashSet<Integer> COMPOSITES = new HashSet<Integer>(); 

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("mandms.dat"));	
		int numTimes = in.nextInt();
		in.nextLine();


		for (int its = 1; its <= numTimes; its++){
			int x = in.nextInt();
			out.println(numMouthfuls(x));
		}
	}

	/**
	 * @param n the number of m and ms to eat
	 *
	 * @return the least amount of mouthfuls to eat n m and ms 
	 */
	public static int numMouthfuls(int n){
		if( n <=3 )
			return n;
		else if( isPrime(n) )
			return 1 + numMouthfuls(n-1);
		else
			return 1 + numMouthfuls(rowSize(n));
	
	}

	/**
	 * @param n the amount of m and ms to eat
	 *
	 * @return 1 if n is a prime number or the least amount possible left after a mouthful
	 */
	public static int rowSize(int n){
		for(int i = 2; i < n; i++){
			if(n % i == 0)
				return i;
		}	
		return -1;
	}

	/**
	 * @param n a number 
	 *
	 * @return true if n is prime, false if it is composite
	 */
	public static boolean isPrime(int n){
		if (n == 2 || PRIMES.contains(n))
			return true;
		if(n%2 == 0 || COMPOSITES.contains(n))
			return false;

		for(int i = 3; i < Math.sqrt(n); i+=2){
			if(n % i == 0){
				COMPOSITES.add(n);
				return false;
			}
		}
		PRIMES.add(n);
		return true;
	}
}
