import java.util.LinkedList;
import java.util.List;

/**
 * AtomicDiffusion allows the user to execute an atomic algorithm in order to create a value.
 * (In french, easier) : Ici, il faut prendre en compte le lecteur - rédacteur. Le rédacteur définit la valeur,
 * puis il patiente jusqu'à ce que les lecteurs aient lu la valeur. Une fois cela fait il peut à nouveau changer la valeur.
 * Dans ces algorithmes, le générateur endosse le rôle du rédacteur, les canaux celui du lecteur
 *
 * @author Alexis Renault
 * @author Antoine Ravet
 * @version 1.0
 *
 */

public class AtomicDiffusion implements AlgoDiffusion{

    private List<ObservatorGeneratorAsync> channels;
    private GeneratorImpl generator;

    public void configure(GeneratorImpl generator) {
        this.channels = new LinkedList<>();
        this.generator = generator;
    }

    public void execute() {
        this.generator.stop();
        // Récupération des canaux du générateur afin de pouvoir les notifier et avoir la liste des 'lecteurs'
        this.channels = this.generator.getChannels();
        // Notification des canaux
        for (ObservatorGeneratorAsync oAsync : this.channels) {
            oAsync.update(this.generator);
        }
    }

    public String readValue(ObservatorGeneratorAsync channel) {
        // When a channel has read the value, it is remove from the channels list
        this.channels.remove(channel);
        if (this.channels.isEmpty()) {
            this.generator.restart();
        }
        return this.generator.getValue();
    }
}
