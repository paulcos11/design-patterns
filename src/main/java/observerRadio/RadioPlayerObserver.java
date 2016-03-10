package observerRadio;

/**
 *
 * Created by Paul turnOnRadio 23/11/2015.
 */
public interface RadioPlayerObserver {
    void update(String name, String description, String origin, String links);
}
