package beans;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Collections;
import java.util.Comparator;
import packages.*;

public class showsBean {
    String language;
    String day;
    String channel;
    List<ShowPkg> shows;

    public showsBean() {}

    public List<ShowPkg> getShows() {
        return (shows);
    }
    public String getDay() {
        return day;
    }
    public String getChannel() {
        return channel;
    }
    public String getLanguage() {
        return (language);
    }
    public void setShows(List<ShowPkg> s) {
        shows = s;
        Collections.sort(shows, new DurationComparator());
    }
    public void setDay(String d) {
        day = d;
    }
    public void setChannel(String c) {
        channel = c;
    }
    public void setLanguage(String l) {
        language = l;
    }
}

class DurationComparator implements Comparator<ShowPkg> {
    @Override
    public int compare(ShowPkg o1, ShowPkg o2) {
        return o1.duration.compareTo(o2.duration);
    }
}