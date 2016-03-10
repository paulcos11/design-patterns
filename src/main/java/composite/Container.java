package composite;

/**
 *
 * Created by Paul turnOnRadio 16/01/2016.
 */
public interface Container {

    void add(Container container);

    void displaySongInfo();
}
