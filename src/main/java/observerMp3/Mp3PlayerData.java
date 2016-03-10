package observerMp3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Paul turnOnRadio 23/11/2015.
 */

public class Mp3PlayerData implements Mp3PlayerSubject {

    private final List<Mp3PlayerObserver> mediaPlayerObservers;
    private String artistName;
    private String track;
    private String length;
    private String size;

    public Mp3PlayerData() {
        mediaPlayerObservers = new ArrayList<>();
    }

    @Override
    public void registerMp3Observer(Mp3PlayerObserver mediaPlayerObserver) {
        mediaPlayerObservers.add(mediaPlayerObserver);
    }

    @Override
    public void removeMp3Observer(Mp3PlayerObserver mp3PlayerObserver) {
        mediaPlayerObservers.remove(mp3PlayerObserver);
    }

    @Override
    public void notifyMp3Observer() {
        for (Mp3PlayerObserver s : mediaPlayerObservers) {

            s.update(artistName, track,length, size);
        }
    }

    private void mediaPlayerChanged() {
        notifyMp3Observer();
    }

    public void setMp3PlayerData(String artistName, String track, String length, String size) {
        this.artistName = artistName;
        this.track=track;
        this.length = length;
        this.size = size;
        mediaPlayerChanged();

    }
}