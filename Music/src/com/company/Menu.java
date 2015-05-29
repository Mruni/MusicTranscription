package com.company;

import jm.audio.AOException;
import com.echonest.api.v4.EchoNestException;

import java.io.IOException;

/**
 * Created by ����� on 25.04.2015.
 */
public class Menu
{
    int recordNo = 4;
    int notesAmount = 8; // should be 0 for the beginning
    MidiConverter midiConverter;
    Record record;

    public void recordMusic ()
    {
        Record record = new Record();
        record.recordMusic();
    }

    public void recognizeMono ()
    {
        record = new Record();
        midiConverter = new MidiConverter();
        try {
            midiConverter.recognition();
        } catch (AOException | EchoNestException | IOException e) {
            e.printStackTrace();
        }
        midiConverter.musicTranscription(recordNo);
    }

    public void saveRecordedFile ()
    {
        record = new Record();
        record.saveRecord(recordNo);
    }

    public void sendEmail ()
    {
        String email;

    }

    public void playMusicFile ()
    {
        midiConverter = new MidiConverter();
        midiConverter.playMusicFile();
    }
}
