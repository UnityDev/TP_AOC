

public class Channel implements Generator, ObservatorGenerator{

    private ObservatorGenerator observatorGenerator;
    private GeneratorImpl generator;

    public Channel(GeneratorImpl generator ){
        this.generator = generator;
    }

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

    public String getValue() {
        return this.generator.getValue();
    }

}
