/**
 * Created by rosudrag-pc on 11/1/2014.
 */
import org.jfugue.*;

public class TestPlayer {

    public static void main(String[] args)
    {
        Player player = new Player();

        Pattern song = new Pattern();

        Note aNote = new Note(Note.PARALLEL, 1.0);
        Note bNote = new Note(Note.LOW_TOM, 2.0);
        Note cNote = new Note(Note.HAND_CLAP, 1.0);

        String[] notes = Note.NOTES;

        String musicString = aNote.getMusicString() + " " +  bNote.getMusicString() + " " + cNote.getMusicString() + "+" + cNote.getMusicString();

        player.play(musicString);

        //song.add(new Pattern("V0 I[ECHOES] B V1 I[GUITAR] C"));

        /*// "Frere Jacques"
        Pattern pattern1 = new Pattern("C5q D5q E5q C5q");

        // "Dormez-vous?"
        Pattern pattern2 = new Pattern("E5q F5q G5h");

        // "Sonnez les matines"
        Pattern pattern3 = new Pattern("G5i A5i G5i F5i E5q C5q");

        // "Ding ding dong"
        Pattern pattern4 = new Pattern("C5q G4q C5h");

        // Put it all together
        Pattern song = new Pattern();
        song.add(pattern1);
        song.add(pattern1);
        song.add(pattern2);
        song.add(pattern2);
        song.add(pattern3);
        song.add(pattern3);
        song.add(pattern4);
        song.add(pattern4);*/

        // Play the song!
        player.play(song);

        System.exit(0);
    }
}
