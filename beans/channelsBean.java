package beans;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class channelsBean {
    String language;
    String day;
    List<String> channels;

    public channelsBean() {}

    public List<String> getChannels() {
        return (channels);
    }
    public String getDay() {
        return day;
    }
    public String getLanguage() {
        return (language);
    }
    public void setChannels(List<String> c) {
        channels=c;
    }
    public void setDay(String d){
        day = d;
    }
    public void setLanguage(String l) {
        language = l;
    }
}