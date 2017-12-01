import java.util.concurrent.Future;

public interface GeneratorAsync {
    Future<String> getValue();
}
