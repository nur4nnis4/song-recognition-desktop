package Fingerprints;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import javax.sound.sampled.UnsupportedAudioFileException;
import models.SongFingerprints;


public class ExtractFingerprint {
    private static final int UPPER_LIMIT=300;
    private static final int LOWER_LIMIT=40;
    private static final int FRAME_SIZE=1024; // freq bin resoluton = Samplerate/Frame_size = 8000/1024 = 7.8125 
    private static final int OVERLAP = 512; // time resolution = (Frame_size-Overlap) / Samplerate = (1024-512)/8000 = 0.064s
    private static final int DEFAULT_APM_MIN = 10;
    
   static ArrayList<int[]> getPeakFrequencies(Complex[][] spectogram) throws UnsupportedAudioFileException, IOException{
       ArrayList<int[]> results = new ArrayList<>();
       
       for(int time =0; time<spectogram.length;time++){
            double[] highMag = new double[]{0,0,0,0};
            double[] minMag = new double[]{100,100,100,100};
            int[] recordPoints = new int[RANGE.length];
            
            for (int freq = LOWER_LIMIT; freq < UPPER_LIMIT+1; freq++) {
                //Get the magnitude: 
                
                double mag =10*Math.log10(spectogram[time][freq].abs()+1);
        
                //Find out which range we are in 
                int index = getIndex(freq);
                
                //Save the highest magnitude and corresponding frequency 
                if (mag >= highMag[index]) {
                    highMag[index] = mag;
                    recordPoints[index] = freq;
                }  
                if (mag < minMag[index]) {
                    minMag[index] = mag;
                }  
            }

            for(int i=0;i<RANGE.length;i++){
                
                if(highMag[i]>DEFAULT_APM_MIN&&highMag[i]>minMag[i]){
                    int[] row = new int[]{time,recordPoints[i]};
                    results.add(row);
                }
            }
                        
        }
       return results;
    }
   
   //for query song
   public ArrayList<SongFingerprints> getFingerPrint(File audio) throws UnsupportedAudioFileException, IOException{
        short[] sampleAmplitudes = WavUtil.getSampleAmplitudes(audio);
        Complex[][] spectrogram = STFT.stft(sampleAmplitudes, FRAME_SIZE, OVERLAP);
        
        ArrayList<SongFingerprints> fingerPrints = new ArrayList<>();  
        ArrayList<int[]> peakFrequencies = getPeakFrequencies(spectrogram); // peakFrequencies = [time,frequency]
        
        for(int i = 0; i<peakFrequencies.size()-7;i++){            
            String hash,value;            
            // 1 target zone = 3 points, anchor point is 5 points before the target zone 
            for (int j=5;j<8;j++){ 
                
                int[] anchor = peakFrequencies.get(i);
                int[] point = peakFrequencies.get(i+j);
                
                // hash = 10000000 * frequency of the anchor + 10000 * frequency of the point + delta time of the anchor and the point
                hash = Integer.toString(generateHash(anchor[1], point[1], (point[0]-anchor[0])));
                value = Integer.toString(anchor[0]);
                
                SongFingerprints temp =  new SongFingerprints(hash,value);                
                fingerPrints.add(temp);
            }
        }                       
        return fingerPrints;
    }

  // for reference songs
   public ArrayList<SongFingerprints> getFingerPrint(File audio,int audioId) throws UnsupportedAudioFileException, IOException{
        short[] sampleAmplitudes = WavUtil.getSampleAmplitudes(WavUtil.to16bit8kHzMonoByte(audio));
        Complex[][] spectrogram = STFT.stft(sampleAmplitudes, FRAME_SIZE, OVERLAP);
        
        ArrayList<SongFingerprints> fingerPrints = new ArrayList<>();  
        ArrayList<int[]> peakFrequencies = getPeakFrequencies(spectrogram); // peakFrequencies = [time,frequency]
        
        for(int i = 0; i<peakFrequencies.size()-7;i++){            
            String hash,value;            
            // 1 target zone = 3 points, anchor point is 5 points before the target zone 
            for (int j=5;j<8;j++){ 
                
                int[] anchor = peakFrequencies.get(i);
                int[] point = peakFrequencies.get(i+j);
                
                // hash = 10000000 * frequency of the anchor + 1000 * frequency of the point + delta time of the anchor and the point
                hash = Integer.toString(generateHash(anchor[1], point[1], (point[0]-anchor[0])));
                value = Integer.toString(10000*audioId+anchor[0]);
                
                SongFingerprints temp =  new SongFingerprints(hash,value);
                fingerPrints.add(temp);
            }
        }                       
        return fingerPrints;
    }
   
    private int generateHash(int p1, int p2, int p3) {
        int hash = p1 * 1000000 + p2 * 1000 + p3;
        return hash;
    }
   
    
    public static final int[] RANGE = new int[] {80,120,180, UPPER_LIMIT};

    //Find out in which range 
    public static int getIndex(int freq) {
        int i = 0;
        while(RANGE[i] < freq)
            i++;
        return i;        
    }
}
