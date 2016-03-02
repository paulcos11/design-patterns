package factoryMethodWav;

import factoryMethodMp3.PlayList;

/**
 *
 * Created by Paul turnOnRadio 16/01/2016.
 */
public abstract class ListStore {

    public PlayList requestWavPlayList(String type) throws Exception {

        return createWavPlayList(type);
    }

    protected abstract PlayList createWavPlayList(String type) throws Exception;
}
