package beans;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class daysBean {
    List<String> days;

    public daysBean() {}

    public List<String> getDays() {
        return (days);
    }
    public void setDays(List<String> d) {
        days=d;
    }
}