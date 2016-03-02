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
public class NextLWStation implements NextStationSelector {

    private List<Double> lwStationFrequencies;

    public double tuneUp(double currentFrequency) throws InterruptedException {

        final double FREQUENCY_HIGH = 255.0;

        LwBandwidth lwStations = LwBandwidth.getInstance();

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
                    if (currentFrequency == lwStationFrequencies.get(lwStations.
                            getLwRadioStation().size() - 1)) {

                        currentFrequency = lwStationFrequencies.get(0);
                        return currentFrequency;

                    } else if (j == lwStationFrequencies.get(i + 1)) {
                        currentFrequency = j;
                        return currentFrequency;
                    }
                }
            }
        }
        return currentFrequency;
    }
}