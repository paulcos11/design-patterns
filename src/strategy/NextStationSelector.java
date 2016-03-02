package strategy;

/**
 *
 * Created by Paul turnOnRadio 01/01/2016.
 */
public interface NextStationSelector {

    double tuneUp(double currentFrequency) throws InterruptedException;

}
