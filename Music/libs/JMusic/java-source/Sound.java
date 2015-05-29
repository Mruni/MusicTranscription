
/**
 * Class that represents a sound.  This class is used by the students
 * to extend the capabilities of SimpleSound. 
 * 
 * @author Barbara Ericson
 */
public class Sound extends SimpleSound
{
  
  /////////////// consructors ////////////////////////////////////
  
  /**
   * Constructor that takes a file name
   * @param fileName the name of the file to read the sound from
   */
  public Sound(String fileName)
  {
    // let the parent class handle setting the file name
    super(fileName);
  }
  
  /**
   * Constructor that takes the number of seconds that this
   * sound will have
   * @param numSeconds the number of seconds desired
   */
  public Sound (int numSeconds)
  {
    // let the parent class handle this
    super(numSeconds);
  }
  
  /**
   * Constructor that makes a copy of the passed sound
   * @param copySound the sound to copy
   */
  public Sound(Sound copySound)
  {
    super(copySound);
  }
  
  ////////////////// methods ////////////////////////////////////
  
  /**
   * Method to return the string representation of this sound
   * @return a string with information about this sound
   */
  public String toString()
  {
    String output = "Sound";
    String fileName = getFileName();
    
    // if there is a file name then add that to the output
    if (fileName != null)
      output = output + " file: " + fileName;
    
    // add the length in frames
    output = output + " number of samples: " + getLengthInFrames();
    
    return output;
  }
     
  /**
   * Increase the volume of a sound
   */
  public void increaseVolume(double factor){
    SoundSample [] samples = this.getSamples();
    SoundSample current = null;
    
    for (int i=0; i < samples.length; i++) {
      current = samples[i];
      current.setValue((int) (factor * current.getValue()));
    }
  }

  /**
   * Method to reverse a sound.
   */
  public Sound reverse()
  {
    Sound target = new Sound(getLength());
    int sampleValue;
    
    for (int srcIndex=0,trgIndex=getLength()-1;
         srcIndex < getLength();
         srcIndex++,trgIndex--)
    {
      sampleValue = this.getSampleValueAt(srcIndex);
      target.setSampleValueAt(trgIndex,sampleValue);
    };
    return target;
  }
  
  
  /**
   * Return this sound appended with the input sound
   * @param appendSound sound to append to this
   */
  public Sound append(Sound appendSound) {
    Sound target = new Sound(getLength()+appendSound.getLength());
    int sampleValue;
    
    // Copy this sound in
    for (int srcIndex=0,trgIndex=0;
         srcIndex < getLength();
         srcIndex++,trgIndex++)
    {
      sampleValue = this.getSampleValueAt(srcIndex);
      target.setSampleValueAt(trgIndex,sampleValue);
    };
    
    // Copy appendSound in to target
    for (int srcIndex=0,trgIndex=getLength();
         srcIndex < appendSound.getLength();
         srcIndex++,trgIndex++)
    {
      sampleValue = appendSound.getSampleValueAt(srcIndex);
      target.setSampleValueAt(trgIndex,sampleValue);
    };

    return target;
  }
  
  /**
   * Mix the input sound with this sound, with percent 
   * ratio of input.
   * Use mixIn sound up to length of this sound.
   * Return mixed sound.
   * @param mixIn sound to mix in
   * @param ratio how much of input mixIn to mix in
   */
  public Sound mix(Sound mixIn, double ratio){
        Sound target = new Sound(getLength());
        
        int sampleValue, mixValue,newValue;
    
        // Copy this sound in
        for (int srcIndex=0,trgIndex=0;
             srcIndex < getLength() && 
             srcIndex < mixIn.getLength();
             srcIndex++,trgIndex++)
        {
          sampleValue = this.getSampleValueAt(srcIndex);
          mixValue = mixIn.getSampleValueAt(srcIndex);
          newValue = (int)(ratio*mixValue) + 
            (int)((1.0-ratio)*sampleValue);
          target.setSampleValueAt(trgIndex,newValue);
        };
        return target;
  }
    
  /**
   * Scale up or down a sound by the given factor
   * (1.0 returns the same, 2.0 doubles the length, 
   * and 0.5 halves the length)
   * @param factor ratio to increase or decrease
   */
  public Sound scale(double factor){
        Sound target = 
          new Sound((int) (factor * (1 + getLength())));
        int sampleValue;
    
        // Copy this sound in
        for (double srcIndex=0.0,trgIndex=0;
             srcIndex < getLength();
             srcIndex+=(1/factor),trgIndex++)
        {
          sampleValue = this.getSampleValueAt((int)srcIndex);
          target.setSampleValueAt((int) trgIndex,sampleValue);
        };
        return target;
  }
  
  /**
   * Insert the input Sound after the specified start
   * Modifies the given sound
   * @param inSound Sound to insert
   * @param start index where to start inserting the new sound
   */
  public void insertAfter(Sound inSound, int start) {
    
    SoundSample current=null;
    
    // Find how long inSound is
    int amtToCopy = inSound.getLength();
    int endOfThis = this.getLength()-1;
    
    if (start + amtToCopy - 1 > endOfThis) {
      // If too long, copy only as much as will fit
      amtToCopy = endOfThis-start+1;
    }
    else {
      // If short enough, need to clear out room.
      // Copy from endOfThis-amtToCopy+1;, moving backwards 
      // (toward front of list) to start,
      // moving UP (toward back) to endOfThis
      // KEY INSIGHT: How much gets lost off the end of the
      // array?  Same size as what we're inserting -- amtToCopy
      for (int source=endOfThis-amtToCopy; 
           source >= start ; 
           source--) {
        // current is the TARGET -- where we're copying to
        current = this.getSample(source+amtToCopy);
        current.setValue(this.getSampleValueAt(source));
      }
    }
        
    // NOW, copy in inSound up to amtToCopy
    for (int target=start,source=0; 
         source < amtToCopy; 
         target++, source++) {
      current = this.getSample(target);
      current.setValue(inSound.getSampleValueAt(source));
    }
  }
  
  /**
   * Delete from start to end in this sound
   * @param start where to start deletion
   * @param end where to stop deletion
   */
  public void delete(int start, int end){
    
    int value = 0;
    
    // Basically, we simply copy from "end" to getLength back to start
    for (int source=end, target=start;
         source < this.getLength();
         source++, target++)
    {value = this.getSampleValueAt(source);
      this.setSampleValueAt(target,value);}
    
    // Then clear out the rest. Gap is end-start+1 in length
    int gap = end-start+1;
    for (int i=1; i <= gap ; i++) {
      this.setSampleValueAt(this.getLength()-i,0);}
  }
  
  /**
   * Return part of a sound
   * @param start where to start returning
   * @param end where to end returning
   */
    public Sound portion(int start, int end){
    
      Sound retSound=new Sound((end-start)+1);
      int value = 0;
    
      // Basically, we simply copy from start to end into portion
      for (int source=start, target=0;
           source <= end;
           source++, target++)
      {value = this.getSampleValueAt(source);
        retSound.setSampleValueAt(target,value);}
    
      return retSound;
    }

  
} // end of class Sound put all new methods before this last curly brace