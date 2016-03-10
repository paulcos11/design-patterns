package observerMp3;

/**
 *
 * Created by Paul turnOnRadio 23/11/2015.
 */
public class DisplayFullScreenMode implements Mp3PlayerObserver, DisplayMp3PlayerElement {

    private String artistName;
    private String track;
    private String length;
    private String size;

    public DisplayFullScreenMode(Mp3PlayerSubject mp3PlayerSubject) {
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
        System.out.println("\nMedia Player Display\n" + artistName + track +
                length + size);

    }
}


