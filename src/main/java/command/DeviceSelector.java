package command;

/**
 *
 * Created by Paul turnOnRadio 18/01/2016.
 */
public class DeviceSelector  {

    private final Command command;

    public DeviceSelector(Command command){
        this.command=command;
    }

    public void select(){
        command.execute();
    }
}
