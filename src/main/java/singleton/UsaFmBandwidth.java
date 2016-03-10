package singleton;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Paul turnOnRadio 15/01/2016.
 */
public class UsaFmBandwidth {

    private static UsaFmBandwidth fmStations;
    private final List<RadioStation>fmRadioStations;

    private UsaFmBandwidth(List<RadioStation> fmRadioStations){
        this.fmRadioStations=fmRadioStations;
    }

    public static synchronized UsaFmBandwidth getInstance(){
        if (fmStations == null){
            fmStations = new UsaFmBandwidth(getRadioStations());
        }
        return fmStations;
    }

    private static List<RadioStation>getRadioStations(){
        List<RadioStation>fmRadioStations = new ArrayList<>();
        RadioStation rte = new UsaFMRadioStation("RTE America 1",
                "Current Affairs",
                88.0,
                "www.rteAmericaRadio1.com");
        fmRadioStations.add(rte);

        RadioStation twoFM = new UsaFMRadioStation("America FM",
                "Pop Music",
                92.0,
                "www.AmericaFm.com");
        fmRadioStations.add(twoFM);

        RadioStation kerry = new UsaFMRadioStation("America Radio",
                "Current Affairs",
                97.0,
                "www.americaRadio.com");
        fmRadioStations.add(kerry);

        RadioStation lyric = new UsaFMRadioStation("America Lyric FM",
                "Classical Music",
                98.0,
                "www.americaLyricFm.com");
        fmRadioStations.add(lyric);

        RadioStation today = new UsaFMRadioStation("America Today FM",
                "mixture of current affairs and pop music",
                100.0,
                "www.americaTodayFm.com");
        fmRadioStations.add(today);

        RadioStation newsTalk = new UsaFMRadioStation("News Talk America",
                "Current Affairs",
                107.0,
                "www.newsTalkAmerica.com");
        fmRadioStations.add(newsTalk);

        return fmRadioStations;
    }

    public List<RadioStation> getFmRadioStation(){
        return fmRadioStations;
    }

}