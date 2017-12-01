import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField display1;

    @FXML
    private TextField display2;

    @FXML
    private TextField display3;

    @FXML
    private TextField display4;

    @FXML
    private Button startButton;

    @FXML
    private Button stopButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // On instancie le générateur
        GeneratorImpl generator = new GeneratorImpl();

        // On instancie les canaux
        Channel channel1 = new Channel(generator);
        Channel channel2 = new Channel(generator);
        Channel channel3 = new Channel(generator);
        Channel channel4 = new Channel(generator);

        // On instancie les quatres afficheurs
        Display display1 = new Display();
        Display display2 = new Display();
        Display display3 = new Display();
        Display display4 = new Display();

        }
    }
