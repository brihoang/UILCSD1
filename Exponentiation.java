import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class Exponentiation{
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("exponentiation.dat"));	
		int numTimes = in.nextInt();
		in.nextLine();


		for (int its = 1; its <= numTimes; its++){
			double a = in.nextDouble();
			double b = in.nextDouble();
			int m = in.nextInt();

			double[] t = {a,b};
			double[] ans = exp(t, m);

			out.println("("+ans[0]+","+ans[1]+")");
		}
	}
	/**
	 * @param t1 must be 2 elements
	 * @param t2 must be 2 elements
	 *
	 * @return a 2 element array how two tuples should be multiplied as specified from the problem statement 
	 */
	public static double[] multiply(double[] t1, double[] t2){
		double a = t1[0];
		double b = t1[1];
		double c = t2[0];
		double d = t2[1];

		double[] ret = {a*c-b*d, a*d + b*c} ;	
		return ret;
	}

	/**
	 * @param t must be 2 elements
	 * @param e the exponent
	 *
	 * @return t^e as specified by the problem statement
	 */
	public static double[] exp(double[] t, int e){
		double[] cp = {t[0], t[1]};
		for(int i = 0; i < 	e - 1; i++){
			cp = multiply(cp, t);	
		}
		return cp;
	}
}
