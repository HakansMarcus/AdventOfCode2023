import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayFive {

    static List<Integer> raceDuration = new ArrayList<>();
    static List<Integer> recordTimes = new ArrayList<>();


    public static void main(String[] args) {
        try {
            File myObj = new File("C:\\Users\\Marcus\\IdeaProjects" +
                    "\\AdventOfCode2023\\Day5\\src\\dayfive.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                RaceParser raceParser = new RaceParser(data);
                raceDuration.addAll(raceParser.getRaceDuration());
                recordTimes.addAll(raceParser.getRecordTimes());
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Race race1 = new Race(raceDuration.get(0), recordTimes.get(0));
        Race race2 = new Race(raceDuration.get(1), recordTimes.get(1));
        Race race3 = new Race(raceDuration.get(2), recordTimes.get(2));
        Race race4 = new Race(raceDuration.get(3), recordTimes.get(3));



        Boat boat1 = new Boat(race1);
        Boat boat2 = new Boat(race2);
        Boat boat3 = new Boat(race3);
        Boat boat4 = new Boat(race4);


        boat1.holdButton();
        boat2.holdButton();
        boat3.holdButton();
        boat4.holdButton();

        int totalWays = boat1.getPossibleWays() * boat2.getPossibleWays() * boat3.getPossibleWays() * boat4.getPossibleWays();
        System.out.println("TotalWays: " + totalWays);



    }
}