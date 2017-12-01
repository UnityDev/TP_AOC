public interface AlgoDiffusion {

    void configure(GeneratorImpl generator);

    void execute();

    String readValue(ObservatorGenerator channel);
}
