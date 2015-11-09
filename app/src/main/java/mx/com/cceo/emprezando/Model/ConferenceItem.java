package mx.com.cceo.emprezando.Model;

/**
 * Created by Hugo on 10/2/2015.
 */
public class ConferenceItem {


    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
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


    public ConferenceItem(String title, String speaker, String time, int prfile) {

        this.title = title;
        this.speaker = speaker;
        this.time = time;
        this.pic = prfile;
    }


    private String title;
    private String speaker;
    private String time;
    private int pic;
}
