

public class Channel implements Generator, ObservatorGenerator{

    private ObservatorGenerator observatorGenerator;
    private Generator generator;

    public void update(GeneratorImpl s){
        observatorGenerator.update(s);
    }

    @Override
    public void attach(ObservatorGenerator o) {
        this.observatorGenerator = o;
    }

    @Override
    public void detach(ObservatorGenerator o) {
        this.observatorGenerator = null;
    }

    public Integer getValue() {
        return this.generator.getValue();
    }

}
