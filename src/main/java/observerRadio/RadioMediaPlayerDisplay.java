package observerRadio;

/**
 *
 * Created by Paul turnOnRadio 23/11/2015.
 */
public class RadioMediaPlayerDisplay implements RadioPlayerObserver {

    private String name;
    private String description;
    private String origin;
    private String links;

    public RadioMediaPlayerDisplay(RadioPlayerSubject radioPlayerSubject) {
        radioPlayerSubject.registerRadioObserver(this);
    }

    @Override
    public void update(String name, String description, String origin, String links) {
        this.name = name;
        this.description = description;
        this.origin = origin;
        this.links = links;
        display();

    }

    private void display() {
        System.out.println(name + description +
                origin + links);
    }
}


