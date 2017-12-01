import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public interface Generator {
    void attach(ObservatorGenerator o);
    void detach(ObservatorGenerator o);
    String getValue();
}
