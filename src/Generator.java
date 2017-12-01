
/**
 * Generator is an interface and it is the component in the Proxy design pattern.
 *
 * @author Renault Alexis
 * @author Ravet Antoine
 * @version 1.0
 *
 */

public interface Generator extends Subject {
    /**
     * Return the generator's value
     * @return value
     */
    String getValue(ObservatorGeneratorAsync o);
}