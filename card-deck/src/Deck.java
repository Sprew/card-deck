import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Deck {
	
	public List<Card> cards;
	public ArrayList<Card> pulledCards;
	
	public static void main(String[] args) {
		new Deck();
	}
	
	public Deck(List<Card> cards, ArrayList<Card> pulledCards) {
		this.cards = cards;
		this.pulledCards = pulledCards;
	}
	
	public Deck() {
		pulledCards = new ArrayList<Card>();
		cards = new ArrayList<Card>(Suit.values().length * Rank.values().length);
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Create Deck.");
		System.out.println("2. Draw card from deck.");
		System.out.println("3. Shuffle Deck.");
		System.out.println("4. Sort Deck.");
		System.out.println("5. Show Deck.");
		System.out.println("6. Show all drawn cards.");
		while (sc.hasNextInt()) {
			switch (sc.nextInt()) {
			case 1:
				createDeck();	
				System.out.println("Deck created.");
				break;
			case 2:
				if(drawCard(cards))
					System.out.println("You draw: " + 
				pulledCards.get(pulledCards.size() - 1).getRank() + ", " + 
				pulledCards.get(pulledCards.size() - 1).getSuit());
				else
					System.out.println("There is no deck. Try to create one first.");
				break;
			case 3:
				shuffleDeck(cards);
				System.out.println("Deck shuffled.");
				break;
			case 4:
				sortDeck(cards);
				System.out.println("Deck sorted.");
				break;
			case 5:
				for(Card c : cards) {
					System.out.println(c.getRank() + ", " + c.getSuit());
				}
				break;
			case 6:
				for(Card c : pulledCards) {
					System.out.println(c.getRank() + ", " + c.getSuit());
				}
			}
		}
	}
	
	public void createDeck() {		
		cards.clear();
		pulledCards.clear();
		int value = 0;
		for(Suit s : Suit.values()) {
			for(Rank r : Rank.values()) {
				Card c = new Card(s, r, value);
				cards.add(c);
				value += 1;
			}
		}
	}
	
	public boolean drawCard(List<Card> cards) {
		if(!cards.isEmpty()) {
			pulledCards.add(cards.get(0));
			cards.remove(0);
			return true;
		} else {
			return false;
		}
	}
	public void shuffleDeck(List<Card> cards) {
		Collections.shuffle(cards);
	}
	
	public void sortDeck(List<Card> cards) {
		Collections.sort(cards);
	}
	
	public List<Card> getDeck() {
		return cards;
	}

}
