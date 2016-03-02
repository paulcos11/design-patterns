package strategy;

/**
 *
 * Created by Paul turnOnRadio 01/01/2016.
 */
public interface PreviousStationSelector {

    double tuneDown(double currentFrequency) throws InterruptedException;

}
