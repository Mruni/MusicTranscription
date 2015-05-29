package com.company;

//import javax.sound.midi.InvalidMidiDataException;
import java.io.File;
import java.io.IOException;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import static org.jfugue.theory.Note.getFrequencyForNote;
import static org.jfugue.theory.Note.getToneString;
import static org.jfugue.theory.Note.getDurationString;

/**
 * Created by Мунир on 25.04.2015.
 */
public class MidiConverter extends Recognizer
{

    //private int [] noteMidiValues;
    private String instrument;
    private String title;
    private String author;
    private String creationDate;
    private String musicString = "";
    public String musicPath = "";

    public MidiConverter ()
    {
        super();
        Menu menu = new Menu();
        //noteMidiValues = new int[menu.notesAmount];
    }

    public void musicTranscription (int recordNo) //throws IOException, InvalidMidiDataException
    {
        String barEnd = "| ";
        String currentNoteSymbol;
        String currentNoteDuration;
        float barSize = 0;
        for (int i=0; i < frequencies.length; i++)
        {
            int noteMidiValue = pitchMatcher(frequencies[i] * 2);
            //noteMidiValues[i] = noteMidiValue;
            currentNoteSymbol = getToneString((byte)noteMidiValue);
            System.out.println(currentNoteSymbol);
            currentNoteDuration = getDurationString(durations[i]);
            System.out.println(currentNoteDuration);
            musicString += currentNoteSymbol + currentNoteDuration + " ";
            barSize += durations[i];
            if (barSize == bar)
            {
                musicString += barEnd;
                barSize = 0;
                System.out.println(musicString);
            }
        }
//               try {
        createMidiFile(recordNo);

/*        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }*/

    }


/* Dichotomy method is used to find real pitch */

    private int pitchMatcher (double frequency)
    {
        int beginning = 0;
        int end = 127;
        int  middle = end/2;
        boolean isPitchFound = false;
        int result = 0;
        double pitch = getFrequencyForNote(beginning);
        if (frequency == pitch) result = beginning;
        else
        {
            while ((end - beginning != 1) && (!isPitchFound) && (end != middle))
            {
                pitch = getFrequencyForNote(middle);
                if (frequency == pitch)
                {
                    result = middle;
                    isPitchFound = true;
                }
                else if (frequency > pitch) {
                    beginning = middle;
                    middle = (beginning + end) / 2;
                }
                else if (frequency < pitch) {
                    end = middle;
                    middle = (beginning + end) / 2;
                }
            }
        }
        if (end - beginning == 1)
        {
            if (frequency - getFrequencyForNote(beginning) >= getFrequencyForNote(end) - frequency) result = end;
            else result = beginning;
        }
        return result;
    }

    private void createMidiFile (int recordNo) // throws IOException, InvalidMidiDataException
    {
        String midiFileNameBeginning = "New Midi ";
        String midiFileNameEnd = ".mid";
        Pattern pattern = new Pattern(musicString).setVoice(0).setInstrument("Piano").setTempo(tempo);
        try {
            MidiFileManager.savePatternToMidi(pattern, new File(musicPath + midiFileNameBeginning + Integer.toString(recordNo) + midiFileNameEnd));
        } catch (IOException e) {
            e.printStackTrace();
        }

/*        Pattern p1 = new Pattern("Eq Ch. | Eq Ch. | Dq Eq Dq Cq").setVoice(0).setInstrument("Piano");
        Pattern p2 = new Pattern("Rw     | Rw     | GmajQQQ  CmajQ").setVoice(1).setInstrument("Flute");
        Player player = new Player();
        player.play(p1, p2);
        p1.setTitle("Twinkle, Twinkle Little Star");
        p1.setProperty("Author", "unknown");
        p1.setProperty("Date Created", "May 8, 2008");
        p1.setProperty("Type", "nursery rhyme ");*/
        // MidiFileManager.savePatternToMidi(p1, new File("New Midi.mid"));
    }


    public void playMusicFile ()
    {
        Player player = new Player();
      //  Pattern pattern = new Pattern(musicString).setVoice(0).setInstrument("Piano");
        Pattern p1 = new Pattern("Eq Ch. | Eq Ch. | Dq Eq Dq Cq");
        player.play(p1);
    }
}
