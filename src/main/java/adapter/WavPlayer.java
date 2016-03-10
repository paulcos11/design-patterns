package adapter;

import observerMp3.DisplayFullScreenMode;
import observerMp3.Mp3PlayerData;
import java.util.List;
import java.util.Scanner;

/**
 *
 * Created by Paul turnOnRadio 20/12/2015.
 */
public class WavPlayer implements AudioWavPlayer {

    private final List<Wav> wavs;
    private int wav;

    public WavPlayer(List<Wav> wavs) {
        this.wavs = wavs;
        this.wav = 0;
        setWav(wav);
    }

    @Override
    public void playWav() {
        int current = getWav();
        setWav(current);
        System.out.println("\nPlaying wav");
        displayWav();
    }

    @Override
    public void nextWav() {
        int current = getWav();
        current++;

        if (current >= wavs.size()) {
            current = 0;
        }
        setWav(current);
        playWav();
    }

    @Override
    public void previousWav() {
        int current = getWav();

        if (current <= 0) {
            current = 5;
        }
        setWav(--current);
        playWav();
    }

    @Override
    public void stopWav() {
        System.out.println("\nWav Stopped");
    }

    private void displayWav() {
        Mp3PlayerData mp3PlayerDataPlayerData = new Mp3PlayerData();

        DisplayFullScreenMode mediaPlayerDisplay = new
                DisplayFullScreenMode(mp3PlayerDataPlayerData);
        mp3PlayerDataPlayerData.setMp3PlayerData("\nWav Playlist: " + wavs.get(getWav()).getArtistName(),
                "\nTrack: " + wavs.get(getWav()).getTrackName(),
                "\nLength: " + wavs.get(getWav()).getLength(),
                "\nSize: " + wavs.get(getWav()).getSize());

    }

    @Override
    public void doWavPlayerOperations(AudioWavPlayer audioWavPlayer) {
        Scanner input = new Scanner(System.in);
        String option = "";
        audioWavPlayer.playWav();

        while (!option.equalsIgnoreCase("stop")) {

            System.out.println("\nSelect an option <play>" +
                    " <next> <previous> <stop>");
            option = input.nextLine();

            if (option.equalsIgnoreCase("play")) {
                audioWavPlayer.playWav();
            } else if (option.equalsIgnoreCase("next")) {
                audioWavPlayer.nextWav();
            } else if (option.equalsIgnoreCase("previous")) {
                audioWavPlayer.previousWav();
            } else if (option.equalsIgnoreCase("stop")) {
                audioWavPlayer.stopWav();
            }
        }
    }

    public void setWav(int wav) {
        this.wav = wav;
    }

    private int getWav() {
        return wav;
    }
}
