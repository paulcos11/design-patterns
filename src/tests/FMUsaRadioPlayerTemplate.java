package tests;

import org.junit.Test;
import template.FMUsaRadioPlayer;
import template.LWUsaRadioPlayer;
import template.UsaRadio;

import static org.junit.Assert.*;

/**
 * Created by Paul turnOnRadio 19/01/2016.
 */
public class FMUsaRadioPlayerTemplate {

    private static final double DELTA = 1e-15;

    @Test
    public void tuneUpFMTest() throws Exception {

        UsaRadio usaRadio = new FMUsaRadioPlayer();

        double ans = usaRadio.next(88.0);
        assertEquals(92.0,ans, DELTA);
    }

    @Test
    public void tuneUpLWTest() throws Exception {

        UsaRadio usaRadio = new LWUsaRadioPlayer();
        usaRadio.setCurrentFrequency(252.0);
        double ans = 198.0;
        assertEquals(ans,usaRadio.next(252.0),DELTA);
    }
}