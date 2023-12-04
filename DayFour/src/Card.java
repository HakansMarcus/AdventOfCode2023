import java.util.ArrayList;
import java.util.List;

public class Card {

    String data;

    List<Integer> numbers;
    List<Integer> winningNumbers;

    public Card(String data) {
        this.data = data;
        numbers = new ArrayList<>();
        winningNumbers = new ArrayList<>();
        takeOutNumbers(data);
    }

    public void takeOutNumbers(String data) {
        String[] splitValues = data.split(":");
        String values = splitValues[1];
        takeOutDealtNumbers(values);
    }


    public void takeOutDealtNumbers(String values) {
        String[] dealtNumbers = values.split("\\|");

        String numberPart = dealtNumbers[0].trim();

        String[] numbersArray = numberPart.split("\\s");

        System.out.println(numbersArray[0]);

//        System.out.println(numberPart);


    }


}




