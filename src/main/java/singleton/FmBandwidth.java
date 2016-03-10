package singleton;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * Created by Paul turnOnRadio 15/01/2016.
 */
public class FmBandwidth {

    private static FmBandwidth fmStations;
    private final List<RadioStation>fmRadioStations;

    private FmBandwidth(List<RadioStation> fmRadioStations){
        this.fmRadioStations=fmRadioStations;
    }

    public static synchronized FmBandwidth getFmStations(){
        if (fmStations == null){
            fmStations = new FmBandwidth(getRadioStations());
        }
        return fmStations;
    }

    private static List<RadioStation>getRadioStations(){
        List<RadioStation>fmRadioStations = new ArrayList<>();
        RadioStation rte = new FMRadioStation("RTE Radio 1",
                "Current Affairs",
                88.0,
                "www.rteRadio1.com");
        fmRadioStations.add(rte);

        RadioStation twoFM = new FMRadioStation("2 FM",
                "Pop Music",
                92.0,
                "www.2fm.com");
        fmRadioStations.add(twoFM);

        RadioStation kerry = new FMRadioStation("Kerry Radio",
                "Current Affairs",
                97.0,
                "www.kerryRadio.com");
        fmRadioStations.add(kerry);

        RadioStation lyric = new FMRadioStation("Lyric FM",
                "Classical Music",
                98.0,
                "www.lyricFm.com");
        fmRadioStations.add(lyric);

        RadioStation today = new FMRadioStation("Today FM",
                "mixture of current affairs and pop music",
                100.0,
                "www.todayFm.com");
        fmRadioStations.add(today);

        RadioStation newsTalk = new FMRadioStation("News Talk",
                "Current Affairs",
                107.0,
                "www.newsTalk.com");
        fmRadioStations.add(newsTalk);

        return fmRadioStations;
    }

    public List<RadioStation> getFmRadioStation(){
        return fmRadioStations;
    }

}