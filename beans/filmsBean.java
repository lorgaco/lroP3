package beans;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import packages.*;

public class filmsBean {
    String day;
    String channel;
    List<FilmPkg> films;

    public filmsBean() {}

    public List<FilmPkg> getFilms() {
        return (films);
    }
    public String getDay() {
        return day;
    }
    public String getChannel() {
        return channel;
    }
    public void setFilms(List<FilmPkg> f) {
        films = f;
    }
    public void setDay(String d) {
        day = d;
    }
    public void setChannel(String c) {
        channel = c;
    }
}