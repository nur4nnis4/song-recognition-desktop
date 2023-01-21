/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import models.SongCatalog;
import models.SongCatalogDAOImpl;

/**
 *
 * @author nur4nnisa@gmail.com
 */
public class SongCatalogController {
    SongCatalog songCatalog = new SongCatalog();
    SongCatalogDAOImpl sCDAOImpl = new SongCatalogDAOImpl();    
    
    public void selectAll(JTable resultTable) {
        List resultList =sCDAOImpl.selectAll();            
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        
        tableHeaders.add("ID"); 
        tableHeaders.add("SINGER - TITLE");

        for(Object o : resultList) {
            SongCatalog actor = (SongCatalog)o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(actor.getSongId());
            oneRow.add(actor.getSongTitle());
            tableData.add(oneRow);
        }
        
        resultTable.setModel(new DefaultTableModel(tableData, tableHeaders));
        resultTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        resultTable.getColumnModel().getColumn(0).setMaxWidth(100);        
   
    }

    public void searchAll(String searchText,JTable resultTable) {
        List resultList =sCDAOImpl.searchAll(searchText);  
        
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        
        tableHeaders.add("ID"); 
        tableHeaders.add("SINGER - TITLE");

        for(Object o : resultList) {
            SongCatalog actor = (SongCatalog)o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(actor.getSongId());
            oneRow.add(actor.getSongTitle());
            tableData.add(oneRow);
        }
        
        resultTable.setModel(new DefaultTableModel(tableData, tableHeaders));
        resultTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        resultTable.getColumnModel().getColumn(0).setMaxWidth(100);
    }
    
}
