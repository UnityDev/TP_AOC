import java.util.concurrent.*;

/**
 * Channel is an interface and it is the proxy in the Proxy design pattern.
 *
 * @author Renault Alexis
 * @author Ravet Antoine
 * @version 1.0
 *
 */

public class Channel implements GeneratorAsync, ObservatorGeneratorAsync {

    /**
     * Display that observs the channel.
     */
    private ObservatorGenerator observatorGenerator;

    /**
     * Generator observed by the canal.
     */
    private Generator generator;

    /**
     * Channel's scheduler
     */
    private ScheduledExecutorService sch;

    /**
     * Constructeur Canal
     * @param generator
     * @param sch
     */
    public Channel(GeneratorImpl generator, ScheduledExecutorService sch) {
        this.generator = generator;
        this.sch = sch;
    }

    /**
     * @return a void Future
     */
    @Override
    public Future<Void> update(Generator generateur){

        Callable callable = new Update(observatorGenerator, this);
        long rdm = (long)Math.random() * 1000;
        return this.sch.schedule(callable, rdm , TimeUnit.MILLISECONDS);
    }

    public void attach(ObservatorGenerator o) {
        this.observatorGenerator = o;
    }

    public void detach(ObservatorGenerator o) {
        this.observatorGenerator = null;
    }

    /**
     * @return generator's value
     */
    @Override
    public Future<String> getValue(){
        Callable callable = new GetValue(this, this.generator);
        int delaiAleatoire = 900 + (int) Math.random() * 1500;
        return this.sch.schedule(callable,delaiAleatoire,TimeUnit.MILLISECONDS);
    }
}
