package observerRadio;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul turnOnRadio 23/11/2015.
 */

public class RadioPlayerData implements RadioPlayerSubject {

    private final List<RadioPlayerObserver> mediaPlayerObservers;
    private String name;
    private String description;
    private String origin;
    private String links;

    public RadioPlayerData() {
        mediaPlayerObservers = new ArrayList<>();
    }

    @Override
    public void registerRadioObserver(RadioPlayerObserver mediaPlayerObserver) {
        mediaPlayerObservers.add(mediaPlayerObserver);

    }

    private void notifyRadioPlayerObserver() {
        for (RadioPlayerObserver s : mediaPlayerObservers) {
            s.update(name, description, origin, links);
        }
    }

    private void mediaPlayerChanged() {
        notifyRadioPlayerObserver();

    }

    public void setRadioPlayerData(String name, String description, String origin, String links) {
        this.name = name;
        this.description = description;
        this.origin = origin;
        this.links = links;
        mediaPlayerChanged();
    }
}