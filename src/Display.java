import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;

/**
 * Display allows you to see the values
 *
 * @author Renault Alexis
 * @author Ravet Antoine
 * @version 1.0
 *
 */

public class Display implements ObservatorGenerator {

    /**
     * Value read by the Display
     */
    private StringProperty text;

    /**
     * Constructeur Display
     */
    public Display() {
        this.text = new SimpleStringProperty();
    }

    /**
     * @param gen
     */
    @Override
    public void update(GeneratorAsync gen) {
        Future<String> future = gen.getValue();
        try {
            this.text.set(future.get());
            Logger.getGlobal().info("Afficheur " + text);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return a StringProperty value
     */
    public StringProperty getText() {
        return this.text;
    }
}
