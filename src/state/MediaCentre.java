package state;

/**
 *
 * Created by Paul on 19/01/2016.
 */
public class MediaCentre {

    private final MediaCentreState playingRadioPlayer;
    private final MediaCentreState noRadio;
    private final MediaCentreState playingAudioPlayer;
    private final MediaCentreState noAudio;
    private final MediaCentreState mediaCentreOff;
    private final MediaCentreState mediaCentreOn;
    private final MediaCentreState mediaOption;
    private MediaCentreState mediaCentreState;

    public MediaCentre() {
        mediaCentreOn = new MediaCentreOn(this);
        mediaCentreOff = new MediaCentreOff(this);
        noRadio = new NoRadio(this);
        noAudio = new NoAudio(this);
        playingAudioPlayer = new PlayAudioPlayer(this);
        playingRadioPlayer = new PlayRadioPlayer(this);
        mediaOption = new MediaPlayerOption(this);

        mediaCentreState = mediaCentreOff;
    }

    public void setMediaCentreState(MediaCentreState mediaCentreState) {
        this.mediaCentreState = mediaCentreState;
    }

    public void mediaCentreTurnOn() {
        try {
            mediaCentreState.mediaCentreTurnOn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mediaCentreTurnOff() {
        mediaCentreState.mediaCentreTurnOff();
    }

    public void mediaPlayerOption() throws Exception {
        mediaCentreState.mediaOption();
    }

    public void radioPlayerOn() throws Exception {
        mediaCentreState.radioPlayerOn();
    }

    public void radioPlayerOff() {
        mediaCentreState.radioPlayerOff();
    }

    public void audioPlayerOn() throws Exception {
        mediaCentreState.audioPlayerOn();
    }

    public void audioOff() {
        mediaCentreState.audioPlayerOff();
    }

    public MediaCentreState turnOffMediaCentre() {
        return mediaCentreOff;
    }

    public MediaCentreState turnOnMediaCentre() {
        return mediaCentreOn;
    }

    public MediaCentreState playRadio() {
        return playingRadioPlayer;
    }

    public MediaCentreState stopPlayingRadio() {
        return noRadio;
    }

    public MediaCentreState playAudio() {
        return playingAudioPlayer;
    }

    public MediaCentreState stopPlayingAudio() {
        return noAudio;
    }

    public MediaCentreState mediaPlayerChooseOption() {
        return mediaOption;
    }
}
