package observerMp3;

/**
 *
 * Created by Paul turnOnRadio 23/11/2015.
 */
public class WindowsMessengerDisplay implements Mp3PlayerObserver, DisplayMp3PlayerElement {

    private String artistName;
    private String track;
    private String length;
    private String size;

    public WindowsMessengerDisplay(Mp3PlayerSubject mp3PlayerSubject) {
        mp3PlayerSubject.registerMp3Observer(this);
    }

    @Override
    public void update(String artistName, String track, String length, String size) {
        this.artistName = artistName;
        this.track = track;
        this.length = length;
        this.size = size;
        display();
    }


    public void display() {
        length="";
        size="";
        System.out.println("\nWindows Messenger display\nPaul is listening to " +
                artistName + track + " on Media Centre. " +
                "\nDownload Media Centre for free at www.mediacentre.com" + length + size);
    }
}


