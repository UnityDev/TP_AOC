import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * EpoqueDiffusion allows the user to execute an epoque diffusion algorithm in order to create a value.
 * (In french, easier) : L'algorithme génère une chaîne de caractère qui comprend la valeur générée + une heure.
 * Grâce à ça on pourra vérifier qu'elle est la valeur générée la plus récente
 *
 * @author Alexis Renault
 * @author Antoine Ravet
 * @version 1.0
 *
 */

public class EpoqueDiffusion {
    private List<ObservatorGenerator> channels;
    private GeneratorImpl generator;

    public void configure(GeneratorImpl generator) {
        this.channels = new LinkedList<>();
        this.generator = generator;
    }

    public void execute() {
        this.channels = this.generator.getChannels();
        // We update the channels
        for (ObservatorGenerator observator : this.channels) {
            observator.update(this.generator);
        }
    }

    public String readValue(ObservatorGenerator channel) {
        String date = " - "+LocalDateTime.now().getHour()+" : " +LocalDateTime.now().getMinute()+" : " +LocalDateTime.now().getSecond();
        return this.generator.getValue()+date;
    }
}