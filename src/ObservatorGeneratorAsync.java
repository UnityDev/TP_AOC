import java.util.concurrent.Future;

public interface ObservatorGeneratorAsync {
    Future<Void> update(Generator g);
}
