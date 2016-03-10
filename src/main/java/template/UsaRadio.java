package template;

import observerRadio.RadioMediaPlayerDisplay;
import observerRadio.RadioPlayerData;
import singleton.RadioStation;

import java.util.List;

/**
 * Created by Paul turnOnRadio 17/01/2016.
 */
public abstract class UsaRadio {

    private double currentFrequency;

    public final void templateMethod(double currentFrequency) throws InterruptedException {
        this.currentFrequency = currentFrequency;
        if(listAvailableStations()){
            getStations();
        }
        play();
        doRadioOperations();
        stop();
    }

    protected abstract void doRadioOperations() throws InterruptedException;

    public abstract double next(double currentFrequency) throws InterruptedException;

    protected abstract List<RadioStation> getRadioStations();

    protected abstract void getStations();

    protected void play() {
        System.out.println("\nUSA Radio currently playing");
        displayCurrentStation();
    }

    public boolean listAvailableStations(){
        return true;
    }

    private void stop() {
        System.out.println("USA radio stopped");
    }

    private void displayCurrentStation() {
        RadioPlayerData radioPlayerDataPlayerData = new RadioPlayerData();

        RadioMediaPlayerDisplay mediaPlayerDisplay = new
                RadioMediaPlayerDisplay(radioPlayerDataPlayerData);

        getRadioStations().stream().filter(station -> station.getFrequency() ==
                getCurrentFrequency()).forEach(station -> radioPlayerDataPlayerData
                .setRadioPlayerData("\nRadio Station: " + station.getName(),
                        "\nDescription: " + station.getDescription(),
                        "\nFrequency: " + station.getFrequency(),
                        "\nWeb site: " + station.getLink()));
    }

    public double getCurrentFrequency() {
        return currentFrequency;
    }

    public void setCurrentFrequency(double currentFrequency) {
        this.currentFrequency = currentFrequency;
    }
}