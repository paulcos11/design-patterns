package state;

/**
 *
 * Created by Paul on 19/01/2016.
 */
public interface MediaCentreState {
    void mediaCentreTurnOn() throws Exception;
    void mediaCentreTurnOff();
    void radioPlayerOn() throws Exception;
    void radioPlayerOff();
    void audioPlayerOn() throws Exception;
    void audioPlayerOff();
    void mediaOption() throws Exception;
}
