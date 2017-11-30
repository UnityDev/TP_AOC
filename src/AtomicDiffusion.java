import java.util.LinkedList;
import java.util.List;

public class AtomicDiffusion {

    private Channel channel;
    private Generator generator;

    public void configure() {
        this.channel = new Channel();
    }

    public void execute() {
        this.channel.update(this.generator);
    }
}
