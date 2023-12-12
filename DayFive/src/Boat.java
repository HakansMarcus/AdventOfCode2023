public class Boat {
    private int button;
    private int speed;
    private Race race;

    private int possibleWays;

    public Boat(Race race) {
        this.race = race;
    }

    public void holdButton() {
        int speed = 1;
        possibleWays = 0;


        while(speed < race.getDuration()) {
            int timeLeft = race.getDuration() - speed;
            int lenght = speed * timeLeft;

            if(lenght > race.getRecordTime()) {
                possibleWays+=1;

            }
            speed+=1;

        }

        System.out.println(possibleWays);


    }

    public int getPossibleWays() {
        return possibleWays;
    }





}