package beans;
import java.util.ArrayList;
import java.util.List;

public class errorBean {
    List<String> Error;

    public errorBean() {}

    public List<String> getError() {
        return (Error);
    }
    public void setError(List<String> l) {
        Error=l;
    }
}