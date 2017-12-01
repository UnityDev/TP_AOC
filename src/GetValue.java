import java.util.concurrent.Callable;


/**
 * GetValue is an asynchrone task. It gets the generator's value.
 *
 * @author Renault Alexis
 * @author Ravet Antoine
 * @version 1.0
 *
 */

public class GetValue implements Callable {

    /**
     * The targeted generator
     */
    private Generator generator;

    /**
     * Channel
     */
    private ObservatorGeneratorAsync o;

    /**
     * Constructor GetValue
     * @param o
     * @param generator
     */
    public GetValue(ObservatorGeneratorAsync o, Generator generator){
        this.o = o;
        this.generator = generator;
    }

    /**
     * @return the generator's value
     */
    public String call() {
        String value = this.generator.getValue(this.o);
        return value;
    }
}