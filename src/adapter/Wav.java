package adapter;

/**
 *
 * Created by Paul turnOnRadio 20/12/2015.
 */
public class Wav {

    private final String artistName;
    private final String trackName;
    private final String length;
    private final String size;


    public Wav(String artistName, String trackName, String length, String size){
        this.artistName = artistName;
        this.trackName = trackName;
        this.length = length;
        this.size = size;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getLength() {
        return length;
    }

    public String getSize() {
        return size;
    }

    public String getTrackName() {return trackName;}

}
