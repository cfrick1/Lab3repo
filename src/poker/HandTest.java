package poker;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import poker.Card;
import poker.Deck;
import poker.Hand;
import poker.eHandStrength;
import poker.eRank;
import poker.eSuit;

public class HandTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public final void TestFiveOfAKind1() {
		
		//just leaving rfHand variable because I'm lazy. Bad practice ftw.
		
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		rfHand.add(new Card(eSuit.SPADES,eRank.TEN));
		rfHand.add(new Card(eSuit.HEARTS,eRank.TEN));
		rfHand.add(new Card(eSuit.DIAMONDS,eRank.TEN));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be 5 of a kind:",eHandStrength.FiveOfAKind.getHandStrength(),h.getHandStrength());
	}
	
	@Test
	public final void TestFiveOfAKind2() {
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		rfHand.add(new Card(eSuit.Joker,eRank.Joker));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be 5 of a kind:",eHandStrength.FiveOfAKind.getHandStrength(),h.getHandStrength());
	}

	@Test
	public final void TestRoyalFlush1() {

		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS,eRank.QUEEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS,eRank.ACE));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be rf:",eHandStrength.RoyalFlush.getHandStrength(),h.getHandStrength());
		
	}

	@Test
	public final void TestRoyalFlush2() {
		
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS,eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS,eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.JACK));
		rfHand.add(new Card(eSuit.Joker,eRank.Joker));
		Hand h = Hand.EvalHand(rfHand);		
		
		assertEquals("Should be rf:",eHandStrength.RoyalFlush.getHandStrength(),h.getHandStrength());		
	}
	
	@Test
	public final void TestStraightFlush1() {
		
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS,eRank.KING));
		rfHand.add(new Card(eSuit.Joker,eRank.Joker));
		rfHand.add(new Card(eSuit.CLUBS,eRank.NINE));
		rfHand.add(new Card(eSuit.CLUBS,eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS,eRank.QUEEN));
		Hand h = Hand.EvalHand(rfHand);		
		
		assertEquals("Should be Sf:",eHandStrength.StraightFlush.getHandStrength(),h.getHandStrength());		
	}
	
	@Test
	public final void TestStraightFlush2() {
		
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS,eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.NINE));
		rfHand.add(new Card(eSuit.CLUBS,eRank.JACK));
		rfHand.add(new Card(eSuit.CLUBS,eRank.QUEEN));
		Hand h = Hand.EvalHand(rfHand);		
		
		assertEquals("Should be Sf:",eHandStrength.StraightFlush.getHandStrength(),h.getHandStrength());		
	}
	
	@Test
	public final void TestFourOfAKind1() {
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		rfHand.add(new Card(eSuit.Joker,eRank.Joker));
		rfHand.add(new Card(eSuit.HEARTS,eRank.TEN));
		rfHand.add(new Card(eSuit.DIAMONDS,eRank.TWO));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be 4 of a kind:",eHandStrength.FourOfAKind.getHandStrength(),h.getHandStrength());
	}
	
	@Test
	public final void TestFourOfAKind2() {
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS,eRank.EIGHT));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		rfHand.add(new Card(eSuit.Joker,eRank.Joker));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be 4 of a kind:",eHandStrength.FourOfAKind.getHandStrength(),h.getHandStrength());
	}
	
	@Test
	public final void TestFullHouse1() {
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS,eRank.EIGHT));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.EIGHT));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be full house:",eHandStrength.FullHouse.getHandStrength(),h.getHandStrength());
	}
	
	@Test
	public final void TestFullHouse2() {
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.Joker,eRank.Joker));
		rfHand.add(new Card(eSuit.CLUBS,eRank.EIGHT));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.EIGHT));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be full house:",eHandStrength.FullHouse.getHandStrength(),h.getHandStrength());
	}
	
	@Test
	public final void TestFlush1() {
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.CLUBS,eRank.QUEEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.EIGHT));
		rfHand.add(new Card(eSuit.CLUBS,eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be flush:",eHandStrength.Flush.getHandStrength(),h.getHandStrength());
	}
	
	
	@Test
	public final void TestFlush2() {
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.Joker,eRank.Joker));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.EIGHT));
		rfHand.add(new Card(eSuit.CLUBS,eRank.SIX));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be flush:",eHandStrength.Flush.getHandStrength(),h.getHandStrength());
	}
	
	@Test
	public final void TestStraight1() {
		//currently it's failing this test. idk why.
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.SPADES,eRank.QUEEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS,eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS,eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS,eRank.THREE));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be straight:",eHandStrength.Straight.getHandStrength(),h.getHandStrength());
	}
	
	@Test
	public final void TestStraight2() {
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.SPADES,eRank.QUEEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS,eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS,eRank.ACE));
		rfHand.add(new Card(eSuit.Joker,eRank.Joker));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be straight:",eHandStrength.Straight.getHandStrength(),h.getHandStrength());
	}
	
	@Test
	public final void TestThreeOfAKind1() {
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.SPADES,eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS,eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS,eRank.THREE));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be 3k:",eHandStrength.ThreeOfAKind.getHandStrength(),h.getHandStrength());
	}
	
	@Test
	public final void TestThreeOfAKind2() {
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.SPADES,eRank.TWO));
		rfHand.add(new Card(eSuit.Joker,eRank.Joker));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS,eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS,eRank.THREE));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be 3k:",eHandStrength.ThreeOfAKind.getHandStrength(),h.getHandStrength());
	}
	
	@Test
	public final void TestTwoPair1() {
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.SPADES,eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS,eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS,eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS,eRank.THREE));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be 2p:",eHandStrength.TwoPair.getHandStrength(),h.getHandStrength());
	}
	
	@Test
	public final void TestTwoPair2() {
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.SPADES,eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS,eRank.ACE));
		rfHand.add(new Card(eSuit.HEARTS,eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS,eRank.THREE));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be 2p:",eHandStrength.TwoPair.getHandStrength(),h.getHandStrength());
	}
	
	@Test
	public final void Pair1() {
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.SPADES,eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS,eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS,eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS,eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS,eRank.THREE));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be pair:",eHandStrength.Pair.getHandStrength(),h.getHandStrength());
	}
	
	@Test
	public final void Pair2() {
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.SPADES,eRank.TWO));
		rfHand.add(new Card(eSuit.Joker,eRank.Joker));
		rfHand.add(new Card(eSuit.CLUBS,eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS,eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS,eRank.EIGHT));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be pair:",eHandStrength.Pair.getHandStrength(),h.getHandStrength());
	}
	
	@Test
	public final void HighCard1() {
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.SPADES,eRank.TWO));
		rfHand.add(new Card(eSuit.CLUBS,eRank.QUEEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS,eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS,eRank.THREE));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be high card:",eHandStrength.HighCard.getHandStrength(),h.getHandStrength());
	}
	
	@Test
	public final void HighCard2() {
		ArrayList<Card> rfHand = new ArrayList<Card>();
		rfHand.add(new Card(eSuit.SPADES,eRank.KING));
		rfHand.add(new Card(eSuit.CLUBS,eRank.QUEEN));
		rfHand.add(new Card(eSuit.CLUBS,eRank.ACE));
		rfHand.add(new Card(eSuit.CLUBS,eRank.FIVE));
		rfHand.add(new Card(eSuit.CLUBS,eRank.THREE));
		Hand h = Hand.EvalHand(rfHand);
		
		assertEquals("Should be high card:",eHandStrength.HighCard.getHandStrength(),h.getHandStrength());
	}

}

