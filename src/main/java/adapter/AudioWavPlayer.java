package adapter;

/**
 *
 * Created by Paul turnOnRadio 21/12/2015.
 */
public interface AudioWavPlayer {

    void playWav();
    void nextWav();
    void previousWav();
    void stopWav();
    void doWavPlayerOperations(AudioWavPlayer audioWavPlayer);
}
