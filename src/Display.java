import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Display implements ObservatorGenerator{

    private StringProperty text;

    public Display(){
        this.text = new SimpleStringProperty();
    }

    @Override
    public void update(GeneratorImpl canalGenerateur){
        canalGenerateur.getValue();
    }

    public StringProperty getText(){
        return this.text;
    }
}
