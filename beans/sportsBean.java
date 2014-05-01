package beans;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Collections;
import packages.*;

public class sportsBean {
    String language;
    String day;
    List<SportPkg> sports;

    public sportsBean() {}

    public List<SportPkg> getShows() {
        return Collections.sort(sports, new SportsComparator());
    }
    public String getDay() {
        return day;
    }
    public String getLanguage() {
        return (language);
    }
    public void setShows(List<SportPkg> s) {
        sports = s;
    }
    public void setDay(String d) {
        day = d;
    }
    public void setLanguage(String l) {
        language = l;
    }
}

class SportsComparator implements Comparator<SportPkg> {
    @Override
    public int compare(SportPkg o1, SportPkg o2) {
        return o1.duration.compareTo(o2.duration);
    }
}