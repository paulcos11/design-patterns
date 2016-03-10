package state;

/**
 *
 * Created by Paul on 19/01/2016.
 */
public class NoRadio implements MediaCentreState{

    private final MediaCentre mediaCentre;

    public NoRadio(MediaCentre mediaCentre){
        this.mediaCentre=mediaCentre;
    }

    @Override
    public void mediaCentreTurnOn() {
        System.out.println("Media centre on");
    }

    @Override
    public void mediaCentreTurnOff() {
        System.out.println("Media centre on");
    }

    @Override
    public void radioPlayerOn() {
        System.out.println("\nRadio player selected");
    }

    @Override
    public void radioPlayerOff() {
        System.out.println("\nRadio Player Off");
        mediaCentre.setMediaCentreState(mediaCentre.stopPlayingRadio());
    }

    @Override
    public void audioPlayerOn() {
        System.out.println("Audio Player ON");
        mediaCentre.setMediaCentreState(mediaCentre.playAudio());
    }

    @Override
    public void audioPlayerOff() {
        System.out.println("\nRadio Player Off");
    }

    @Override
    public void mediaOption() {

    }
}