package factoryMethodMp3;

/**
 *
 * Created by Paul turnOnRadio 16/01/2016.
 */
public abstract class PlayListStore {

    public PlayList requestPlayList() throws Exception {

        return createPlayList();
    }

    protected abstract PlayList createPlayList() throws Exception;
}
