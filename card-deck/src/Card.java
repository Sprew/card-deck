import java.util.Comparator;

public class Card implements Comparable<Card>{
	private Suit suit;
	private Rank rank;
	private int value;

	public Card(Suit suit, Rank rank, int value) {
		this.suit = suit;
		this.rank = rank;
		this.value = value;
	}
	/* Getters. Setters not needed since a card cannot be changed when it's set. */
	public Suit getSuit() {
		return suit;
	}
	public Rank getRank() {
		return rank;
	}
	public int getValue() {
		return value;
	}
	/////////

	@Override
	public int compareTo(Card card2) {
		return this.getValue() - card2.getValue();
		
	}

}
