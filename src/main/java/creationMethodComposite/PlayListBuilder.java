package creationMethodComposite;

import composite.Container;
import composite.Display;
import composite.Mp3;
import composite.SongGroup;
import factoryMethodMp3.*;

import java.util.List;


/**
 *
 * Created by Paul turnOnRadio 01/12/2015.
 */
public class PlayListBuilder {

    public Display createDisplay(String type) {
        Display display;

        Container everySong = new SongGroup("Song List", "Every Song");
        Container beatles = new SongGroup("The Beatles", "My Beatles playlist");
        Container kinks = new SongGroup("The Kinks", "My Kinks playlist");
        everySong.add(beatles);
        everySong.add(kinks);

        TheBeatlesPlaylist mp3TheBeatles = TheBeatlesPlaylist.getInstance();
        List<Mp3> rockList = mp3TheBeatles.getTheBeatlesPlaylist();
        rockList.forEach(beatles::add);

        TheKinksPlayList mp3TheKinks = TheKinksPlayList.getInstance();
        List<Mp3> popRockList = mp3TheKinks.getTheKinksPlaylist();
        popRockList.forEach(kinks::add);

        if (type.equalsIgnoreCase("the beatles")) {
            display = new Display(beatles);
        } else if (type.equalsIgnoreCase("the kinks")) {
            display = new Display(kinks);
        } else {
            display = new Display(everySong);
        }
        return display;
    }
}
