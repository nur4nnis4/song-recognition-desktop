package controllers;

import Fingerprints.ExtractFingerprint;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JTable;
import javazoom.jl.converter.Converter;
import models.SongCatalog;
import models.SongCatalogDAOImpl;
import models.SongFingerprintsDAOImpl;

public class MainController {
    
    View view;
    private String tempFilesAbsolutePath = "E:\\Musics\\Temp Files\\";
    SongCatalogDAOImpl songCatalogDAOI;
    SongFingerprintsDAOImpl songFingerprintsDAOI;
    SongCatalog songCatalog;
    String convertedFilePath;
    
    public MainController(View view){
        songCatalogDAOI = new SongCatalogDAOImpl();
        songFingerprintsDAOI = new SongFingerprintsDAOImpl();
        songCatalog =  new SongCatalog();
        this.view = view;
    }   
    
    public void startInsert(int insert,int approve,File[] files){
       
        if(insert==approve){
            SwingWorker worker = new SwingWorker() {
                @Override
                public Object construct() {                      
                    int numberOfFiles = files.length;
                    
                    for(int i =0; i<numberOfFiles;i++){ 
                        songCatalog.setSongTitle(files[i].getName().replaceFirst("[.][^.]+$", ""));
                        
                        if(!checkSongDuplicate(songCatalog.getSongTitle())){
                            try {
                                view.updateProcessStatusTA("Inserting "+songCatalog.getSongTitle()+"...");
                                File wavFile = convertMp3(files[i],songCatalog.getSongTitle());
                                songCatalogDAOI.insert(songCatalog);
                                ExtractFingerprint efp = new ExtractFingerprint();
                                songFingerprintsDAOI.insert(efp.getFingerPrint(wavFile, songCatalog.getSongId()),songCatalog.getSongId());
                                deleteTempFile();                                
                                view.updateProcessStatusTA("insert done!\n");
                                
                            } catch (UnsupportedAudioFileException | IOException ex) {
                                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                        else
                            view.updateProcessStatusTA(songCatalog.getSongTitle()+ " already exists !");
                        
                        view.refreshTable();        
                    }
                                       
                    return new Object();
                }               
                @Override
                public void finished(){
                    view.browseBtnSetEnabled(Boolean.TRUE);
                }
            };            
            worker.start();
        }
        else{
            view.browseBtnSetEnabled(Boolean.TRUE);
        }
        
        
    } 
    public void startDelete(JTable catalogTable,int[] tableRows){     
        int[] songIds = new int[tableRows.length];
        for(int i =0 ; i<tableRows.length; i++){            
            songIds[i] = Integer.parseInt(catalogTable.getValueAt(tableRows[i], 0).toString());
        } 
        view.updateProcessStatusTA("Deleting from database...");
        songCatalogDAOI.delete(songIds);
        new SongFingerprintController().delete(songIds);
        view.updateProcessStatusTA("Delete done!\n");
        view.refreshTable();
    }
       
    private boolean checkSongDuplicate(String songTitle){
        List resultList = songCatalogDAOI.select(songTitle);
        boolean duplicateFound = false;
        if (resultList.size()>0){
            duplicateFound = true;
        }
        return duplicateFound;
    }
    
    private void deleteTempFile(){
        File file = new File(convertedFilePath);
        file.delete();
    }
    private File convertMp3(File selectedFile,String songTitle){
        
        if(selectedFile.getName().toLowerCase().endsWith(".mp3")){
            try{
                Converter myConverter = new Converter();
                convertedFilePath = tempFilesAbsolutePath+songTitle+".wav";
                myConverter.convert(selectedFile.getPath(),convertedFilePath);   
                File convertedFile = new File(convertedFilePath);
                return convertedFile;    
            }catch(Exception e){
                view.showOptionPaneErrorDialog("Conversion Process Failed");
            }
        }
        else 
            view.showOptionPaneErrorDialog(selectedFile.getName()+"\nis not an MP3 File");
        return null;    
    }
    
    public interface View{
        void refreshTable();
        void browseBtnSetEnabled(Boolean enable);
        void updateProcessStatusTA(final String processStatusTAText);
        void showOptionPaneErrorDialog(String message);
    }
}
