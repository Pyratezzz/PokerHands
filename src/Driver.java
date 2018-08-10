import java.util.List;

class Driver{
	public static void main(String[] args){
		
		Deck deck = new Deck();
		List<Card> cards = deck.getNCards(5);
		cards.clear();
		cards.add(new Card("Diamond","J"));
		cards.add(new Card("Diamond","10"));
		cards.add(new Card("Diamond","9"));
		cards.add(new Card("Diamond","Q"));
		cards.add(new Card("Diamond","K"));
		for(int i=0;i<cards.size();i++){
			System.out.println(cards.get(i).getValue()+" "+cards.get(i).getSuit());
		}
		PokerHand hand = new PokerHand(cards);
		System.out.println(hand.findHandRank());
	}
}
