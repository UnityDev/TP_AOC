import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * GenerateurImpl is an observable who creates a value.
 *
 * @author Alexis Renault
 * @author Antoine Ravet
 * @version 1.0
 */

public class GeneratorImpl implements Generator {

    /**
     * generate value
     */
    private Integer v;

    /**
     * Channels that observe the generator
     */
    private List<ObservatorGeneratorAsync> channels = new ArrayList<>();

    /**
     * Algorithm picked to create the value
     */
    private AlgoDiffusion algo;

    /**
     * boolean, true if the generator is on
     */
    private boolean generatorOn;

    /**
     * generator's scheduler
     */
    private ScheduledExecutorService scheduler;


    /**
     * Class' constructor
     *
     * @param scheduler
     */
    public GeneratorImpl(ScheduledExecutorService scheduler) {
        this.scheduler = scheduler;
    }

    public void attach(ObservatorGeneratorAsync o) {
        this.channels.add(o);
    }

    public void detach(ObservatorGeneratorAsync o) {
        this.channels.remove(o);
    }

    /**
     * @param oAsync
     * @return generator's value
     */
    public String getValue(ObservatorGeneratorAsync oAsync) {
        return algo.readValue(oAsync);
    }

    /**
     * @return generator's value
     */
    public String getValue() {
        return Integer.toString(v);
    }

    /**
     * Increments the generator's value
     */
    public void setValue() {
        // Si le générateur est en fonctionnement
        if (generatorOn) {
            v++;
            algo.execute();
        }
    }

    /**
     * Return a copy of the applications' channels
     * @return LinkedList de ObservateurGenerateurAsync
     */
    public List<ObservatorGeneratorAsync> getChannels() {
        LinkedList<ObservatorGeneratorAsync> channelsCopy = new LinkedList<>(this.channels);
        return channelsCopy;
    }

    /**
     * Set the algorithm that the user picked
     * @param algo
     */
    // Algorithm choice
    public void setAlgo(AlgoDiffusion algo) {
        this.algo = algo;
    }

    /**
     * Restart the generator
     */
    // Restart the generator
    public void restart() {
        this.generatorOn = true;
    }

    /**
     * Stop the generator
     */
    // Stop the generator
    public void stop() {
        this.generatorOn = false;
    }

    /**
     * Start the generator and initiate the value with a scheduler
     */
    // Start the generator
    public void start() {
        this.generatorOn = true;
        // Configure function creates the variables
        algo.configure(this);
        v = 0;
        // New value each 2 seconds
        this.scheduler.scheduleAtFixedRate(() -> {
            this.setValue();
        }, 2000, 2000, TimeUnit.MILLISECONDS);
    }


}
