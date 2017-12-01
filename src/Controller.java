import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

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

    @FXML
    private ToggleGroup algo;

    @FXML
    private RadioButton epBtn;

    @FXML
    private RadioButton atoBtn;

    @FXML
    private RadioButton seqBtn;

    //Method to enable all buttons
    private void enableAllButtons() {
        this.atoBtn.setDisable(false);
        this.epBtn.setDisable(false);
        this.seqBtn.setDisable(false);
    }

    //Method to disable all buttons
    private void disableAllButtons(){
        this.atoBtn.setDisable(true);
        this.epBtn.setDisable(true);
        this.seqBtn.setDisable(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ScheduledExecutorService sch = Executors.newScheduledThreadPool(10);

        // Instanciate the generator
        GeneratorImpl generator = new GeneratorImpl(sch);

        // Instanciate channels
        Channel channel1 = new Channel(generator, sch);
        Channel channel2 = new Channel(generator, sch);
        Channel channel3 = new Channel(generator, sch);
        Channel channel4 = new Channel(generator, sch);

        // Instanciate displays
        Display display1 = new Display();
        Display display2 = new Display();
        Display display3 = new Display();
        Display display4 = new Display();

        // Bind the value of the display from the class.
        this.display1.textProperty().bind(display1.getText());
        this.display2.textProperty().bind(display2.getText());
        this.display3.textProperty().bind(display3.getText());
        this.display4.textProperty().bind(display4.getText());

        //Attach display to channel
        channel1.attach(display1);
        channel2.attach(display2);
        channel3.attach(display3);
        channel4.attach(display4);

        //Attach channel to generator
        generator.attach(channel1);
        generator.attach(channel2);
        generator.attach(channel3);
        generator.attach(channel4);


        //Event on the start button
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {

                // Disabled radio button
                disableAllButtons();

                RadioButton selectedRadioButton = (RadioButton) algo.getSelectedToggle();
                String algoId = selectedRadioButton.getId();

                AlgoDiffusion algo = new AtomicDiffusion();

                switch (algoId){
                    case "atoBtn" :
                        algo = new AtomicDiffusion();
                        break;
                    case "seqBtn" :
                        algo = new SequentielleDiffusion();
                        break;
                    case "epBtn" :
                        algo = new EpoqueDiffusion();
                        break;
                }

                generator.setAlgo(algo);
                generator.start();
            }
        });


        // Even on the stop button
        stopButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                generator.stop();
                enableAllButtons();
            }
        });


    }


}
