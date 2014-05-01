package beans;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class daysBean {
    String language;
    List<String> days;

    public daysBean() {}

    public List<String> getDays() {
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