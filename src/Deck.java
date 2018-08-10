import java.util.*;
public class Deck {
    String [ ] suite = {"Diamond", "Heart", "Spade", "Clubs" };
    int [ ] rank = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    String [ ] value= {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    ArrayList<Card> cardList=new ArrayList<Card>();
    
    int deckCount;
    
    
    Deck()
    {
    for(int i=0;i<suite.length;i++)
    {
    	for(int j=0;j<value.length;j++)
    	{
    		cardList.add(new Card(suite[i], value[j]));
    	}
    }
    }
    public List<Card> getDeck(List<Card> inHand){
    	
    	if(inHand!=null && !inHand.isEmpty()){
	    	for(Card c:inHand)
	    	{   
	    		cardList.remove(c);
	    		
	    	}
    	}
    	return cardList;
    	
    }
    
    public List<Card> getNCards(int n)
    {
    	
    	Random random = new Random();
    	List<Card> nCards=new ArrayList<Card>();
    	HashSet<Integer> alreadyUsed=new HashSet<>();
    	for(int i=0;i<n;i++){
    	int randomIndex=random.nextInt(cardList.size());
    	while(alreadyUsed.contains(randomIndex))
    	{
    		randomIndex=random.nextInt(cardList.size());
    	}
    	alreadyUsed.add(randomIndex);
    	nCards.add(cardList.get(randomIndex));
    	cardList.remove(randomIndex);
    	}
    	return nCards;
    	
    }
    public boolean isSameSuite(Card a,Card b)
    {
    	return false;
    	
    }
    
    public int diff(Card a,Card b)
    {
    	return a.getRank()-b.getRank();
    }
}
