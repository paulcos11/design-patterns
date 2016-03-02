package composite;

/**
 *
 * Created by Paul turnOnRadio 20/12/2015.
 */
public class Mp3 implements Container {

    private final String artistName;
    private final String trackName;
    private final String length;
    private final String size;


    public Mp3(String artistName, String trackName, String length, String size) {
            this.artistName = artistName;
            this.trackName = trackName;
            this.length = length;
            this.size = size;
    }

    public String getLength() {
        return length;
    }

    public String getSize() {
        return size;
    }

    public String getArtistName() {
        return artistName;
    }

    @Override
    public void add(Container songComponent) {

    }

    public String getTrackName() {
        return trackName;
    }

    @Override
    public void displaySongInfo() {
        System.out.println(getTrackName() + " written by " +
                getArtistName() + " Length " + getLength() +
                " Size " + getSize());
    }
}
