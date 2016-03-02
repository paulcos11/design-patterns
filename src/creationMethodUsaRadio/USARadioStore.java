package creationMethodUsaRadio;

import template.UsaRadio;

/**
 *
 * Created by Paul turnOnRadio 01/12/2015.
 */
public class USARadioStore {

    private final USARadioCreationMethod creation;

    public USARadioStore(USARadioCreationMethod creation){
        this.creation=creation;
    }

    public UsaRadio deviceSelector(String type){

        UsaRadio radioPlayer;
        radioPlayer = creation.createUSARadioPlayer(type);

        return radioPlayer;
    }
}
