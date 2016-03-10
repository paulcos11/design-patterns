package state;

import builder.AudioStore;
import builder.BuilderMethod;
import composite.Display;
import creationMethodComposite.Mp3PlayListStore;
import creationMethodComposite.PlayListBuilder;
import factoryMethodMp3.AudioPlayer;
import factoryMethodMp3.Mp3PlaylistStore;
import factoryMethodMp3.PlayList;
import factoryMethodWav.WavPlaylistStore;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * Created by Paul on 19/01/2016.
 */
public class PlayAudioPlayer implements MediaCentreState {

    private final MediaCentre mediaCentre;

    public PlayAudioPlayer(MediaCentre mediaCentre) {
        this.mediaCentre = mediaCentre;
    }

    @Override
    public void mediaCentreTurnOn() {
        System.out.println("Media centre on");
    }

    @Override
    public void mediaCentreTurnOff() {
        System.out.println("Media centre on");
    }

    @Override
    public void radioPlayerOn() {
        System.out.println("Radio Off");
    }

    @Override
    public void radioPlayerOff() {
        System.out.println("Radio Off");
    }

    @Override
    public void audioPlayerOn() throws Exception {
        System.out.println("\nAudio Player Selected\n");
        mediaCentre.mediaPlayerOption();
    }

    @Override
    public void audioPlayerOff() {
        System.out.println("\nAudio Player Off");
        mediaCentre.setMediaCentreState(mediaCentre.stopPlayingAudio());
    }

    @Override
    public void mediaOption() throws Exception {
        String audioChoice = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter <mp3> or <wav> for audio options" +
                "\nEnter <exit> to quit");
        try {
            audioChoice = in.readLine();
        } catch (Exception e) {
            System.err.println("Error!");
        }

        if (audioChoice.equalsIgnoreCase("mp3")) {
            chooseAlbumOrPlaylist();

        } else if (audioChoice.equalsIgnoreCase("wav")) {
            getWavAlbum(audioChoice);
        }
    }

    private void getWavAlbum(String mp3Choice) throws Exception {
        WavPlaylistStore wavPlaylistStore = new WavPlaylistStore();
        PlayList playList = wavPlaylistStore.requestWavPlayList(mp3Choice);
        doAudioPlayerOperations(playList);
    }

    private void doAudioPlayerOperations(PlayList playList) {
        BuilderMethod builderMethod = new BuilderMethod();
        AudioStore audioStore = new AudioStore(builderMethod);
        AudioPlayer audioMp3Player = audioStore.deviceSelector(playList);
        audioMp3Player.mp3PlayerOperations(audioMp3Player);
    }

    private void chooseAlbumOrPlaylist() throws Exception {
        String audioChoice = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (!audioChoice.equalsIgnoreCase("exit")) {

            System.out.println("\nEnter <album> to choose a mp3  " +
                    "album\t\t->\t\t<factory method> <decorator>" +
                    " <observer> <isSingleton> <state>\nEnter <playlist> to view" +
                    " mp3 tracks \t\t->\t\t<composite> <builder> <factory method>" +
                    "<isSingleton> <adapter> <decorator> <state>" +
                    "\nEnter <exit> to quit");
            try {
                audioChoice = in.readLine();
            } catch (Exception e) {
                System.err.println("Error! ");
            }

            if (audioChoice.equalsIgnoreCase("album")) {
                getMp3Albums();
            } else if (audioChoice.equalsIgnoreCase("playlist")) {
                getMp3PlayLists();
            }
        }
    }

    private void getMp3PlayLists() {
        PlayListBuilder builderMethod = new PlayListBuilder();
        Mp3PlayListStore playListStore = new Mp3PlayListStore(builderMethod);
        Display d = playListStore.displayPlaylist();
        d.getTrackList();
    }

    private void getMp3Albums() throws Exception {
        Mp3PlaylistStore mp3PlaylistStore = new Mp3PlaylistStore();
        PlayList playList = mp3PlaylistStore.requestPlayList();
        doAudioPlayerOperations(playList);
    }
}
