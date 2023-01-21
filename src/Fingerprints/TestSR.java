/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fingerprints;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.UnsupportedAudioFileException;
import models.SongFingerprints;

/**
 *
 * @author asus
 */
public class TestSR {
    
    public static String filePath = "E:\\Musics\\Temp Files\\Eddy 10 s.wav";    
    //public static String filePath="E:\\Musics\\Temp Files\\Son lux 10 s.wav";
    public static String filePath1 = "E:\\Musics\\Temp Files\\Son Lux - Lost It To Trying (Paper Towns Mix).wav";
    public static String filePath2 = "E:\\Musics\\Temp Files\\Eddy - Mu Bu Juan Jing.wav";
    
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, Exception{
        File file = new File(filePath);
        File file1 = new File(filePath2);
        ExtractFingerprint ef =  new ExtractFingerprint();
        
        ArrayList<SongFingerprints> x = ef.getFingerPrint(file);
        ArrayList<SongFingerprints> x1 = ef.getFingerPrint(file1,1);        
        
        FingerprintMatching fm = new FingerprintMatching();
        System.out.println("1.-----------");fm.search(x1, x);
    }
    public static void showPeak(ArrayList<SongFingerprints> x){
        for(int i =0 ; i<x.size();i++ )
            System.out.println(i +" --> "+ x.get(i).getHash());
    }
}
