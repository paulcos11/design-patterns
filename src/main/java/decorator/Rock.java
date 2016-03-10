package decorator;

public class Rock extends ArtistDecorator {

    private final Artist artist;

    public Rock(Artist artist) {

        this.artist = artist;
    }

    @Override
    public String getName() {
        return artist.getName() + " /Rock";
    }

    @Override
    public String getDescription() {
        return artist.getDescription() + "\n\tRock - edgy sounding guitar thumping rhythms";
    }

    @Override
    public String getOrigin() {
        return artist.getOrigin() + "\n\tRock origins: Rock and roll emerged" +
                "as a defined musical style in the United States in the early" +
                "to mid-1950s. It derived most directly from the rhythm" +
                "and blues music of the 1940s, which itself developed from" +
                "earlier blues, boogie woogie, jazz and swing music, and was" +
                "also influenced by gospel, country and western, and traditional" +
                "folk music.";
    }

    @Override
    public String getLink() {

        return artist.getLink() + "\n\tRock info: https://en.wikipedia.org/wiki/Origins_of_rock_and_roll" ;
    }

}
