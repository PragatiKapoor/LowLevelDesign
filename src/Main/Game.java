package Main;

import java.util.*;
import Model.*;

public class Game {
	Deque<Player> players;
	Board gameboard;
	Game() {
		initializeGame();
	}
	public void initializeGame() {
		//Creating 2 players
		players=new LinkedList<>();
		PieceX crossplayer = new PieceX();
		Player player1 =new Player("Player 1",crossplayer);
		
		PieceO zeroplayer = new PieceO();
		Player player2 =new Player("Player 2",zeroplayer);
		
		players.add(player1);
		players.add(player2);
		
		gameboard=new Board(3);
	}
	public String startGame() {
		
		boolean noWinner = true;
		
		while(noWinner) {
			Player playturn =players.removeFirst();
			
			gameboard.printBoard();
			
			List<Pair<Integer,Integer>> freespaces=gameboard.getFreeCells();
			
			if(freespaces.isEmpty()) {
				noWinner =false;
				continue;
			}
			
			System.out.print("Player : "+playturn.getName()+" Enter row,col : ");
			Scanner sc=new Scanner(System.in);
			String s=sc.nextLine();
			String[] values = s.split(",");
			int row=Integer.parseInt(values[0]);
			int col=Integer.parseInt(values[1]);
			
			boolean pieceAdded=gameboard.addPiece(row, col, playturn.getPp());
			if(!pieceAdded) {
				System.out.println("Incorrect position, try again ");
				players.addFirst(playturn);
				continue;
			}
			players.addLast(playturn);
			boolean winner =isThereWinner(row,col,playturn.getPp().pt);
			
			if(winner)
				return playturn.getName();
		}
		return "Tie" ; 
	}
	private boolean isThereWinner(int row, int col, PieceType pt) {
		
		boolean rowMatch = true;
		boolean colMatch = true;
		boolean diagonalMatch = true;
		boolean antiDiagonalMatch = true;
		
		//row
		for(int x=0;x<gameboard.size;x++) {
			if(gameboard.board[row][x] == null || gameboard.board[row][x].pt != pt)
				rowMatch =false;
		}
		
		//column
		for(int x=0;x<gameboard.size;x++) {
			if(gameboard.board[x][col] == null || gameboard.board[x][col].pt != pt)
				colMatch =false;
		}
		
		//diagonal
		for(int x=0;x<gameboard.size;x++) {
			if(gameboard.board[x][x] == null || gameboard.board[x][x].pt != pt)
				diagonalMatch =false;
		}
		
		//Antidiagonal
		for(int x=0,y=gameboard.size-1;x<gameboard.size;x++,y--) {
			if(gameboard.board[x][y] == null || gameboard.board[x][y].pt != pt)
				antiDiagonalMatch =false;
		}
		return rowMatch || colMatch || diagonalMatch || antiDiagonalMatch;
	}
}
