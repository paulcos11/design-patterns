package strategy;

import singleton.FmBandwidth;
import singleton.RadioStation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * Created by Paul turnOnRadio 01/01/2016.
 */
public class NextFMStation implements NextStationSelector {

    private List<Double>fmStationFrequencies;

    public double tuneUp(double currentFrequency) throws InterruptedException {
        final double FREQUENCY_HIGH = 108.0;

        FmBandwidth fmStations = FmBandwidth.getFmStations();

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
                    if (currentFrequency == fmStationFrequencies.
                            get(fmStations.getFmRadioStation().size() - 1)) {

                        currentFrequency = fmStationFrequencies.get(0);
                        return currentFrequency;

                    } else if (j == fmStationFrequencies.get(i + 1)) {
                        currentFrequency = j;
                        return currentFrequency;
                    }
                }
            }
        }
        return currentFrequency;
    }
}
