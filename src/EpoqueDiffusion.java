import java.util.LinkedList;
import java.util.List;

public class EpoqueDiffusion {
    private List<ObservatorGenerator> channels;
    private GeneratorImpl generator;

    public void configure(GeneratorImpl generator) {
        this.channels = new LinkedList<>();
        this.generator = generator;
    }

    public void execute() {
        this.channels = this.generator.getChannels();
        for (ObservatorGenerator observator : this.channels) {
            observator.update(this.generator);
        }
    }
}
