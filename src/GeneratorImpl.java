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

    public void setAlgo(AlgoDiffusion algo) {
        this.algo = algo;
    }

    public void stop(){
        this.generatorOn = false;
    }

    public void start() {
        this.generatorOn = true;
        this.v = 0;
        this.scheduler.scheduleAtFixedRate(()-> {

        }, 1000,1000, TimeUnit.MILLISECONDS);
    }


}
