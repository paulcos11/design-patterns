package driver;

import state.MediaCentre;
/**
 *
 * Created by Paul turnOnRadio 20/12/2015.
 */
public class MediaPlayerTester {

    public static void main(String args[]) throws Exception {
        MediaCentre mediaCentre = new MediaCentre();
        mediaCentre.mediaCentreTurnOn();
    }
}