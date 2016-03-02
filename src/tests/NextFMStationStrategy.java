package tests;

import org.junit.Test;
import strategy.FMRadioPlayer;
import strategy.NextFMStation;
import strategy.NextStationSelector;
import strategy.RadioPlayer;

import static org.junit.Assert.*;

/**
 *
 * Created by Paul turnOnRadio 19/01/2016.
 */
public class NextFMStationStrategy {

    private static final double DELTA = 1e-15;

    @Test
    public void tuneUpTest() throws InterruptedException {
        RadioPlayer radioPlayer = new FMRadioPlayer(88.0);
        NextStationSelector nextFMStationTest = new NextFMStation();
        double ans = nextFMStationTest.tuneUp(radioPlayer.getCurrentFrequency());
            assertEquals(92.0, ans, DELTA);
    }

}