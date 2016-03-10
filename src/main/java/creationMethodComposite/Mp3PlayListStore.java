package creationMethodComposite;

import composite.Display;

import java.util.Scanner;

/**
 *
 * Created by Paul turnOnRadio 01/12/2015.
 */
public class Mp3PlayListStore {

    private final PlayListBuilder builder;

    public Mp3PlayListStore(PlayListBuilder builder){
        this.builder =builder;
    }

    public Display displayPlaylist(){
        String choice;
        Scanner input = new Scanner(System.in);
        System.out.println("\nSelect playlist: <the beatles> <the kinks> <view all>");
        choice = input.nextLine();

        return builder.createDisplay(choice);
    }

}
