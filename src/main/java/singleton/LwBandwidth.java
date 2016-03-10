package singleton;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Paul turnOnRadio 15/01/2016.
 */
public class LwBandwidth {

    private static LwBandwidth lwBandwidth;
    private final List<RadioStation> lwRadioStations;

    private LwBandwidth(List<RadioStation> fmRadioStations){
        this.lwRadioStations =fmRadioStations;
    }

    public static synchronized LwBandwidth getInstance(){
        if (lwBandwidth == null){
            List<RadioStation>lwRadioStations = new ArrayList<>();

            RadioStation rte = new LWRadioStation("BBC Radio 4",
                    "Current affairs",
                    198.0,
                    "www.bbcRadio.com");
            lwRadioStations.add(rte);

            RadioStation twoFM = new LWRadioStation("RTE Radio 1",
                    "Current Affairs",
                    252.0,
                    "www.rte.ie");
            lwRadioStations.add(twoFM);

            lwBandwidth = new LwBandwidth(lwRadioStations);
        }
        return lwBandwidth;
    }

    public List<RadioStation> getLwRadioStation(){
        return lwRadioStations;
    }

}
