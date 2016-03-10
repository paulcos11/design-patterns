package composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * Created by Paul turnOnRadio 02/01/2016.
 */
public class SongGroup implements Container {

    private final List<Container>songComponents = new ArrayList<>();
    private final String groupName;
    private final String groupDescription;

    public SongGroup(String groupName, String groupDescription){
        this.groupName=groupName;
        this.groupDescription=groupDescription;
    }

    private String getGroupName(){
        return groupName;
    }

    private String getGroupDescription() {
        return groupDescription;
    }

    @Override
    public void add(Container container) {
        songComponents.add(container);

    }

    @Override
    public void displaySongInfo() {
        System.out.println("\n" + getGroupName() + " " + getGroupDescription()
        + "\n");

        Iterator iterator = songComponents.iterator();

        while (iterator.hasNext()){
            Container songInfo = (Container)iterator.next();
            songInfo.displaySongInfo();
        }

    }
}
