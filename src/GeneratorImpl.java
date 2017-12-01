import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GeneratorImpl{

    private Integer v;
    private List<ObservatorGenerator> channels = new ArrayList<>();
    private AlgoDiffusion algo;

    public void attach(ObservatorGenerator o){
        this.channels.add(o);
    }

    public void detach(ObservatorGenerator o){
        this.channels.remove(o);
    }

    public Integer getValue(){
        return v;
    }

    public List<ObservatorGenerator> getChannels(){
        LinkedList<ObservatorGenerator> channelsCopy = new LinkedList<>(this.channels);
        return channelsCopy;
    }

    public void setAlgo(AlgoDiffusion algo) {
        this.algo = algo;
    }




}
