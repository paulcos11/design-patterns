package factoryMethodMp3;

/**
 *
 * Created by Paul turnOnRadio 21/12/2015.
 */
public interface AudioPlayer {

    void playMp3();
    void nextMp3();
    void previousMp3();
    void stopMp3();
    void mp3PlayerOperations(AudioPlayer audioMp3Player);
}
