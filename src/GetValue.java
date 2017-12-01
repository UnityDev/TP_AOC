import java.util.concurrent.Callable;

public class GetValue implements Callable {

    private Generator generator;
    private ObservatorGeneratorAsync o;

    public GetValue(ObservatorGeneratorAsync o, Generator generator){
        this.o = o;
        this.generator = generator;
    }

    public String call() {
        String value = this.generator.getValue(this.o);
        return value;
    }
}