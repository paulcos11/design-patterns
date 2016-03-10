package composite;

/**
 *
 * Created by Paul turnOnRadio 17/01/2016.
 */
public class Display {

    private final Container container;

    public Display(Container container){
        this.container=container;
    }

    public void getTrackList(){
        container.displaySongInfo();
    }

}
