package template;

import singleton.UsaLwBandwidth;
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
public class LWUsaRadioPlayer extends UsaRadio {

    private List<Double> lwStationFrequencies;

    @Override
    protected void doRadioOperations() throws InterruptedException {
        boolean isValid = true;
        String choice = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (isValid){
            System.out.println("\n<tuneUp> <tuneDown> <off>");
            try{
                choice=in.readLine();
            }catch (Exception e){
                System.err.println("Error");
            }

            if(choice.equalsIgnoreCase("tuneUp")){
                next(getCurrentFrequency());
            } else if(choice.equalsIgnoreCase("tuneDown")){
                previous(getCurrentFrequency());
            }else if(choice.equalsIgnoreCase("off")){
                isValid = false;
            }
        }
    }

    @Override
    public double next(double currentFrequency) throws InterruptedException {
        final double FREQUENCY_HIGH = 255.0;

        UsaLwBandwidth lwStations = UsaLwBandwidth.getInstance();

        if (lwStationFrequencies == null) {
            lwStationFrequencies = new ArrayList<>();
            lwStationFrequencies.addAll(lwStations.getLwRadioStation().stream()
                    .map(RadioStation::getFrequency).collect(Collectors.toList()));
        }

        for (int i = 0; i <= lwStationFrequencies.size(); i++) {

            if (lwStationFrequencies.get(i) == currentFrequency) {

                for (double j = currentFrequency; j < FREQUENCY_HIGH; j++) {
                    Thread.sleep(80);
                    System.out.print(">>>");
                    if (currentFrequency == lwStationFrequencies
                            .get(lwStations.getLwRadioStation().size() - 1)) {

                        currentFrequency = lwStationFrequencies.get(0);
                        setCurrentFrequency(currentFrequency);
                        play();
                        return currentFrequency;

                    } else if (j == lwStationFrequencies.get(i + 1)) {
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

    private double previous(double currentFrequency) throws InterruptedException {
        final double FREQUENCY_LOW = 194;

        UsaLwBandwidth lwStations = UsaLwBandwidth.getInstance();

        if (lwStationFrequencies == null) {
            lwStationFrequencies = new ArrayList<>();
            lwStationFrequencies.addAll(lwStations.getLwRadioStation().stream()
                    .map(RadioStation::getFrequency).collect(Collectors.toList()));
        }

        for (int i = lwStationFrequencies.size() - 1; i >= 0; i--) {

            if (lwStationFrequencies.get(i) == currentFrequency) {

                for (double j = currentFrequency; j > FREQUENCY_LOW; j--) {
                    Thread.sleep(80);
                    System.out.print("<<<");
                    if (currentFrequency == lwStationFrequencies.get(0)) {
                        currentFrequency = lwStationFrequencies
                                .get(lwStations.getLwRadioStation().size() - 1);
                        setCurrentFrequency(currentFrequency);
                        play();
                        return currentFrequency;

                    } else if (j == lwStationFrequencies.get(i - 1)) {
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
        UsaLwBandwidth lwStations = UsaLwBandwidth.getInstance();
        return lwStations.getLwRadioStation();
    }

    @Override
    protected void getStations() {
        List<RadioStation> stations = getRadioStations();
        String stationList = "\nAvailable USA LW stations";
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

        System.out.println("\nView available LW USA stations? y/n");
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
