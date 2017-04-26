import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import java.io.*;
import java.util.concurrent.TimeUnit;

import sun.audio.*;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;

public class SoundTest {

	public static void main(String[] args) throws Exception {
		long time;
		
		// gets the system's default sequencer device
		//System.out.println("DEBUG: getting default sequencer");
		//time = System.nanoTime();
		Sequencer sequencer = MidiSystem.getSequencer();
		//System.out.println("DEBUG: default sequencer got in " + (System.nanoTime()-time) + " units");
		
		// opens the default sequencer
		//System.out.println("DEBUG: opening sequencer");
		//time = System.nanoTime();
		sequencer.open();
		//System.out.println("DEBUG: sequencer open in " + (System.nanoTime()-time) + " units");
		
	    // create a stream from a file
		//System.out.println("DEBUG: creating input stream from midi file");
		//time = System.nanoTime();
	    InputStream is = new BufferedInputStream(new FileInputStream(new File("res/Fto55.mid")));
	    //System.out.println("DEBUG: input stream created in " + (System.nanoTime()-time) + " units");
	    
	    // sets the sequencer to use the inputstream
	    // The stream must point to MIDI file data.
	    //System.out.println("DEBUG: setting sequencer");
		//time = System.nanoTime();
	    sequencer.setSequence(is);
	    //System.out.println("DEBUG: sequencer set in " + (System.nanoTime()-time) + " units");

	    // starts playback of the MIDI in the currently loaded sequence.
	    //System.out.println("DEBUG: starting sequencer");
		//time = System.nanoTime();
	    sequencer.start();
	    //System.out.println("DEBUG: sequencer started in " + (System.nanoTime()-time) + " units");
	    // this is when the midi begins playing
	    
	    System.out.println("beep beep i'm asleep");
	    TimeUnit.SECONDS.sleep(15);
	    sequencer.stop();
	    
	    InputStream in = new FileInputStream("res/fly.wav");

	    // create an audiostream from the inputstream
	    AudioStream audioStream = new AudioStream(in);

	    // play the audio clip with the audioplayer class
	    AudioPlayer.player.start(audioStream);
	    TimeUnit.SECONDS.sleep(2);
	    in = new FileInputStream("res/cannon.wav");
	    audioStream = new AudioStream(in);
	    AudioPlayer.player.start(audioStream);
	    TimeUnit.SECONDS.sleep(1);
	    in = new FileInputStream("res/explod.wav");
	    audioStream = new AudioStream(in);
	    AudioPlayer.player.start(audioStream);
	    TimeUnit.SECONDS.sleep(1);
	    in = new FileInputStream("res/explod.wav");
	    audioStream = new AudioStream(in);
	    AudioPlayer.player.start(audioStream);
	    TimeUnit.SECONDS.sleep(1);
	    in = new FileInputStream("res/explod.wav");
	    audioStream = new AudioStream(in);
	    AudioPlayer.player.start(audioStream);
	}

}