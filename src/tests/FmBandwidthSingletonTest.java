package tests;

import org.junit.Test;
import singleton.FmBandwidth;


import static org.junit.Assert.*;

/**
 * Created by Paul on 22/01/2016.
 */
public class FmBandwidthSingletonTest {

    @Test
    public void isSingleton() throws Exception {
        FmBandwidth fmInstance1 = FmBandwidth.getFmStations();
        FmBandwidth fmInstance2 = FmBandwidth.getFmStations();
        FmBandwidth fmInstance3 = FmBandwidth.getFmStations();

        assertEquals(fmInstance1,fmInstance2);
        assertEquals(fmInstance1,fmInstance3);
        assertEquals(fmInstance2,fmInstance3);
    }
}