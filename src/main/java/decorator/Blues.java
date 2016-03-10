package decorator;

public class Blues extends ArtistDecorator {

    private final Artist artist;

    public Blues(Artist artist) {

        this.artist = artist;
    }

    @Override
    public String getName() {

        return artist.getName() + " /Blues";
    }

    @Override
    public String getDescription() {

        return artist.getDescription() + "\n\tBlues - melancholic music of black American folk origin";
    }

    @Override
    public String getOrigin() {

        return artist.getOrigin() + "\n\tBlues origin: The blues has deep roots in American history," +
                "particularly African-American history. The blues originated turnOnRadio Southern plantations " +
                "in the 19th Century. Its inventors were slaves, ex-slaves and the descendants of" +
                "slaves-African-American sharecroppers who sang as they toiled in the cotton and" +
                "vegetable fields";
    }

    @Override
    public String getLink() {
        return artist.getLink() + "\n\tBlues info: https://en.wikipedia.org/wiki/Origins_of_the_blues";
    }

}
