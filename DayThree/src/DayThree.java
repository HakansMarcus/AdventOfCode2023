import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayThree {

    public static void main(String[] args) {

        try {
            File myObj = new File("C:\\Users\\Marcus\\IdeaProjects\\AdventOfCode2023\\DayThree\\src\\daythree.txt");
            Scanner myReader = new Scanner(myObj);

           LinkedChar linkedChar = new LinkedChar();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //System.out.println(data);
                linkedChar.appendToSchematic(data);
            }

            linkedChar.linkCharArrays();
            System.out.println(linkedChar.toString());

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}