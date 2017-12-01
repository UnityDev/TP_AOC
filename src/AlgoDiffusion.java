public interface AlgoDiffusion {

    /**
     * AlgoDiffusion is an interface and it is the strategy class in the Strategy design pattern.
     * This interface is used to create several algorithms
     *
     * @author Renault Alexis
     * @author Ravet Antoine
     * @version 1.0
     *
     */

    /**
     * Configure the algorithm
     * @param generator
     */
    void configure(GeneratorImpl generator);

    /**
     * Execute the algorithm
     */
    void execute();

    /**
     * Can restart the generator. Sendback the generator value.
     * @param channel, which needs the generator value
     * @return the value
     */
    String readValue(ObservatorGeneratorAsync channel);
}
