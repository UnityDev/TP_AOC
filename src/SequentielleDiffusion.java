public class SequentielleDiffusion {
    private Generator generator;
    private Channel channel;

    public void configure(Generator generator) {
        this.generator = generator;
        this.channel = new Channel();
    }

    public void execute() {
        channel.update(generator);
    }
}
