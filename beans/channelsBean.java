package beans;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class daysBean {
    String day;
    List<String> channels;

    public daysBean() {}

    public List<String> getChannels() {
        return (channels);
    }
    public String getDay() {
        return day
    }
    public void setChannels(List<String> c) {
        daysChannels=c;
    }
    public void setDay(String d){
        day = d;
    }
}