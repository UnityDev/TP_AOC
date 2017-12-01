
/**
 * ObservatorGenerator is a part of the Observer design pattern.
 *
 * @author Renault Alexis
 * @author Ravet Antoine
 * @version 1.0
 *
 */

public interface ObservatorGenerator {
    /**
     * Allows to notify the subject
     * @param subject
     */
    void update(GeneratorAsync subject);
}
