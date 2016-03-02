package command;

import strategy.RadioPlayer;

/**
 *
 * Created by Paul turnOnRadio 18/01/2016.
 */
public class TurnOffIrishRadio implements Command{

    private final RadioPlayer radioPlayer;

    public TurnOffIrishRadio(RadioPlayer radioPlayer){
        this.radioPlayer=radioPlayer;
    }


    @Override
    public void execute() {
        radioPlayer.turnOffRadio();
    }
}
