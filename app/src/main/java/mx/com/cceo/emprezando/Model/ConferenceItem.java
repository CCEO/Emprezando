package mx.com.cceo.emprezando.Model;

/**
 * Created by Hugo on 10/2/2015.
 */
public class ConferenceItem {

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public ConferenceItem(String day, String month, String title, String speaker, String time) {
        this.day = day;
        this.month = month;
        this.title = title;
        this.speaker = speaker;
        this.time = time;
    }

    private String day;
    private String month;
    private String title;
    private String speaker;
    private String time;
}
