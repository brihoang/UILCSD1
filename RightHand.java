import java.io.*;
import java.util.*;
import static java.lang.System.*;
public class RightHand{
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("righthand.dat"));	
		int numTimes = in.nextInt();
		in.nextLine();


		for (int its = 1; its <= numTimes; its++){
			int n = in.nextInt();
			in.nextLine();

			char[][] board = new char[n][n];
			// read in the board
			for( int i = 0; i < n; i++){
				String line = in.nextLine();
				for(int j = 0; j < n; j++){
					board[i][j] = line.charAt(j);
				}
			}
			if( hasPath(board) )
				out.println("YES");
			else
				out.println("NO");
		}
	}

	public static boolean hasPath(char[][] board){
		return hasPath(0, 0, board, new boolean[board.length][board.length]);	
	}
	
	/**
	 * @param x the current row
	 * @param y the current col
	 * @param board a maze board
	 * @param visited markers to avoid stack overflow
	 *
	 * @return if there is a path to the exit from board[x][y]
	 */
	private static boolean hasPath(int x, int y, char[][] board, boolean[][] visited){
		
		if( x == board.length - 1 &&  y == board.length - 1) // return true if currently at exit
			return true;
		else if ( x >= board.length || x < 0 || y >= board.length || y < 0 ){ // return false if out of bounds
			return false;
		}else if(visited[x][y] || board[x][y] == '#'){ //return false if already visited or is a wall
			return false;	
		}
		else{ //recursively check up down right and left if there is a path
			visited[x][y] = true;			
			boolean b =  hasPath(x - 1, y, board, visited) || hasPath(x + 1, y, board, visited) || hasPath(x, y + 1, board, visited) || hasPath(x, y-1, board, visited);
			return b;
		}
	}
}
