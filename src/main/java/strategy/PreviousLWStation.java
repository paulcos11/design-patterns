package strategy;

import singleton.LwBandwidth;
import singleton.RadioStation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Created by Paul turnOnRadio 01/01/2016.
 */
public class PreviousLWStation implements PreviousStationSelector {

    private List<Double> lwStationFrequencies;

    public double tuneDown(double currentFrequency) throws InterruptedException {

        final double FREQUENCY_LOW = 194;

        LwBandwidth lwStations = LwBandwidth.getInstance();

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

                        currentFrequency = lwStationFrequencies.
                                get(lwStations.getLwRadioStation().size() - 1);
                        return currentFrequency;

                    } else if (j == lwStationFrequencies.get(i - 1)) {
                        currentFrequency = j;
                        return currentFrequency;
                    }
                }
            }
        }
        return currentFrequency;
    }
}