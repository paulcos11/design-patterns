package creationMethodUsaRadio;

import template.UsaRadio;
import template.FMUsaRadioPlayer;
import template.LWUsaRadioPlayer;

/**
 *
 * Created by Paul turnOnRadio 01/12/2015.
 */
public class USARadioCreationMethod {

    public UsaRadio createUSARadioPlayer(String type) {

        UsaRadio radioPlayer = null;

        if (type.equalsIgnoreCase("FM USA")) {
            radioPlayer = new FMUsaRadioPlayer();

        } else if (type.equalsIgnoreCase("LW USA")) {
            radioPlayer = new LWUsaRadioPlayer();
        }

        return radioPlayer;
    }
}
