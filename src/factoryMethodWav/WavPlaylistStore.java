package factoryMethodWav;

import adapter.TheClashPlaylist;
import factoryMethodMp3.PlayList;

/**
 *
 * Created by Paul turnOnRadio 16/01/2016.
 */
public class WavPlaylistStore extends ListStore {

    @Override
    protected PlayList createWavPlayList(String type) throws Exception {
         if(type.equalsIgnoreCase("wav")){
             return TheClashPlaylist.getInstance();
        }
        throw new Exception("No playlist found by the name " + type);
    }
}