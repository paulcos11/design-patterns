package observerMp3;

/**
 *
 * Created by Paul turnOnRadio 23/11/2015.
 */
public interface Mp3PlayerObserver {

    void update(String name, String track, String length, String size);

}
