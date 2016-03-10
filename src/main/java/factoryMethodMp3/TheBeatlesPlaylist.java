package factoryMethodMp3;

import composite.Mp3;
import decorator.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Paul turnOnRadio 16/01/2016.
 */
public class TheBeatlesPlaylist extends PlayList {

    private static TheBeatlesPlaylist mp3Playlist;
    private List<Mp3>myMp3Playlist;

    private TheBeatlesPlaylist() {
        name = "the beatles";
        myMp3Playlist = new ArrayList<>();
        myMp3Playlist = new ArrayList<>();
        myMp3Playlist.add(new Mp3("The Beatles","Paperback writer", "05:05", "4mb"));
        myMp3Playlist.add(new Mp3("The Beatles","Yellow Submarine", "06:06", "4.5mb"));
        myMp3Playlist.add(new Mp3("The Beatles","Hello Goodbye", "04:04", "3.5mb"));
        myMp3Playlist.add(new Mp3("The Beatles","Yesterday", "03:07", "3.9mb"));
        myMp3Playlist.add(new Mp3("The Beatles","Help", "07:55", "6mb"));
    }

    public static synchronized TheBeatlesPlaylist getInstance(){
        if (mp3Playlist == null){
            mp3Playlist = new TheBeatlesPlaylist();
        }
        return mp3Playlist;
    }

    public void getInfo() {
        Artist artist = new Band("\nthe beatles", "\n\nA 4 peace band that play ",
                "\n\nthe beatles are an English band from Liverpool," +
                        " formed in 1955. ", "\n\nBand info: http://www.thebeatles.com/");
        artist = new Rock(artist);
        artist = new Blues(artist);
        artist = new Funk(artist);
        System.out.println(artist.getName() + artist.getDescription() +
                artist.getOrigin() + artist.getLink());
    }


    public List<Mp3> getTheBeatlesPlaylist() {

        return myMp3Playlist;
    }
}
