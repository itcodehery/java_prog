package classes;

public class Session {

    String sessionId;
    int day;
    int month;
    int year;
    int hour;
    int minute;

    public Session(
        String id,
        int day,
        int month,
        int year,
        int hour,
        int minute
    ) {
        this.sessionId = id;
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
    }
}
