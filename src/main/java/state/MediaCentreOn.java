package state;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * Created by Paul on 19/01/2016.
 */
public class MediaCentreOn implements MediaCentreState{

    private final MediaCentre mediaCentre;

    public MediaCentreOn(MediaCentre mediaCentre){
        this.mediaCentre=mediaCentre;
    }

    @Override
    public void mediaCentreTurnOn() throws Exception {
        System.out.println("Welcome to the media centre!");
        mediaCentre.mediaPlayerOption();
    }

    @Override
    public void mediaCentreTurnOff() {
        System.out.println("Media centre off");
        mediaCentre.setMediaCentreState(mediaCentre.turnOffMediaCentre());
    }

    @Override
    public void radioPlayerOn() {

        System.out.println("Radio Player Off");

    }

    @Override
    public void radioPlayerOff() {
        System.out.println("Radio Player Off");
    }

    @Override
    public void audioPlayerOn() {
        System.out.println("Audio Player selected\n");
    }

    @Override
    public void audioPlayerOff() {
        System.out.println("\nAudio Player Off");
        mediaCentre.setMediaCentreState(mediaCentre.stopPlayingAudio());
    }

    @Override
    public void mediaOption() throws Exception {
        String mediaOption = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (!mediaOption.equalsIgnoreCase("exit")) {

            System.out.println("\nEnter <radio> for radio options" +
                    "\nEnter <audio> to play mp3 or wav format" +
                    "\nEnter <exit> to quit");
            try{
                mediaOption=in.readLine();
            }catch (Exception e){
                System.err.println("Error! :) ");
            }

            if (mediaOption.equalsIgnoreCase("radio")) {
                mediaCentre.setMediaCentreState(mediaCentre.playRadio());
                mediaCentre.radioPlayerOn();
                mediaCentre.radioPlayerOff();

            } else if (mediaOption.equalsIgnoreCase("audio")) {
                mediaCentre.setMediaCentreState(mediaCentre.playAudio());
                mediaCentre.audioPlayerOn();
                mediaCentre.audioOff();
            }
        }
        mediaCentre.setMediaCentreState(mediaCentre.turnOffMediaCentre());
        mediaCentre.mediaCentreTurnOff();
    }

}