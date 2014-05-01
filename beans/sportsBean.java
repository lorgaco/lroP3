package beans;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Collections;
import java.util.Collections;
import java.util.Comparator;
import packages.*;

public class sportsBean {
    String language;
    String day;
    List<SportPkg> sports;

    public sportsBean() {}

    public List<SportPkg> getShows() {
        List<SportPkg> sportsAux = sports;
        return Collections.sort(sportsAux, new DurationComparator());
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

class DurationComparator implements Comparator<SportPkg> {
    @Override
    public int compare(SportPkg o1, SportPkg o2) {
        return o1.duration.compareTo(o2.duration);
    }
}