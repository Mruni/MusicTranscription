package com.company;

//import be.tarsos.dsp.onsets.OnsetDetector;
import com.musicg.wave.Wave;
import com.musicg.wave.WaveFileManager;
import jm.JMC;
import jm.music.data.*;
import jm.util.*;
import jm.audio.AOException;
import jm.audio.AudioObject;
import com.echonest.api.v4.EchoNestAPI;
import com.echonest.api.v4.EchoNestException;
import com.echonest.api.v4.TimedEvent;
import com.echonest.api.v4.Track;
import com.echonest.api.v4.TrackAnalysis;
import java.io.File;
import java.io.IOException;
//import be.tarsos.dsp.onsets.ComplexOnsetDetector;
//import be.tarsos.dsp.onsets.OnsetHandler;

/**
 * Created by ����� on 25.04.2015.
 */
public class Recognizer implements JMC
{
    protected double [] frequencies;
    protected double [] durations;
    protected int [] barNo;
    protected float bar = 1F;
    protected int tempo;
    private static final String API_KEY ="IMIVKE8PR4NL8IDHE";
    private int barAmount = 0;
    private String input = "Mono 120.wav";

    public Recognizer ()
    {
        Menu menu = new Menu();
        frequencies = new double[menu.notesAmount];
        durations = new double[menu.notesAmount];
        durations[0] = 0.25;
        durations[1] = 0.25;
        durations[2] = 0.25;
        durations[3] = 0.25;
        durations[4] = 0.25;
        durations[5] = 0.25;
        durations[6] = 0.25;
        durations[7] = 0.25;
      /*  durations[8] = 0.25;
        durations[9] = 0.25;
        durations[10] = 0.25;
        durations[11] = 0.25;
        durations[12] = 0.25;
        durations[13] = 0.25;
        durations[14] = 0.25;
        durations[15] = 0.25;
        durations[16] = 0.25;
        durations[17] = 0.25;
        durations[18] = 0.25;
        durations[19] = 0.25;
        durations[20] = 0.25;
        durations[21] = 0.25;
        durations[22] = 0.25;
        durations[23] = 0.25;
        durations[24] = 0.25;
        durations[25] = 0.25;
        durations[26] = 0.25;
        durations[27] = 0.25;
        durations[28] = 0.25;
        durations[29] = 0.25;
        durations[30] = 0.25;
        durations[31] = 0.25;
        durations[32] = 0.25;
        durations[33] = 0.125;
        durations[34] = 0.375;
        durations[35] = 0.125;
        durations[36] = 0.125;
        durations[37] = 0.25;
        durations[38] = 0.125;
        durations[39] = 0.375;*/
    }

    public void recognition() throws AOException, EchoNestException, IOException {
        tempoAndBarTracking();
        fourierTransform();
    }

    public void fourierTransform () throws AOException, IOException
    {
        Menu menu = new Menu();
        /*float[] data = Read.audio("Sample Record 24.wav");
        int note = 0;
        for (int barNum = 0; barNum < barAmount; barNum++) // for all bars
        {
            for (int currentNote = 0; currentNote < menu.notesAmount / barAmount; currentNote++)
            {
                double[] dataDouble = new double[(int)((data.length / barAmount) * durations[barNum * (menu.notesAmount / barAmount) + currentNote + 1])];
                int i,k;
                int part = 0;
                for (i = barNum * (data.length / barAmount) + part , k = 0; part < (data.length / barAmount); i++, k++)
                {
                    dataDouble[k] = data[i];
                    part += (data.length / barAmount) * durations[barNum * (menu.notesAmount / barAmount) + currentNote + 1];
                }
                Transformation trans = new Transformation();
                frequencies[note] = trans.fourierTransform(dataDouble);
            }
        }*/

        // wav parts creation
/*        int note = 0;
        String path = "Sample Record 24.wav";
        Wave wave = new Wave(path);
        double duration = wave.length();
        int smallestDuration = 8; // should be 128
        double barDuration = duration / barAmount;
        double partDuration = duration / barAmount / smallestDuration;
        for (int barNum = 0; barNum < barAmount; barNum++) // for all bars
        {
            for (int currentPart = 0; currentPart < smallestDuration; currentPart++)
            {
                if (barNum == 0 && currentPart == 0)
                {
               //     wave.rightTrim(duration - (barAmount - barNum - 1) * barDuration - (smallestDuration - currentPart - 1) * partDuration);
                    wave.leftTrim(duration - barNum * barDuration - (currentPart + 1) * partDuration);
                }
                else if (barNum == barAmount - 1 && currentPart == smallestDuration - 1)
                {
                   // wave.leftTrim(barNum * barDuration + currentPart * partDuration);
                    wave.rightTrim(barNum * barDuration + (currentPart) * partDuration);
                }
                else
                {
                    wave.leftTrim(duration - barNum * barDuration - (currentPart + 1) * partDuration);
                    wave.rightTrim(barNum * barDuration + (currentPart) * partDuration);
                }
                WaveFileManager waveFileManager = new WaveFileManager(wave);
                waveFileManager.saveWaveAsFile("part.wav");
                float[] data = Read.audio("part.wav");
                double[] dataDouble = new double[data.length];
                int i;
                for (i = 0; i < data.length; i++)
                {
                    dataDouble[i] = data[i];
                }
                Transformation trans = new Transformation();
                frequencies[note] = trans.fourierTransform(dataDouble);
                if (note > 0)
                {
                    if (Math.abs(frequencies[note] - frequencies[note - 1]) > 2)
                    {
                        System.out.print(frequencies[note] + "\n");
                        note++;
                    }
                }
                else note++;
                System.out.print("Duration: \n" + wave.length() + "\n");
                wave = new Wave(path);
                System.out.print("Duration: \n" + wave.length() + "\n");
            }
            System.out.print("New bar: \n" + (barNum + 2) + "\n");
        }
*/



       // float[] data = Read.audio("out.wav");
     //  float[] data = Read.audio(input);

/*        int barPart = data.length / barAmount;
        for (int barNum = 0; barNum < barAmount; barNum++)  // for all bars
        {
            int smallestDuration = 8; // should be 128
            double[] dataDouble = new double[data.length / barAmount / smallestDuration];
            int part = data.length / barAmount / smallestDuration;
            for (int j = 0; j < smallestDuration; j++) {
                int k;
                int i;
                for (i = barNum * barPart + j * part, k = 0; i < (barNum * barPart + (j + 1) * part); i++, k++)
                {
                    dataDouble[k] = data[i];
                }
                Transformation trans = new Transformation();
                frequencies[j] = trans.fourierTransform(dataDouble);
                System.out.print(frequencies[j] + "\n");
            }
        }*/

        float[] data = Read.audio("Sample Record 20.wav");
        double[] dataDouble = new double[data.length / menu.notesAmount];
        int quarter = data.length / menu.notesAmount;
        for (int j=0; j < menu.notesAmount; j++)
        {
            int k;
            int i;
            for (i = j * quarter, k = 0; i < ((j + 1) * quarter); i++, k++)
            {
                dataDouble[k] = data[i];
            }
            Transformation trans = new Transformation();
            frequencies[j] = trans.fourierTransform(dataDouble);
            System.out.print(frequencies[j]+ "\n");
        }
    }

    private void tempoAndBarTracking () throws EchoNestException
    {
        EchoNestAPI en = new EchoNestAPI(API_KEY);

        String path = "Mono 120.wav";
        //String path = "Avalanche - Betrayal.mp3";
        //String path = input;
        File file = new File(path);

        if (!file.exists()) {
            System.err.println("Can't find " + path);
        } else {

            try {
                Track track = en.uploadTrack(file);
                track.waitForAnalysis(30000);
                if (track.getStatus() == Track.AnalysisStatus.COMPLETE)
                {
                    if (track.getTempo() >= 30 && track.getTempo() <= 240)
                    {
                        tempo = (int) track.getTempo();
                        if ((int) track.getTempo() % 10 == 9) tempo = (int) track.getTempo() + 1;
                        System.out.println("Real tempo: " + tempo);
                        System.out.println("Tempo: " + track.getTempo());
                        System.out.println("Duration: " + track.getDuration());
                  /*  System.out.println("Danceability: " + track.getDanceability());
                    System.out.println("Speechiness: " + track.getSpeechiness());
                    System.out.println("Liveness: " + track.getLiveness());
                    System.out.println("Energy: " + track.getEnergy());
                    System.out.println("Loudness: " + track.getLoudness());
                    System.out.println("Key: " + track.getKey());
                    System.out.println("Mode: " + track.getMode());
                    System.out.println("Time signature: " + track.getTimeSignature());
                    System.out.println();
                    System.out.println("Beat start times:");*/

                        System.out.println("Time Signature: " + track.getTimeSignature());
                        TrackAnalysis analysis = track.getAnalysis();
                        boolean isFirstBar = true;
                        double firstBar = 0;
                        double lastBar = 0;
                        for (TimedEvent bar : analysis.getBars())
                        {
                            if (isFirstBar)
                            {
                                if (bar.getStart() - 0.5 >= 0) firstBar = bar.getStart() - 0.5;
                                isFirstBar = false;
                            }
                            System.out.println("bar start " + bar.getStart());
                            System.out.println("bar duration " + bar.getDuration());
                            lastBar = bar.getStart() + bar.getDuration();
                            barAmount++;
                        }
                        System.out.println("Bar amount " + barAmount);
                        bar = (float) (track.getTimeSignature()) / 4;
                        System.out.println("Score " + bar);
                     //   trimming(path, (float) firstBar, (float) (track.getDuration() - lastBar));
                    }
                } else {
                    System.err.println("Trouble analysing track " + track.getStatus());
                }
            } catch (IOException e) {
                System.err.println("Trouble uploading file");
            }
        }
    }

    private void trimming(String filename, float leftPart, float rightPart) {
        System.out.println("Beginning " + leftPart);
        System.out.println("End " + rightPart);
        // create a wave object
        Wave wave = new Wave(filename);

        // print the wave header and info
        System.out.println(wave);

        // trim the wav
        if (leftPart != 0) wave.leftTrim(leftPart);
        if (rightPart != 0) wave.rightTrim(rightPart);

        // save the trimmed wav
        WaveFileManager waveFileManager = new WaveFileManager(wave);
        waveFileManager.saveWaveAsFile("out.wav");
    }

    private void durationDetection ()
    {

    }
}
