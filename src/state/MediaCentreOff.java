package state;

/**
 *
 * Created by Paul on 19/01/2016.
 */
public class MediaCentreOff implements MediaCentreState{

    private final MediaCentre mediaCentre;

    public MediaCentreOff(MediaCentre mediaCentre){
        this.mediaCentre=mediaCentre;
    }


    @Override
    public void mediaCentreTurnOn() throws InterruptedException {
        mediaCentre.setMediaCentreState(mediaCentre.turnOnMediaCentre());
        mediaCentre.mediaCentreTurnOn();

    }

    @Override
    public void mediaCentreTurnOff() {
        System.out.println("\nMedia Centre turned off");
    }

    @Override
    public void radioPlayerOn() {
        System.out.println("\nTurn on Media Centre then select radio");
    }

    @Override
    public void radioPlayerOff() {
        System.out.println("\nMedia Centre Off");
    }

    @Override
    public void audioPlayerOn() {
        System.out.println("\nMedia Centre Off");
    }

    @Override
    public void audioPlayerOff() {
        System.out.println("\nMedia Centre Off");
    }

    @Override
    public void mediaOption() {

    }
}