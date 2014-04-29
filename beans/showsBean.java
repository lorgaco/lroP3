package beans;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import packages.*;

public class showsBean {
    String language;
    String day;
    String channel;
    List<ShowPkg> shows;

    public showsBean() {}

    public List<ShowPkg> getShows() {
        return (films);
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
        films = s;
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