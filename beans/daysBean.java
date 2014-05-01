package beans;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Collections;

public class daysBean {
    String language;
    List<String> days;

    public daysBean() {}

    public List<String> getDays() {
        Collections.sort(days);
        return days;
    }
    public String getLanguage() {
        return (language);
    }
    public void setDays(List<String> d) {
        days = d;
    }
    public void setLanguage(String l) {
        language = l;
    }
}