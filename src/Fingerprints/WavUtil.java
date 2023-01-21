package Fingerprints;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public final class WavUtil{
    
    public static byte[] getByteArray(File file) throws IOException, UnsupportedAudioFileException{    
        FileInputStream fis = new FileInputStream(file);   
        
        return getBytesFromInputStream(fis);       
    }
    public static byte[] getDataChunk(File file) throws IOException, UnsupportedAudioFileException{
        AudioInputStream ais = AudioSystem.getAudioInputStream(file);
        
        return getBytesFromInputStream(ais);       
    }
    
    public static byte[] getHeaderChunk(File file ) throws IOException, UnsupportedAudioFileException{
        byte[] dataChunk = new byte[44];
        byte[] wavByte = getByteArray(file);
        
        if(wavByte.length>=44){            
            System.arraycopy(wavByte, 0, dataChunk, 0, 44);
        }
        
        return dataChunk;
    }
    
    public static short[] getSampleAmplitudes(File file) throws IOException, UnsupportedAudioFileException{
        byte[] dataChunk = getDataChunk(file); 
        short[] amp= new short[(int) (dataChunk.length)/2]; 
        ByteBuffer.wrap(dataChunk).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(amp); 
        
        return amp;
    }
    
    public static short[] getSampleAmplitudes(byte[] wavByte) { 
        short[] amp= new short[wavByte.length/2]; 
        ByteBuffer.wrap(wavByte).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(amp); 
        
        return amp;
    }
    
    public static byte[] to16bitMonoByte(File file) throws UnsupportedAudioFileException, IOException{
        
        AudioInputStream ais = AudioSystem.getAudioInputStream(file);
        byte[] ret;
        AudioFormat targetFormat = new AudioFormat(44100, 16, 1, true, false);
        ais = AudioSystem.getAudioInputStream(targetFormat,ais);
        ret = getBytesFromInputStream(ais);       
        return ret;
    }
    public static byte[] to16bit11kHzMonoByte(File file) throws UnsupportedAudioFileException, IOException{
        
        AudioInputStream ais = AudioSystem.getAudioInputStream(file);
        byte[] ret;
        AudioFormat targetFormat = new AudioFormat(11025, 16, 1, true, false);
        ais = AudioSystem.getAudioInputStream(targetFormat,ais);
        ret = getBytesFromInputStream(ais);       
        return ret;
    }
    public static byte[] to16bit8kHzMonoByte(File file) throws UnsupportedAudioFileException, IOException{
        
        AudioInputStream ais = AudioSystem.getAudioInputStream(file);
        byte[] ret;
        AudioFormat targetFormat = new AudioFormat(8000, 16, 1, true, false);
        ais = AudioSystem.getAudioInputStream(targetFormat,ais);
        ret = getBytesFromInputStream(ais);       
        return ret;
    }
    public static File to16bitMono(File file) throws UnsupportedAudioFileException, IOException{
        File tempFile = File.createTempFile("temp",".wav", new File("E:\\Musics\\Temp Files"));
        AudioInputStream ais = AudioSystem.getAudioInputStream(file);
        AudioFormat targetFormat = new AudioFormat(44100, 16, 1, true, false);
        ais = AudioSystem.getAudioInputStream(targetFormat,ais);
        AudioSystem.write(ais, AudioFileFormat.Type.WAVE, tempFile);
        return tempFile;
    }
    public static File to16bit11kHzMono(File file) throws UnsupportedAudioFileException, IOException{
        
        File tempFile = File.createTempFile("temp",".wav", new File("E:\\Musics\\Temp Files"));
        AudioInputStream ais = AudioSystem.getAudioInputStream(file);
        AudioFormat targetFormat = new AudioFormat(11025, 16, 1, true, false);
        ais = AudioSystem.getAudioInputStream(targetFormat,ais);
        AudioSystem.write(ais, AudioFileFormat.Type.WAVE, tempFile);
        return tempFile;
    }
    
    public static byte[] getBytesFromInputStream(InputStream is)throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while(true){
            byte[] buffer = new byte[100];
            int noOfBytes = is.read(buffer);
            if(noOfBytes == -1 ){
                break;
            }else{
                bos.write(buffer,0,noOfBytes);
            }
        }
        bos.flush();
        bos.close();
        return bos.toByteArray();
    }    
}
