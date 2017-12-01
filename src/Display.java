import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Logger;

public class Display implements ObservatorGenerator {

    private StringProperty text;

    public Display() {
        this.text = new SimpleStringProperty();
    }

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

    public StringProperty getText() {
        return this.text;
    }
}
