package mx.com.cceo.emprezando.Model;

/**
 * Created by Hugo on 11/21/2015.
 */
public class ActivityItem {
    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public ActivityItem(String activity) {
        this.activity = activity;
    }

    private String activity;
}
