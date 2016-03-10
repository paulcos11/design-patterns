package builder;

import factoryMethodMp3.AudioPlayer;
import factoryMethodMp3.PlayList;

/**
 *
 * Created by Paul turnOnRadio 01/12/2015.
 */
public class AudioStore {

    private final BuilderMethod builder;

    public AudioStore(BuilderMethod builder){
        this.builder =builder;
    }

    public AudioPlayer deviceSelector(PlayList type){

        AudioPlayer audioMp3Player;
        audioMp3Player = builder.createMediaPlayer(type);

        return audioMp3Player;
    }
}
