import java.util.LinkedList;
import java.util.List;

/**
 * SequentielleDiffusion allows the user to execute an sequential algorithm in order to create a value.
 * (In french, easier) : Ici, il faut prendre en compte le lecteur - rédacteur. Le rédacteur définit la valeur,
 * les lecteurs lisent une copie de celle-ci. Pendant la lecture de la copie, le rédacteur a la possibilité de changer la
 * valeur originale. Les lecteurs doivent tous avoir lu la copie pour en lire une nouvelle.
 *
 *
 * @author Alexis Renault
 * @author Antoine Ravet
 * @version 1.0
 *
 */

public class SequentielleDiffusion {
    private List<ObservatorGenerator> channels;
    private GeneratorImpl generator;
    private String copyValue;

    public void configure(GeneratorImpl generator) {
        this.channels = new LinkedList<>();
        this.generator = generator;
    }

    public void execute() {
        if(this.channels.isEmpty()){ // All the channels have read the generated value
            // We copy the value
            this.copyValue = this.generator.getValue();
            this.channels = this.generator.getChannels();
            // We update the channels
            for (ObservatorGenerator observator : this.channels) {
                observator.update(this.generator);
            }
        }
    }

    public String readValue(ObservatorGenerator channel){
        // When a channel has read the value, it is remove from the channels list
        this.channels.remove(channel);
        return this.getCopyValue();
    }

    public String getCopyValue(){
        return this.copyValue;
    }
}
