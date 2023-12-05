import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Card {

    List<Card> cards;

    int points;
    int numberOfMatches;
    int id;
    String data;
    List<Integer> numbers;
    List<Integer> winningNumbers;

    public Card(String data) {
        this.numberOfMatches = 0;
        this.data = data;
        initializeLists();
        System.out.println("Insert Line: " + data);
        initializeCard();
    }

    public void initializeLists() {
        cards = new ArrayList<>();
        cards.add(this);
        numbers = new ArrayList<>();
        winningNumbers = new ArrayList<>();
    }


    public void initializeCard() {
        setId(data);
        takeOutNumbers(data);
        setNumberOfMatches();
        setWinningCardsForCardId();
        calculatePoints();
    }

    public void setId(String data) {
        String[] values = data.split(":");
        String value = values[0];
        String id = value.replaceAll("[^0-9]", "");
        this.id = Integer.parseInt(id);
    }

    public void takeOutNumbers(String data) {
        String[] splitValues = data.split(":");
        String values = splitValues[1];

        takeOutDealtNumbers(values);
    }

    public void takeOutDealtNumbers(String values) {
        String[] dealtNumbers = values.split("\\|");

        String numberPart = dealtNumbers[0].trim();
        System.out.println("Dealt number of card: " + numberPart);

        String[] numbersArray = numberPart.split("\\s+");

        String winningNumbers = dealtNumbers[1].trim();
        System.out.println("Winning cards: " + winningNumbers);

        // Ta ut utdelade korten för spelare och lägg till listan
        for (int i = 0; i < numbersArray.length; i++) {
            String sign = numbersArray[i];
            if(!sign.equals(" ")) {
                numbers.add(Integer.parseInt(numbersArray[i]));
            }
        }

        // Ta ut utdelade vinstnumren
        takeOutWinningNumbers(winningNumbers);

    }


    public void takeOutWinningNumbers(String values) {
        String[] winningNumberpart = values.split("\\s+");

        for (int i = 0; i < winningNumberpart.length; i++) {
            String sign = winningNumberpart[i];
            if(!sign.equals(" ")) {
                winningNumbers.add(Integer.parseInt(winningNumberpart[i]));
            }
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void calculatePoints() {
        List<Integer> common =
                numbers.stream()
                        .filter(winningNumbers::contains)
                        .collect(Collectors.toList());

        if(common.size() == 1) {
            points = 1;
        }

        else if (common.size() > 1) {
            points = (int) Math.pow(2, common.size()-1);
        }
    }

    public void setNumberOfMatches () {
        List<Integer> common =
                numbers.stream()
                        .filter(winningNumbers::contains)
                        .collect(Collectors.toList());
        int matches = common.size();
        this.numberOfMatches = matches;
        System.out.println("Number of matches: " + numberOfMatches + "\n");

    }


    public int getPoints() {
        return points;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getId(){
        return id;
    }



    // Card 1:
    // 4 Matches
    // Card 2,3,4,5
    public void setWinningCardsForCardId() {
        System.out.println("Card id: " + id);
        System.out.println("Should win cards: ");

        int start = id+1;
        int end = start + getNumberOfMatches();

        // 2,3,4,5
        for (int i = start; i < end ; i++) {
            System.out.println("Card: " + i);

        }

        System.out.println(cards.get(0).getNumberOfMatches());;







        System.out.println("----------------------------------------");

    }







}




