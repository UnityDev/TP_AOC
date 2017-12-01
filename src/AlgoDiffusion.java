public interface AlgoDiffusion {

    void configure(GeneratorImpl generator);

    void execute();

    String readValue(ObservatorGeneratorAsync channel);
}
