import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceParser {

    String line;
    List<Integer> raceDuration;
    List<Integer> recordTimes;


    public RaceParser(String line) {
        this.line = line;
        raceDuration = new ArrayList<>();
        recordTimes = new ArrayList<>();
        parseRace(line);
    }

    public void parseRace(String line) {

        if(line.contains("Time:")) {
            String[] data = line.split("Time:");
            String time = data[1].trim();
            String[] timeValues = time.split("\\s+");

            for (int i = 0; i < timeValues.length; i++) {
                raceDuration.add(Integer.parseInt(timeValues[i]));
            }
        }

        if(line.contains("Distance:")) {
            String[] recordData = line.split("Distance:");
            String records = recordData[1].trim();
            String[] recordValues = records.split("\\s+");

            for (int i = 0; i < recordValues.length; i++) {
                recordTimes.add(Integer.parseInt(recordValues[i]));
            }
        }
    }

    public List<Integer> getRaceDuration() {
        return raceDuration;
    }

    public List<Integer> getRecordTimes() {
        return recordTimes;
    }

    public int getFirstRaceDuration() {
        return recordTimes.get(0);
    }

    public int getFirstRaceRecordTime() {
        return recordTimes.get(0);
    }
}