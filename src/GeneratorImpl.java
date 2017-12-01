import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GeneratorImpl{

    private Integer v;
    private List<ObservatorGenerator> channels = new ArrayList<>();
    private AlgoDiffusion algo;
    private boolean generatorOn;
    private ScheduledExecutorService scheduler;

    public void attach(ObservatorGenerator o){
        this.channels.add(o);
    }

    public void detach(ObservatorGenerator o){
        this.channels.remove(o);
    }

    public Integer getValue(){
        return v;
    }

    public void setValue(){
        // Si le générateur est en fonctionnement
        if(generatorOn){
            this.v++;
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
        this.v = 0;
        // New value each 2 seconds
        this.scheduler.scheduleAtFixedRate(()-> {
            this.setValue();
        }, 2000,2000, TimeUnit.MILLISECONDS);
    }


}
