/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fingerprints;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import models.SongFingerprints;

/**
 *
 * @author nur4nnis4@gmail.com
 */
public class FingerprintMatching {
    public static int querySize=0;
    static int RECORD_SAMPLE_NUM ;
    
    public static void search(ArrayList<SongFingerprints> x, ArrayList<SongFingerprints> x2){
        System.out.println("x2 size : "+x2.size());
        System.out.println("x size : "+x.size());
        querySize = x2.size();
                
        LinkedHashMap<String, List<String>> mapFullSong = new LinkedHashMap<>();
        for(SongFingerprints xItem : x){
            mapFullSong.computeIfAbsent(xItem.getHash(), k -> new ArrayList<>()).add(xItem.getValue());
        }
        
        LinkedHashMap<String, List<String>> mapRecord = new LinkedHashMap<>();
        for (SongFingerprints x2Item : x2){
            mapRecord.computeIfAbsent(x2Item.getHash(), k -> new ArrayList<>()).add(x2Item.getValue());
        }        
        System.out.println("Map Record before : "+mapRecord.size());
        LinkedHashMap<String, List<String>> map2 = new LinkedHashMap<>();
        
        Iterator it = mapRecord.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,List<String>> mapRecordPair = (Map.Entry) it.next();
            if(mapFullSong.containsKey(mapRecordPair.getKey())){
                for(String value: mapFullSong.get(mapRecordPair.getKey())){                   
                    map2.computeIfAbsent(mapRecordPair.getKey(), k -> new ArrayList<>()).add(value);                     
                }
            }        
            else
                it.remove();            
        }          
        mapFullSong.clear();
        System.out.println("Map Record after : "+mapRecord.size());
        checkTimeCoherency(mapRecord, map2);        
        
    }
    private static void checkTimeCoherency(LinkedHashMap<String,List<String>> record, LinkedHashMap<String,List<String>> fullSong){
        
        LinkedHashMap<Integer,List<Integer>> listOfDelta = new LinkedHashMap<>();
        Iterator it = record.entrySet().iterator();
        int[] maxDeltaOccurrence = {0,0};
        while(it.hasNext()){
            Map.Entry<String,List<String>> pair = (Map.Entry) it.next();
            if(fullSong.containsKey(pair.getKey())){
               for(String recordValue:pair.getValue()){
                   for(String fullSongValue:fullSong.get(pair.getKey())){
                       int songId = Integer.parseInt(fullSongValue)/10000;
                       int fullSongAnchorTime = Integer.parseInt(fullSongValue)%10000;
                       int recordAnchorTime = Integer.parseInt(recordValue);
                       
                       //delta = Absolute time of the anchor in the record - Absolute time of the Anchor in the full song
                       int delta = Math.abs(recordAnchorTime-fullSongAnchorTime);                        
                       listOfDelta.computeIfAbsent(delta,k -> new ArrayList<>()).add(songId);
                       
                       if(maxDeltaOccurrence[0]<listOfDelta.get(delta).size()){
                           maxDeltaOccurrence[0] = listOfDelta.get(delta).size();
                           maxDeltaOccurrence[1] = delta;
                       }                       
                   }
               }
            }
                    
        }          
        
        double offset = Math.ceil(maxDeltaOccurrence[1]*0.064);//0.064s is time resolution
        int offsetMin =(int) offset/60;
        int offsetSec =(int) offset%60;
        
        System.out.println("Offset : "+String.format("%02d", offsetMin)+":"+String.format("%02d", offsetSec));        
        
        
        record.clear();
        fullSong.clear();
        LinkedHashMap<Integer,List<Integer>> songIdMap = new LinkedHashMap<>();
        int maxSongId[]={0,0};
        try{
            for(int songId: listOfDelta.get(maxDeltaOccurrence[1])){
            songIdMap.computeIfAbsent(songId,k -> new ArrayList<>()).add(maxDeltaOccurrence[0]);
            if(maxSongId[0]<songIdMap.get(songId).size()){
                maxSongId[0] = songIdMap.get(songId).size();
                maxSongId[1] = songId; 
            }
        }            
        }catch(NullPointerException e){
            
        }
        double precision = maxSongId[0]*100/querySize; 
        System.out.println("NHits :"+precision+"% | Song id :"+maxSongId[1]);
    } 
   
}
