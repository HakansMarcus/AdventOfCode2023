public class Race {

    final int DURATION;
    final int RECORD_TIME;

    public Race(int duration, int recordTime) {
        this.DURATION = duration;
        this.RECORD_TIME = recordTime;

    }

    public int getDuration() {
        return DURATION;
    }

    public int getRecordTime() {
        return RECORD_TIME;
    }
}
