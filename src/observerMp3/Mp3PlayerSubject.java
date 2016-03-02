package observerMp3;

/**
 * Created by Paul turnOnRadio 23/11/2015.
 */
public interface Mp3PlayerSubject {
    void registerMp3Observer(Mp3PlayerObserver mediaPlayerObserver);

    void removeMp3Observer(Mp3PlayerObserver mp3PlayerObserver);

    void notifyMp3Observer();

}


