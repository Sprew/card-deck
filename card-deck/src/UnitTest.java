import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class UnitTest {
	
	private Deck deck;
	private List<Card> cards;
	private ArrayList<Card> pulledCards;
	Card firstCard;
	Card lastCard;

	@Before
	public void init() {
		firstCard = new Card(Suit.values()[0], Rank.values()[0], 0);
		lastCard = new Card(Suit.values()[Suit.values().length-1],
								 Rank.values()[Rank.values().length-1], 51);
		pulledCards = new ArrayList<Card>();
		cards = new ArrayList<Card>(Suit.values().length * Rank.values().length);
		deck = new Deck(cards, pulledCards);
	}
	
	@Test
	public void createDeckTest() {
		deck.createDeck();
		cards = deck.getDeck();
		
		assertEquals("Creating deck.", 52 , deck.getDeck().size());
		assertEquals("Checking first card", firstCard.getValue(), deck.getDeck().get(0).getValue());
		assertEquals("Checking last card", lastCard.getValue(), deck.getDeck().get(51).getValue());
	}
	
	@Test
	public void shuffleDeckTest() {
		deck.createDeck();
		deck.shuffleDeck(deck.getDeck());
		
		assertThat(firstCard.getValue(), not(deck.getDeck().get(0).getValue()));
		assertThat(lastCard.getValue(), not(deck.getDeck().get(51).getValue()));
	}
	
	@Test
	public void sortDeckTest() {
		deck.createDeck();
		deck.shuffleDeck(cards);
		deck.sortDeck(deck.getDeck());
		
		assertEquals("Checking first card", firstCard.getValue(), deck.getDeck().get(0).getValue());
		assertEquals("Checking last card", lastCard.getValue(), deck.getDeck().get(51).getValue());
	}

	@Test
	public void drawCardTest() {
		deck.createDeck();
		
		assertTrue(deck.drawCard(deck.getDeck()));
	}
}
