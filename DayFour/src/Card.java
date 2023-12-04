import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Card {

    int points;
    String data;
    List<Integer> numbers;
    List<Integer> winningNumbers;

    public Card(String data) {
        this.data = data;
        System.out.println("inserted line: " + data);
        numbers = new ArrayList<>();
        winningNumbers = new ArrayList<>();
        takeOutNumbers(data);
        calculatePoints();
    }

    //Card   1: 91 73 74 57 24 99 31 70 60  8 | 89 70 43 24 62 30 91 87 60 57 90  2 27  3 31 25 39 83 64 73 99  8 74 37 49

    //  91 73 74 57 24 99 31 70 60  8 | 89 70 43 24 62 30 91 87 60 57 90  2 27  3 31 25 39 83 64 73 99  8 74 37 49
    public void takeOutNumbers(String data) {
        String[] splitValues = data.split(":");
        String values = splitValues[1];

        takeOutDealtNumbers(values);
    }

    //  91 73 74 57 24 99 31 70 60  8
    public void takeOutDealtNumbers(String values) {
        String[] dealtNumbers = values.split("\\|");
        String numberPart = dealtNumbers[0].trim();
        String[] numbersArray = numberPart.split("\\s+");

        String winningNumbers = dealtNumbers[1].trim();

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

        System.out.println(winningNumbers.toString());
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

/*
    Card   1:

          Dealt hand      91 73 74 57 24 99 31 70 60  8

          Winning cards   89 70 43 24 62 30 91 87 60 57 90  2 27  3 31 25 39 83 64 73 99  8 74 37 49



                        // 8
          Points: 91, 73, 74, 99, 31, 70, 60, 8  = 128





 */

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

        System.out.println("Common numbers: " + common.toString());
        System.out.println("Points: " + points);
    }


    public int getPoints() {
        return points;
    }




}




