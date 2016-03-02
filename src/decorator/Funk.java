package decorator;

public class Funk extends ArtistDecorator {

    private final Artist artist;

    public Funk(Artist artist) {

        this.artist = artist;
    }

    @Override
    public String getName() {
        return artist.getName() + " /Funk";
    }

    @Override
    public String getDescription() {
        return artist.getDescription() + "\n\tFunk - rhythm-driven music, links soul" +
                "to later African-American musical styles";
    }

    @Override
    public String getOrigin() {
        return artist.getOrigin() + "\n\tFunks Origins: mid-to late 1960s when African" +
                "American musicians created a rhythmic, danceable new form of music" +
                "through a mixture of soul music, jazz, and rhythm and blues (R&B).";
    }

    @Override
    public String getLink() {
        return artist.getLink() + "\n\tFunk info: https://en.wikipedia.org/wiki/Funk";
    }

}
