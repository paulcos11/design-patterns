package factoryMethodMp3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Created by Paul turnOnRadio 16/01/2016.
 */
public class Mp3PlaylistStore extends PlayListStore {

    @Override
    protected PlayList createPlayList() throws Exception {

        PlayList playList;
        String album = getAlbumType();

        if (album.equalsIgnoreCase("the beatles")) {
            playList = TheBeatlesPlaylist.getInstance();
            return playList;
        } else if (album.equalsIgnoreCase("the kinks")) {
            playList = TheKinksPlayList.getInstance();
            return playList;
        }
        throw new Exception("No playlist found by the name " + album);
    }

    private String getAlbumType() {
        Scanner input = new Scanner(System.in);
        String album;
        List<String> playLists = new ArrayList<>();
        playLists.add(TheBeatlesPlaylist.getInstance().getName());
        playLists.add(TheKinksPlayList.getInstance().getName());

        String text = "\nSelect an album: ";

        for (String s : playLists) {
            text += "\n" + s;
        }
        System.out.println(text);
        album = input.nextLine();
        return album;
    }
}