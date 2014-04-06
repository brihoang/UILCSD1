import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class Json{

	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("json.dat"));	
		int numTimes = in.nextInt();
		in.nextLine();


		// the keys are the names of the objects themselves. The spec shoews that the objects themselves are
		// actually hashmaps, so we map them to a hashmap.
		HashMap<String, HashMap<String, String>> objects = new HashMap<String, HashMap<String, String>>();
		// this is made to maintain the order in which the keys are inserted in. 
		HashMap<String, LinkedList<String>> orders = new HashMap<String, LinkedList<String>>();

		for (int its = 1; its <= numTimes; its++){
			String command = in.nextLine();
			//assignment
			if( command.indexOf("=") >=0){
				String[] splits = command.trim().split("[\\. =]+"); // this splits the command into the three parts
				if(objects.containsKey(splits[0])){
					objects.get(splits[0]).put(splits[1], splits[2]);
					orders.get(splits[0]).addLast(splits[1]);
				}else{
					HashMap<String, String> x = new HashMap<String, String>();
					LinkedList<String> y = new LinkedList<String>();
					y.addLast(splits[1]);
					x.put(splits[1], splits[2]);
					objects.put(splits[0], x);
					orders.put(splits[0], y);

				}
			}else{ // print 
				String s = command.trim();
				s = s.substring(6, s.length() - 1);
				printObject(objects.get(s), orders.get(s));
			}
		}
	}

	/**
	 * @param obj the object to be printed
	 * @param  ord the order in which keys were inserted to the object
	 */
	public static void printObject(HashMap<String, String> obj , LinkedList<String> ord){
		String out = "{";
		for(String s: ord){
			out+= s + " : " + obj.get(s)+", ";
		}	
		out = out.substring(0, out.length() - 2);
		System.out.println(out + "}");
	}
}
