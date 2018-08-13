import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Driver{

	public static final int NUM_INPUT_CARDS = 7;
	public static final int NUM_HAND_CARDS = 5;
	public static ArrayList< ArrayList < Integer > > validCombinations = new ArrayList<>();

	public static Integer[] intialInput(int numCards){
		Integer[] input = new Integer[numCards];
		for(int i = 0; i < numCards; i++){ input[i] = i;}
		return input;
	}

	public static void combinationUtil(Integer[] input, Integer[] currCombination, int start, int end, int iter){

		if(iter == NUM_HAND_CARDS){
			validCombinations.add(new ArrayList<>(Arrays.asList(currCombination)));
			return;
		}

		for(int i = start; i <= end && end-i+1 >= NUM_HAND_CARDS-iter; i++){
			currCombination[iter] = input[i];
			combinationUtil(input, currCombination, i+1, end, iter+1);
		}
	}

	public static void generateCombinations(){

		Integer[] input = intialInput(NUM_INPUT_CARDS);
		Integer[] currCombination = new	 Integer[NUM_HAND_CARDS];

		combinationUtil(input, currCombination, 0, NUM_INPUT_CARDS-1, 0);

	}

	public static void printArray(int[] arr){
		for(int i : arr){System.out.print(i + "  ");}
		System.out.println();
	}

	public static void printList(ArrayList<Integer> list){
		for(int i = 0; i < list.size(); i++){System.out.print(list.get(i) + " ");}
		System.out.println();
	}

	public static void main(String[] args){

		Deck deck = new Deck();
		List<Card> cards = deck.getNCards(7);
		ArrayList<Card> chosenCards = new ArrayList<>();

		generateCombinations();

		for(int i = 0; i < validCombinations.size(); i++){
			System.out.println("--------------------Trail # " + (i+1) + "---------------------------------------");
			ArrayList<Integer> index = validCombinations.get(i);
			for(int j=0;j<index.size();j++){
				chosenCards.add(cards.get(index.get(j)));
				System.out.println(chosenCards.get(j).getValue()+" "+chosenCards.get(j).getSuit());
			}

			PokerHand hand = new PokerHand(chosenCards);
			System.out.println(hand.findHandRank());
			chosenCards.clear();
		}

//		for(int i = 0; i < validCombinations.size(); )


//		cards.clear();
//		cards.add(new Card("Diamond","J"));
//		cards.add(new Card("Diamond","10"));
//		cards.add(new Card("Diamond","9"));
//		cards.add(new Card("Diamond","Q"));
//		cards.add(new Card("Diamond","K"));
//		for(int i=0;i<cards.size();i++){
//			System.out.println(cards.get(i).getValue()+" "+cards.get(i).getSuit());
//		}
//		PokerHand hand = new PokerHand(cards);
//		System.out.println(hand.findHandRank());
////		hand.printHashMap();

	}
}
