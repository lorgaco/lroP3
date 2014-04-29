package beans;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class languagesBean {
    List<String> languages;

    public languagesBean() {}

    public List<String> getLanguages() {
        return (languages);
    }
    public void setLanguages(List<String> l) {
        languages=l;
    }
}