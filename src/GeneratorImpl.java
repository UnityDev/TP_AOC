import java.util.ArrayList;
import java.util.List;

public class GeneratorImpl {

    private Integer v;
    private List<ObservatorGenerator> observers = new ArrayList<>();

    public void attach(ObservatorGenerator o){
        this.observers.add(o);
    }

    public void detach(ObservatorGenerator o){
        this.observers.remove(o);
    }

    public Integer getValue(){
        return v;
    }

}
