package strategy;

import observerRadio.RadioMediaPlayerDisplay;
import observerRadio.RadioPlayerData;
import singleton.FmBandwidth;
import singleton.RadioStation;

import java.util.List;

/**
 * Created by Paul turnOnRadio 01/01/2016.
 */
public class FMRadioPlayer extends RadioPlayer {

    public FMRadioPlayer(double currentFrequency) {
        super(currentFrequency);
        nextStation = new NextFMStation();
        previousStation = new PreviousFMStation();
    }

    public void playRadio() {
        System.out.println("\nFM Radio currently playing\n");
        displayCurrentStation();

    }

    public void stopRadio() {
        System.out.println("Stopped playing FM radio");

    }

    @Override
    public void turnOnRadio() {
        System.out.print("\nFM radio player selected" +
                "\nAuto tune FM radio station\n");
    }

    @Override
    public void turnOffRadio() {
        System.out.print("\nTurning off FM radio player\n");
    }

    private void displayCurrentStation() {
        RadioPlayerData radioPlayerDataPlayerData = new RadioPlayerData();

        RadioMediaPlayerDisplay mediaPlayerDisplay = new
                RadioMediaPlayerDisplay(radioPlayerDataPlayerData);



        getFWRadioStations().stream().filter(station -> station.getFrequency() == getCurrentFrequency()).forEach(station ->
                radioPlayerDataPlayerData.setRadioPlayerData("Radio Station: " + station.getName(),
                        "\nDescription: " + station.getDescription(),
                        "\nFrequency: " + station.getFrequency(),
                        "\nWeb site: " + station.getLink()));
    }

    private List<RadioStation> getFWRadioStations() {
        FmBandwidth fmStations = FmBandwidth.getFmStations();
        return fmStations.getFmRadioStation();
    }


}
