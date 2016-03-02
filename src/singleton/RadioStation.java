package singleton;

/**
 *
 * Created by Paul turnOnRadio 20/12/2015.
 */
public abstract class RadioStation {

    private String name;
    private String description;
    private double frequency;
    private String link;

    public RadioStation(String name,
                        String description,
                        double frequency,
                        String link){
        setName(name);
        setDescription(description);
        setFrequency(frequency);
        setLink(link);

    }

    private void setName(String name) {
        this.name = name;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    private void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getFrequency() {
        return frequency;
    }

    public String getLink() {
        return link;
    }
}