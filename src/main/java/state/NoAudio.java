package state;

/**
 *
 * Created by Paul on 19/01/2016.
 */
public class NoAudio implements MediaCentreState{

    private final MediaCentre mediaCentre;

    public NoAudio(MediaCentre mediaCentre){
        this.mediaCentre=mediaCentre;
    }


    @Override
    public void mediaCentreTurnOn() {
        System.out.println("Media centre on");
    }

    @Override
    public void mediaCentreTurnOff() {
        System.out.println("Media centre off");
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
    public void mediaOption() {

    }
}