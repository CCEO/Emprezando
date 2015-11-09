package mx.com.cceo.emprezando.Model;

/**
 * Created by Hugo on 10/9/2015.
 */
public class DescriptionItem {

    private String title;
    private String speaker;
    private String about;
    private int pic;

    public DescriptionItem(String title, String speaker, String about, int pic) {
        this.title = title;
        this.speaker = speaker;
        this.about = about;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

}
