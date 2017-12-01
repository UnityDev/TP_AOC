import java.util.concurrent.*;


public class Channel implements GeneratorAsync, ObservatorGeneratorAsync {

    private ObservatorGenerator observatorGenerator;
    private Generator generator;
    private ScheduledExecutorService sch;


    public Channel(GeneratorImpl generator, ScheduledExecutorService sch) {
        this.generator = generator;
        this.sch = sch;
    }

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

    @Override
    public Future<String> getValue(){
        Callable callable = new GetValue(this, this.generator);
        int delaiAleatoire = 900 + (int) Math.random() * 1500;
        return this.sch.schedule(callable,delaiAleatoire,TimeUnit.MILLISECONDS);
    }
}
