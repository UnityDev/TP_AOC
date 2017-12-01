import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage app) throws Exception{
        Parent xml = FXMLLoader.load(getClass().getResource("app.fxml"));
        app.setScene(new Scene(xml, 800, 600));
        app.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
