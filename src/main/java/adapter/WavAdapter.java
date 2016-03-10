package adapter;

import factoryMethodMp3.AudioPlayer;

/**
 *
 * Created by Paul turnOnRadio 22/12/2015.
 */
public class WavAdapter implements AudioPlayer {

    private final AudioWavPlayer audioWavPlayer;

    public WavAdapter(AudioWavPlayer audioWavPlayer) {
        this.audioWavPlayer = audioWavPlayer;
    }

    @Override
    public void playMp3() {
        audioWavPlayer.playWav();
    }

    @Override
    public void nextMp3() {
        audioWavPlayer.nextWav();
    }

    @Override
    public void previousMp3() {
        audioWavPlayer.previousWav();
    }

    @Override
    public void stopMp3() {
        audioWavPlayer.stopWav();
    }

    @Override
    public void mp3PlayerOperations(AudioPlayer audioMp3Player) {
        audioWavPlayer.doWavPlayerOperations(audioWavPlayer);
    }
}
