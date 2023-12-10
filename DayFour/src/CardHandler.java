import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardHandler {


    // Alla kort med data
    static List<Card> cardList;

    public CardHandler(List<Card> cards) {
        cardList = cards;
//        List<Card> allcopies = getAllcopies();
        printAllCopies();
    }


    // Get copies for a card.
    public List<Card> getAllcopies() {
        List<Card> copies = new ArrayList<>();



        for (int i = 0; i < cardList.size(); i++) {
            copies.addAll(getCopies(findById(i + 1)));
        }

        System.out.println(copies.toString());

        return copies;

    }

    public static List<Card> getCopies(Card card) {
        List<Card> copiesForCard = new ArrayList<>();

            System.out.println("Card id: " + card.getId());
            System.out.println("Matches: " + card.getNumberOfMatches());
            System.out.println("Should win copies of: ");


            int start = card.getId() + 1;
            int end = start + card.getNumberOfMatches();
            copiesForCard.add(findById(card.getId()));

            //2,3,4,5

            for (int i = start; i < end; i++) {
                System.out.println("Cards: " + i);
                copiesForCard.add(findById(i));
            }

        return copiesForCard;
    }

    public static Card findById(int id) {
        for (Card card : cardList) {
            if (card.getId() == id) {
                return card;
            }
        }
        return null; // Card with the specified ID not found
    }

    private void printAllCopies() {
        List<Card> allcopies = getAllcopies();
        allcopies.forEach(copy -> {
            System.out.println(copy.getId());
        });
    }








}