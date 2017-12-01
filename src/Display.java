import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Display implements ObservatorGenerator{

    private StringProperty text;

    public Display(){
        this.text = new SimpleStringProperty();
    }

    @Override
    public void update(GeneratorImpl canalGenerateur){
        //Todo Ajouter la synchro ici ( outil future vu en TD )
    }

    public StringProperty getText(){
        return this.text;
    }
}
