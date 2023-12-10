import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayFour {
    public static void main(String[] args) {

        List<Integer> children = new ArrayList<>();
        List<Integer> total = new ArrayList<>();

        List<Card> cards = new ArrayList<>();

        try {
            File myObj = new File("C:\\Users\\Marcus\\IdeaProjects" +
                    "\\AdventOfCode2023\\DayFour\\src\\sample.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Card card = new Card(data);
                cards.add(card);

                //children.addAll(card.getChildren());
                //System.out.println("Card ID: " + card.getId() + ", Children: " + card.getChildren());

            }

            myReader.close();
            CardHandler cardHandler = new CardHandler(cards);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}