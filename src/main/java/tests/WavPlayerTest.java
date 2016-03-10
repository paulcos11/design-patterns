package tests;

import adapter.Wav;
import adapter.WavPlayer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Paul on 22/01/2016.
 */
public class WavPlayerTest {

    @Test
    public void testNext() throws Exception {
        Wav wav1 = new Wav("test1", "test1", "test1", "test1");
        Wav wav2 = new Wav("test2", "test2", "test2", "test2");
        List<Wav> wavs = new ArrayList<>();
        wavs.add(wav1);
        wavs.add(wav2);
        WavPlayer wavPlayer = new WavPlayer(wavs);
        wavPlayer.setWav(1);
        assertEquals("test2", wavs.get(1).getTrackName());
        wavPlayer.setWav(0);
        assertEquals("test1", wavs.get(0).getTrackName());
    }
}