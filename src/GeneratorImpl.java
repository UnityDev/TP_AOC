import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * GenerateurImpl is an observable who creates a value.
 *
 *
 * @author Alexis Renault
 * @author Antoine Ravet
 * @version 1.0
 *
 */

public class GeneratorImpl{

    /**
     * generate value
     */
    private Integer v;

    /**
     * Channels that observe the generator
     */
    private List<ObservatorGenerator> channels = new ArrayList<>();

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
    public GeneratorImpl(ScheduledExecutorService scheduler){
        this.scheduler = scheduler;
    }

    public void attach(ObservatorGenerator o){
        this.channels.add(o);
    }

    public void detach(ObservatorGenerator o){
        this.channels.remove(o);
    }

    public String getValue(ObservatorGenerator channel) {
        return algo.readValue(channel);
    }

    public String getValue(){
        return Integer.toString(v);
    }

    public void setValue(){
        // Si le générateur est en fonctionnement
        if(generatorOn){
            v++;
        }
    }

    public List<ObservatorGenerator> getChannels(){
        LinkedList<ObservatorGenerator> channelsCopy = new LinkedList<>(this.channels);
        return channelsCopy;
    }

    // Algorithm choice
    public void setAlgo(AlgoDiffusion algo) {
        this.algo = algo;
    }

    // Stop the generator
    public void stop(){
        this.generatorOn = false;
    }

    // Start the generator
    public void start() {
        this.generatorOn = true;
        // Configure function creates the variables
        algo.configure(this);
        v = 0;
        // New value each 2 seconds
        this.scheduler.scheduleAtFixedRate(()-> {
            this.setValue();
        }, 2000,2000, TimeUnit.MILLISECONDS);
    }


}
