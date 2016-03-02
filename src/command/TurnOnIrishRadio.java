package command;

import strategy.RadioPlayer;

/**
 *
 * Created by Paul turnOnRadio 18/01/2016.
 */
public class TurnOnIrishRadio implements Command{

    private final RadioPlayer mediaDevice;

    public TurnOnIrishRadio(RadioPlayer mediaDevice){
        this.mediaDevice=mediaDevice;
    }


    @Override
    public void execute() {
        mediaDevice.turnOnRadio();
    }
}
