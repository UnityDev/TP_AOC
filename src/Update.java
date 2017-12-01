import java.util.concurrent.Callable;

public class Update implements Callable{

    private ObservatorGenerator observatorGenerator;

    private GeneratorAsync g;

    public Update(ObservatorGenerator observatorGenerator, GeneratorAsync g){
        this.observatorGenerator = observatorGenerator;
        this.g = g;

    }

    public Void call(){
        this.observatorGenerator.update(this.g);
        return null;
    }
}
