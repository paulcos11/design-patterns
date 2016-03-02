package command;

import strategy.FMRadioPlayer;
import strategy.LWRadioPlayer;
import strategy.RadioPlayer;

/**
 * Created by Paul turnOnRadio 18/01/2016.
 */
public class MediaRemote {

    public static RadioPlayer turnOnDevice(String bandwidth) {
        double frequencyLow = 88.0;
        double frequencyHigh = 252.0;

        if (bandwidth.equals("fm")) {
            return new FMRadioPlayer(frequencyLow);
        } else if (bandwidth.equals("lw")) {
            return new LWRadioPlayer(frequencyHigh);
        }
        return new FMRadioPlayer(frequencyLow);
    }

    public static RadioPlayer turnOffDevice(RadioPlayer radioPlayer) {
        return radioPlayer;
    }
}
