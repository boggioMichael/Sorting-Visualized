package mediaManagement;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

import sortVisualization.RandArrayManager;

//SOUND HELPER SINGLETONE.
public class SoundHelper {

	private static final int MAX_VOLUME = 100;
	private Synthesizer synthesizer;
    
    private MidiChannel channel; 
    
    public static SoundHelper soundManager = new SoundHelper();
    
    private static final int SOUND_MAX = 70;
    
    private SoundHelper()
    {

		try {
			
	    	this.synthesizer = MidiSystem.getSynthesizer();
	    	this.channel = synthesizer.getChannels()[0];
	    	this.synthesizer.open();
	    	
		} catch (MidiUnavailableException e1) {
			e1.printStackTrace();
		}
    }
    
	public void makeSound(int elementHeight)
	{
		
		//the last one will not be turned of! and it's fine..
		this.channel.allNotesOff();
		
	    this.channel.noteOn(elementHeight * SoundHelper.SOUND_MAX / RandArrayManager.MAX_HEIGHT, 
	        		SoundHelper.MAX_VOLUME);
	}
	
	public void close()
	{
		this.synthesizer.close();
	}
}
