package factoryMethodMp3;

import composite.Mp3;
import observerMp3.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Paul turnOnRadio 20/12/2015.
 */
public class Mp3Player implements AudioPlayer {

    private final List<Mp3> mp3s;
    private int mp3;
    private final Mp3PlayerData mp3PlayerData;
    private static boolean isTrue;

    public Mp3Player(List<Mp3> mp3s) {
        this.mp3s = mp3s;
        this.mp3 = 0;
        setMp3(mp3);
        isTrue = false;
        mp3PlayerData = new Mp3PlayerData();
        DisplayFullScreenMode displayFullScreenMode = new DisplayFullScreenMode(mp3PlayerData);
    }

    @Override
    public void playMp3() {
        int current = getMp3();
        setMp3(current);
        System.out.println("\nPlaying mp3");
        displayMp3Content();
    }

    @Override
    public void nextMp3() {
        int current = getMp3();
        current++;

        if (current >= mp3s.size()) {
            current = 0;
        }
        setMp3(current);

        playMp3();
    }

    @Override
    public void previousMp3() {
        int current = getMp3();

        if (current <= 0) {
            current = 5;
        }
        setMp3(--current);

        playMp3();
    }

    @Override
    public void stopMp3() {
        System.out.println("Mp3 Stopped");
    }

    private void displayMp3Content() {

        if(!isTrue) {
            displayMediaOnSocialNetworks();
        }
        mp3PlayerData.setMp3PlayerData("Mp3 Playlist: " + mp3s.get(getMp3()).getArtistName(),
                "\nTrack: " + mp3s.get(getMp3()).getTrackName(),
                "\nMp3 Length: " + mp3s.get(getMp3()).getLength(),
                "\nSize: " + mp3s.get(getMp3()).getSize());

    }

    private boolean displayMediaOnSocialNetworks() {
        String displayContent = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\nDisplay Mp3 content on social media? y/n");
        try{
            displayContent=in.readLine();
        }catch (Exception e){
            System.err.println("Error!");
        }

        if(displayContent.equalsIgnoreCase("y")) {
            displayOnSocialMedia();

        }
        return isTrue = true;
    }

    private void displayOnSocialMedia() {
            FacebookDisplayMode facebookDisplayMode =
                    new FacebookDisplayMode(mp3PlayerData);
            WindowsMessengerDisplay windowsMessengerDisplay =
                    new WindowsMessengerDisplay(mp3PlayerData);

    }


    @Override
    public void mp3PlayerOperations(AudioPlayer audioMp3Player) {

        Scanner input = new Scanner(System.in);
        String option = "";
        audioMp3Player.playMp3();

        while (!option.equalsIgnoreCase("stop")) {

            System.out.println("\nSelect an option <play>" +
                    " <next> <previous> <stop>");
            option = input.nextLine();

            if (option.equalsIgnoreCase("play")) {
                audioMp3Player.playMp3();
            } else if (option.equalsIgnoreCase("next")) {
                audioMp3Player.nextMp3();
            } else if (option.equalsIgnoreCase("previous")) {
                audioMp3Player.previousMp3();
            } else if (option.equalsIgnoreCase("stop")) {
                audioMp3Player.stopMp3();
            }
        }
    }

    private void setMp3(int mp3) {
        this.mp3 = mp3;
    }

    private int getMp3() {
        return mp3;
    }
}
