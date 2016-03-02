package strategy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * Created by Paul turnOnRadio 01/01/2016.
 */
public abstract class RadioPlayer {
    protected NextStationSelector nextStation;
    protected PreviousStationSelector previousStation;
    private double currentFrequency;

    public RadioPlayer(double currentFrequency) {
        setCurrentFrequency(currentFrequency);
    }

    private void tuneFrequencyUp() throws InterruptedException {
        setCurrentFrequency(nextStation.tuneUp(getCurrentFrequency()));
        playRadio();
    }

    private void tuneFrequencyDown() throws InterruptedException {
        setCurrentFrequency(previousStation.tuneDown(getCurrentFrequency()));
        playRadio();
    }

    protected abstract void playRadio();

    protected abstract void stopRadio();

    public abstract void turnOnRadio();

    public abstract void turnOffRadio();

    private void setCurrentFrequency(double currentFrequency) {
        this.currentFrequency = currentFrequency;
    }

    public double getCurrentFrequency() {
        return currentFrequency;
    }

    public void radioOperator(RadioPlayer radioPlayer) throws InterruptedException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String option = "";
        radioPlayer.tuneFrequencyUp();

        while (!option.equalsIgnoreCase("off")) {

            System.out.println("\nSelect an option" +
                    " <tuneUp> <tuneDown> <off>");
            try{
                option=in.readLine();
            }catch (Exception e){
                System.err.println("Error");
            }

            if (option.equalsIgnoreCase("tuneUp")) {
                radioPlayer.tuneFrequencyUp();
            } else {
                if (option.equalsIgnoreCase("tuneDown")) {
                    radioPlayer.tuneFrequencyDown();
                } else if (option.equalsIgnoreCase("off")) {
                    radioPlayer.stopRadio();
                }
            }
        }
    }
}