import java.util.concurrent.Future;


/**
 * ObservatorGeneratorAsync is a part of the Observer design pattern
 *
 * @author Renault Alexis
 * @author Ravet Antoine
 * @version 1.0
 *
 */

public interface ObservatorGeneratorAsync {
    /**
     * Allows to notify the subject in a asynchronious way
     * @return a Future object
     */
    Future<Void> update(Generator g);
}
