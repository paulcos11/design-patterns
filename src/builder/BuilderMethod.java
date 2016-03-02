package builder;

import adapter.*;
import factoryMethodMp3.*;

/**
 *
 * Created by Paul turnOnRadio 01/12/2015.
 */
public class BuilderMethod {

    public AudioPlayer createMediaPlayer(PlayList playList) {

        AudioPlayer audioPlayer = null;

        if (playList.getName().equalsIgnoreCase("the clash")) {
            TheClashPlaylist theWhoPlaylist = TheClashPlaylist.getInstance();
            theWhoPlaylist.getInfo();
            WavPlayer wavPlayer = new WavPlayer(theWhoPlaylist.getTheWhoPlaylist());
            audioPlayer = new WavAdapter(wavPlayer);

        } else if (playList.getName().equalsIgnoreCase("the beatles")) {
            TheBeatlesPlaylist theBeatles = TheBeatlesPlaylist.getInstance();
            theBeatles.getInfo();
            audioPlayer = new Mp3Player(theBeatles.getTheBeatlesPlaylist());

        } else if (playList.getName().equalsIgnoreCase("the kinks")) {
            TheKinksPlayList theKinks = TheKinksPlayList.getInstance();
            theKinks.getInfo();
            audioPlayer = new Mp3Player(theKinks.getTheKinksPlaylist());
        }

        return audioPlayer;
    }
}
