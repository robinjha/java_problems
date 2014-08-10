/**
 * Write a program to shuffle a deck of 52 cards and shuffle them equally to 4 players.
 * 
 */

package ci.java.com;

public class Cards {
	
	public static final int SPADE = 4;
	public static final int HEART = 3;
	public static final int CLUB = 3;
	public static final int DIAMOND = 1;
	
	private static final String[] Rank ={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	private static final String[] Suit ={"d","c","s","h"};

	private byte cardRank;
	private byte cardSuit;
	
	public Cards(int suit, int rank){
		if(rank == 1){
			cardRank = 14;
		}else{
			cardRank = (byte) rank;
		}
		cardSuit = (byte) suit;
		
	}
	
	public int cardSuit(){
		return cardSuit;
	}
	
	
}
