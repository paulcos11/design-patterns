package adapter;

import decorator.*;
import factoryMethodMp3.PlayList;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Paul turnOnRadio 16/01/2016.
 */
public class TheClashPlaylist extends PlayList {

    private static TheClashPlaylist mp3Playlist;
    private List<Wav>myMp3Playlist;

    private TheClashPlaylist() {
        name = "the clash";
        myMp3Playlist = getTheWhoPlaylist();
    }

    public static synchronized TheClashPlaylist getInstance(){
        if (mp3Playlist == null){
            mp3Playlist = new TheClashPlaylist();
        }
        return mp3Playlist;
    }

    public void getInfo() {
        Artist artist = new Band("\nthe clash", "\n\nA 6 peace band that play ",
                "\n\nthe clash are an English band from London," +
                        " formed in 1966. ", "\n\nBand info: http://www.theclash.com/");
        artist = new Rock(artist);
        artist = new Blues(artist);
        artist = new Funk(artist);
        System.out.println(artist.getName() + artist.getDescription() +
                artist.getOrigin() + artist.getLink());
    }


    public List<Wav> getTheWhoPlaylist() {
        myMp3Playlist = new ArrayList<>();
        myMp3Playlist.add(new Wav("The Clash","White Riot", "04:05", "3mb"));
        myMp3Playlist.add(new Wav("The Clash","London's Burning", "03:06", "3.5mb"));
        myMp3Playlist.add(new Wav("The Clash","Complete Control", "02:00", "2.5mb"));
        myMp3Playlist.add(new Wav("The Clash","Clash City Rockers", "01:57", "2.9mb"));
        myMp3Playlist.add(new Wav("The Clash","\"I'm So Bored with the U.S.A.", "03:51", "3mb"));

        return myMp3Playlist;
    }
}
