package factoryMethodMp3;

import composite.Mp3;
import decorator.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Paul turnOnRadio 16/01/2016.
 */
public class TheKinksPlayList extends PlayList {

    private static TheKinksPlayList mp3Playlist;
    private List<Mp3>myMp3Playlist;


    private TheKinksPlayList() {
        name = "the kinks";
        myMp3Playlist = new ArrayList<>();
        myMp3Playlist = new ArrayList<>();
        myMp3Playlist.add(new Mp3("The Kinks","Lola", "05:05", "4mb"));
        myMp3Playlist.add(new Mp3("The Kinks","You Really Got Me", "06:06", "4.5mb"));
        myMp3Playlist.add(new Mp3("The Kinks","Sunday Afternoon", "04:04", "3.5mb"));
        myMp3Playlist.add(new Mp3("The Kinks","Waterloo Sunset", "03:07", "3.9mb"));
        myMp3Playlist.add(new Mp3("The Kinks","Tired of Waiting", "07:55", "6mb"));
    }

    public static synchronized TheKinksPlayList getInstance(){
        if (mp3Playlist == null){
            mp3Playlist = new TheKinksPlayList();
        }
        return mp3Playlist;
    }

    public void getInfo() {

        Artist artist = new Band("\nthe kinks", "\n\nA 5 peace band that play ",
                "\n\nthe kinks is an American rock band from Los Angeles, California," +
                        " formed in 1985. ", "\n\nBand info: http://www.thekinks.com/");
        artist = new Rock(artist);
        artist = new Blues(artist);
        artist = new Funk(artist);
        System.out.println(artist.getName() + artist.getDescription() +
                artist.getOrigin() + artist.getLink());
    }

    public List<Mp3> getTheKinksPlaylist() {
        return myMp3Playlist;
    }
}
