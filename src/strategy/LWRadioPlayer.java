package strategy;

import observerRadio.RadioMediaPlayerDisplay;
import observerRadio.RadioPlayerData;
import singleton.LwBandwidth;
import singleton.RadioStation;

import java.util.List;

/**
 *
 * Created by Paul turnOnRadio 01/01/2016.
 */
public class LWRadioPlayer extends RadioPlayer{

    public LWRadioPlayer(double currentFrequency) {
        super(currentFrequency);
        nextStation = new NextLWStation();
        previousStation = new PreviousLWStation();
    }

    public void playRadio() {
        System.out.println("\nLW Radio currently playing\n");
        displayCurrentStation();

    }

    public void stopRadio() {
        System.out.println("Stopped playing LW radio");

    }

    private void displayCurrentStation() {
        RadioPlayerData radioPlayerDataPlayerData = new RadioPlayerData();

        RadioMediaPlayerDisplay mediaPlayerDisplay = new
                RadioMediaPlayerDisplay(radioPlayerDataPlayerData);

        getLWRadioStations().stream().filter(station -> station.getFrequency()
                == getCurrentFrequency()).forEach(station -> radioPlayerDataPlayerData
                .setRadioPlayerData("Radio Station: " + station.getName(),
                        "\nDescription: " + station.getDescription(),
                        "\nFrequency: " + station.getFrequency(),
                        "\nWeb site: " + station.getLink()));
    }

    private List<RadioStation> getLWRadioStations() {
        LwBandwidth lwStations = LwBandwidth.getInstance();
        return lwStations.getLwRadioStation();
    }

    @Override
    public void turnOnRadio() {
        System.out.print("\nLW radio player selected" +
                "\nAuto tune FM radio player");
    }

    @Override
    public void turnOffRadio() {
        System.out.print("\nTurning off LW radio\n");
    }


}
