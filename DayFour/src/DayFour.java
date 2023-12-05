import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayFour {
    public static void main(String[] args) {
        int globalscore = 0;

        try {
            File myObj = new File("C:\\Users\\marcu\\AdventOfCode2023\\DayFour\\src\\sample.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Card card = new Card(data);
                globalscore += card.getPoints();
            }

            myReader.close();
            System.out.println("GlobalScore: " + globalscore);


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}