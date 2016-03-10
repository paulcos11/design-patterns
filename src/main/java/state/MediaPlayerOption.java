package state;

/**
 *
 * Created by Paul on 19/01/2016.
 */
public class MediaPlayerOption implements MediaCentreState{

    private final MediaCentre mediaCentre;

    public MediaPlayerOption(MediaCentre mediaCentre){
        this.mediaCentre=mediaCentre;
    }


    @Override
    public void mediaCentreTurnOn() throws InterruptedException {
        mediaCentre.setMediaCentreState(mediaCentre.turnOnMediaCentre());
        mediaCentre.mediaCentreTurnOn();

    }

    @Override
    public void mediaCentreTurnOff() {
        System.out.println("\nTurns off media centre");
    }

    @Override
    public void radioPlayerOn() {
        System.out.println("\nPlays radio");
    }

    @Override
    public void radioPlayerOff() {
        System.out.println("\nturns off radio player");
    }

    @Override
    public void audioPlayerOn() {
        System.out.println("\nturns on audio player");
    }

    @Override
    public void audioPlayerOff() {
        System.out.println("\nturns off audio player");
    }

    @Override
    public void mediaOption() {
        System.out.println("Media Centre Options!!!!");
    }
}