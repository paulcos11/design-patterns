package singleton;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Paul turnOnRadio 15/01/2016.
 */
public class UsaLwBandwidth {

    private static UsaLwBandwidth lwBandwidth;
    private final List<RadioStation> lwRadioStations;

    private UsaLwBandwidth(List<RadioStation> fmRadioStations){
        this.lwRadioStations =fmRadioStations;
    }

    public static synchronized UsaLwBandwidth getInstance(){
        if (lwBandwidth == null){
            List<RadioStation>lwRadioStations = new ArrayList<>();

            RadioStation rte = new UsaLWRadioStation("USA LW Radio 4",
                    "Current affairs",
                    198.0,
                    "www.usaRadio4.com");
            lwRadioStations.add(rte);

            RadioStation twoFM = new UsaLWRadioStation("USA LW Radio 1",
                    "Current Affairs",
                    252.0,
                    "www.lwRadio1.ie");
            lwRadioStations.add(twoFM);

            lwBandwidth = new UsaLwBandwidth(lwRadioStations);
        }
        return lwBandwidth;
    }

    public List<RadioStation> getLwRadioStation(){
        return lwRadioStations;
    }

}
