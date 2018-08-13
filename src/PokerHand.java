import java.util.*;

public class PokerHand {
    public Card[] hand = new Card[5];
    public final int MAX_CARD = 5;
    public HashMap<String, Integer> cardsMap;

    PokerHand(List<Card> cards){
        for(int i=0;i<cards.size();i++)
            hand[i]=cards.get(i);
        cardsMap = new HashMap<>();
        init();
    }

    public void printHashMap(){
        System.out.println(cardsMap);
    }

    public String findHandRank(){
        boolean isStraight = isStraight();
        boolean isFlush = isFlush();

        if(isStraight&&isFlush && highestCard().value=="A")
            return "ROYAL FLUSH";
        if(isStraight&&isFlush)
            return "STRAIGHT FLUSH";
        else if(isFourOfAKind())
            return "FOUR OF A KIND";
        else if(isFullHouse())
            return "FULL HOUSE";
        else if(isFlush)
            return "FLUSH";
        else if(isStraight)
            return "STRAIGHT";
        else if(isThreeOfAKind())
            return "THREE OF A KIND";
        else if(isTwoPair())
            return "TWO PAIR";

        else if(isOnePair())
            return "ONE PAIR";
        else
            return "HIGH";

    }

    private boolean isTwoPair(){
        for (Map.Entry<String, Integer> entry : cardsMap.entrySet()) {
            if(entry.getValue()==2 && cardsMap.size()==3)
                return true;
        }
        return false;
    }

    private boolean isFourOfAKind(){
        for (Map.Entry<String, Integer> entry : cardsMap.entrySet()) {
            if(entry.getValue()==4)
                return true;
        }
        return false;
    }

    private boolean isOnePair(){
        for (Map.Entry<String, Integer> entry : cardsMap.entrySet()) {
            if(entry.getValue()==2&& cardsMap.size()==4)
                return true;
        }
        return false;
    }

    private boolean isThreeOfAKind(){
        for (Map.Entry<String, Integer> entry : cardsMap.entrySet()) {
            if(entry.getValue()==3 && cardsMap.size()==3)
                return true;
        }
        return false;
    }

    private boolean isFullHouse(){
        for (Map.Entry<String, Integer> entry : cardsMap.entrySet()) {
            if(entry.getValue()==3 && cardsMap.size()==2)
                return true;
        }
        return false;
    }

    public static HashMap<String, Integer> sortMapValue(HashMap<String, Integer> map){
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        HashMap<String, Integer> sortedMap = new HashMap<>();

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for(Map.Entry<String, Integer> entry : list){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public static HashMap<String, Integer> sortMapKey(HashMap<String, Integer> map){
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        HashMap<String, Integer> sortedMap = new HashMap<>();

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        for(Map.Entry<String, Integer> entry : list){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    private void init() {
        System.out.println(hand[2].value);
        for(int i=0;i<5;i++){
            if(cardsMap.containsKey(hand[i].value))
                cardsMap.put(hand[i].value, cardsMap.get(hand[i].value)+1);
            else
                cardsMap.put(hand[i].value, 1);
        }
        sortHand();
        cardsMap = sortMapValue(cardsMap);
    }

    public boolean isFlush(){
        for(int i=1;i<MAX_CARD;i++){
            if(hand[0].suit != hand[i].suit)
                return false;
        }
        return true;
    }

    public boolean isStraight(){
        for(int i=1;i<MAX_CARD;i++){
            if(i==MAX_CARD-1 && hand[i].rank==14 && hand[i-1].rank==5)
                return true;
            if(hand[i-1].rank+1!=hand[i].rank)
                return false;
        }
        return true;
    }

    public Card highestCard(){
        return hand[MAX_CARD-1];
    }

    public void sortHand(){
        Arrays.sort(hand);
    }

}
