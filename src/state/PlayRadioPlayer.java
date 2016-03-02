package state;

import command.DeviceSelector;
import command.MediaRemote;
import command.TurnOffIrishRadio;
import command.TurnOnIrishRadio;
import creationMethodUsaRadio.USARadioCreationMethod;
import creationMethodUsaRadio.USARadioStore;
import strategy.RadioPlayer;
import template.UsaRadio;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 *
 * Created by Paul on 19/01/2016.
 */
public class PlayRadioPlayer implements MediaCentreState{

    private final MediaCentre mediaCentre;

    public PlayRadioPlayer(MediaCentre mediaCentre){
        this.mediaCentre=mediaCentre;
    }


    @Override
    public void mediaCentreTurnOn() {
        System.out.println("Media centre on");
    }

    @Override
    public void mediaCentreTurnOff() {
        System.out.println("Media centre on");
    }

    @Override
    public void radioPlayerOn() throws Exception {
        System.out.println("\nRadio Player Selected");
        mediaCentre.mediaPlayerOption();
    }

    @Override
    public void radioPlayerOff() {
        System.out.println("\nRadio Player Off");
        mediaCentre.setMediaCentreState(mediaCentre.stopPlayingRadio());
    }

    @Override
    public void audioPlayerOn() {
        System.out.println("Radio Player ON");

    }

    @Override
    public void audioPlayerOff() {
        System.out.println("\nRadio Player Off");
    }

    @Override
    public void mediaOption() throws InterruptedException {
        String bandwidth = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\nEnter <fm> or <lw> for irish radio player" +
                "\t\t\t\t\t-->\t\t<command> <strategy> <observer> <isSingleton> <state>" +
                "\nEnter <fm usa> or <lw usa> for American radio player" +
                "\t\t-->\t\t<template method> <creation method> <observer> <isSingleton> <state>" +
                "\nEnter <exit> to quit");
        try{
            bandwidth=in.readLine();
        }catch (Exception e){
            System.err.println("Error!");
        }

        if (bandwidth.equalsIgnoreCase("fm") ||
                bandwidth.equalsIgnoreCase("lw")) {

            chooseIrishRadio(bandwidth);

        } else if (bandwidth.equalsIgnoreCase("fm usa") ||
                bandwidth.equalsIgnoreCase("lw usa")) {
            chooseUsaRadio(bandwidth);
        }

    }

    private  void chooseIrishRadio(String bandwidth) throws InterruptedException {
        RadioPlayer radioPlayer = MediaRemote.turnOnDevice(bandwidth);
        TurnOnIrishRadio turnRadioOn = new TurnOnIrishRadio(radioPlayer);
        DeviceSelector radioOnSelector = new DeviceSelector(turnRadioOn);
        radioOnSelector.select();
        radioPlayer.radioOperator(radioPlayer);

        radioPlayer = MediaRemote.turnOffDevice(radioPlayer);
        TurnOffIrishRadio turnRadioOff = new TurnOffIrishRadio(radioPlayer);
        DeviceSelector radioOff = new DeviceSelector(turnRadioOff);
        radioOff.select();
    }

    private  void chooseUsaRadio(String bandwidth) throws InterruptedException {
        double frequency;
        if (bandwidth.equals("fm usa")) {
            frequency = 88.0;
        } else {
            frequency = 252.0;
        }
        USARadioCreationMethod creationMethod = new USARadioCreationMethod();
        USARadioStore radioStore = new USARadioStore(creationMethod);
        UsaRadio radioPlayer = radioStore.deviceSelector(bandwidth);
        radioPlayer.templateMethod(frequency);
    }
}
