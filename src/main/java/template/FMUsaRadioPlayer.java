package template;

import singleton.UsaFmBandwidth;
import singleton.RadioStation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Created by Paul turnOnRadio 18/01/2016.
 */
public class FMUsaRadioPlayer extends UsaRadio {

    private List<Double> fmStationFrequencies;

    protected void doRadioOperations() throws InterruptedException {
        boolean isValid = true;
        String choice="";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (isValid){
            System.out.println("\n<tuneUp> <tuneDown> <off>");
            try{
                choice=in.readLine();
            }catch (Exception e){
                System.err.println("Error ");
            }

            if(choice.equalsIgnoreCase("tuneUp")){
                setCurrentFrequency(next(getCurrentFrequency()));
            } else if(choice.equalsIgnoreCase("tuneDown")){
                setCurrentFrequency(previous(getCurrentFrequency()));
            }else if(choice.equalsIgnoreCase("off")){
                isValid = false;
            }
        }
    }

    @Override
    public double next(double currentFrequency) throws InterruptedException {
        final double FREQUENCY_HIGH = 108.0;

        UsaFmBandwidth fmStations = UsaFmBandwidth.getInstance();

        if(fmStationFrequencies == null) {
            fmStationFrequencies = new ArrayList<>();
            fmStationFrequencies.addAll(fmStations.getFmRadioStation().stream()
                    .map(RadioStation::getFrequency).collect(Collectors.toList()));
        }

        for (int i = 0; i <= fmStationFrequencies.size(); i++) {

            if (fmStationFrequencies.get(i) == currentFrequency) {

                for (double j = currentFrequency; j < FREQUENCY_HIGH; j += .5) {
                    Thread.sleep(180);
                    System.out.print(">>>>>>");
                    if (currentFrequency == fmStationFrequencies
                            .get(fmStations.getFmRadioStation().size() - 1)) {

                        currentFrequency = fmStationFrequencies.get(0);
                        setCurrentFrequency(currentFrequency);
                        play();
                        return currentFrequency;

                    } else if (j == fmStationFrequencies.get(i + 1)) {
                        currentFrequency = j;
                        setCurrentFrequency(currentFrequency);
                        play();
                        return currentFrequency;
                    }
                }
            }
        }
        return currentFrequency;
    }

    public double previous(double currentFrequency) throws InterruptedException {
        final double FREQUENCY_LOW = 87;

        UsaFmBandwidth fmStations = UsaFmBandwidth.getInstance();

        if (fmStationFrequencies == null) {
            fmStationFrequencies = new ArrayList<>();
            fmStationFrequencies.addAll(fmStations.getFmRadioStation().stream()
                    .map(RadioStation::getFrequency).collect(Collectors.toList()));
        }

        for (int i = fmStationFrequencies.size() - 1; i >= 0; i--) {

            if (fmStationFrequencies.get(i) == currentFrequency) {

                for (double j = currentFrequency; j > FREQUENCY_LOW; j -= .5) {
                    Thread.sleep(180);
                    System.out.print("<<<<<<");
                    if (currentFrequency == fmStationFrequencies.get(0)) {

                        currentFrequency = fmStationFrequencies
                                .get(fmStations.getFmRadioStation().size() - 1);
                        setCurrentFrequency(currentFrequency);
                        play();
                        return currentFrequency;

                    } else if (j == fmStationFrequencies.get(i - 1)) {
                        currentFrequency = j;
                        setCurrentFrequency(currentFrequency);
                        play();
                        return currentFrequency;
                    }
                }
            }
        }
        return currentFrequency;
    }

    @Override
    protected List<RadioStation> getRadioStations() {
        UsaFmBandwidth fmStations = UsaFmBandwidth.getInstance();
        return fmStations.getFmRadioStation();
    }

    @Override
    protected void getStations() {
        List<RadioStation> stations = getRadioStations();
        String stationList = "\nAvailable USA FM stations";
        for (RadioStation radioStation : stations){
            stationList += "\n" + radioStation.getName() +
            " -- " + radioStation.getFrequency();
        }
        System.out.println(stationList);
    }

    public boolean listAvailableStations() {
        String answer = getUserAns();
        return answer.equalsIgnoreCase("y");
    }

    private String getUserAns() {
        String ans = null;
        System.out.println("\nView available FM USA stations? y/n");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try{
            ans=in.readLine();
        }catch (Exception e){
            System.err.println("Error! :) ");
        }

        if(ans == null){
            return "no";
        }

        return ans;
    }

}


