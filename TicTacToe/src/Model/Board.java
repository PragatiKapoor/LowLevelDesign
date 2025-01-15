package Model;

import java.util.*;

public class Board {
	public int size;
	public PlayingPiece[][] board;
	
	public Board(int size) {
		this.size=size;
		board= new PlayingPiece[size][size];
	}
	
	public boolean addPiece(int row,int col,PlayingPiece pp) {
		if(board[row][col] !=null)
			return false;
		board[row][col]=pp;
		return true;
	}
	
	public List<Pair<Integer,Integer>> getFreeCells() {
		List<Pair<Integer,Integer>> free=new ArrayList<>();
		for(int x=0;x<size;x++) {
			for(int y=0;y<size;y++) {
				if(board[x][y] == null ) {
					Pair<Integer,Integer> rowCol=new Pair<>(x,y);
					free.add(rowCol);
				}
					
			}
		}
		return free;
	}
	public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                   System.out.print(board[i][j].pt.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }

}
