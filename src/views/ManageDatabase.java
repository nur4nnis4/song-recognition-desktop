/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.MainController;
import controllers.SongCatalogController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
/**
 *
 * @author nur4nnis4@gmail.com
 */
public class ManageDatabase extends javax.swing.JInternalFrame implements MainController.View{

    JFileChooser jFileChooser ;
    File selectedFile;
    MainController mainController = new MainController(this);
    
    private final Color BUTTON_DEFAULT_COLOR = new Color(102,204,0);
    private final Color BUTTON_HOVER_COLOR = new Color(150,250,0);
    
    public ManageDatabase() {
        initComponents();
        
        new SongCatalogController().selectAll(catalogTable);
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        
        catalogTable.getTableHeader().setFont(new Font("Tahoma",Font.BOLD,16));
        catalogTable.getTableHeader().setForeground(new  Color(0,0,0));
        catalogTable.getTableHeader().setBorder(javax.swing.BorderFactory.createEmptyBorder());
        catalogTable.setShowVerticalLines(false);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        manageDBPanel = new javax.swing.JPanel();
        insertBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        searchET = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        catalogTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        processStatusTA = new java.awt.TextArea();
        clearBtn = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        manageDBPanel.setBackground(java.awt.SystemColor.controlHighlight);
        manageDBPanel.setPreferredSize(new java.awt.Dimension(880, 630));

        insertBtn.setBackground(new java.awt.Color(102, 204, 0));
        insertBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        insertBtn.setForeground(new java.awt.Color(255, 255, 255));
        insertBtn.setText("Insert");
        insertBtn.setBorder(null);
        insertBtn.setPreferredSize(new java.awt.Dimension(126, 41));
        insertBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                insertBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                insertBtnMouseExited(evt);
            }
        });
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(102, 204, 0));
        deleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete");
        deleteBtn.setBorder(null);
        deleteBtn.setPreferredSize(new java.awt.Dimension(126, 41));
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteBtnMouseExited(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        searchET.setBackground(new java.awt.Color(204, 204, 204));
        searchET.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        searchET.setToolTipText("");
        searchET.setBorder(null);
        searchET.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchETKeyReleased(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic_search_gray.png"))); // NOI18N
        jLabel6.setAlignmentX(0.5F);
        jLabel6.setPreferredSize(new java.awt.Dimension(34, 34));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchET, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchET)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        jScrollPane1.setBorder(null);

        catalogTable.setBackground(new java.awt.Color(229, 230, 229));
        catalogTable.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        catalogTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "SINGER - TITLE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        catalogTable.setAlignmentX(1.0F);
        catalogTable.setAlignmentY(1.0F);
        catalogTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        catalogTable.setGridColor(new java.awt.Color(204, 204, 204));
        catalogTable.setOpaque(false);
        catalogTable.setRowHeight(25);
        catalogTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(catalogTable);
        if (catalogTable.getColumnModel().getColumnCount() > 0) {
            catalogTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            catalogTable.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        processStatusTA.setBackground(new java.awt.Color(51, 51, 51));
        processStatusTA.setEditable(false);
        processStatusTA.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        processStatusTA.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.add(processStatusTA, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 300, 310));

        clearBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic_delete.png"))); // NOI18N
        clearBtn.setToolTipText("");
        clearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearBtnMouseClicked(evt);
            }
        });
        jPanel3.add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, -1));

        jPanel1.setBackground(new java.awt.Color(94, 188, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(880, 80));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic_managedb_white.png"))); // NOI18N
        jLabel1.setText("Manage Database");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(631, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout manageDBPanelLayout = new javax.swing.GroupLayout(manageDBPanel);
        manageDBPanel.setLayout(manageDBPanelLayout);
        manageDBPanelLayout.setHorizontalGroup(
            manageDBPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageDBPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(manageDBPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(manageDBPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(manageDBPanelLayout.createSequentialGroup()
                        .addComponent(insertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        manageDBPanelLayout.setVerticalGroup(
            manageDBPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manageDBPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(manageDBPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(manageDBPanelLayout.createSequentialGroup()
                        .addGroup(manageDBPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(insertBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(manageDBPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(manageDBPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
        insertBtn.setEnabled(false);
        jFileChooser = new JFileChooser("E:\\Musics\\Songs in Database");
        jFileChooser.setMultiSelectionEnabled(true);
        jFileChooser.setFileFilter(new TypeOfFile());
        jFileChooser.setDialogTitle("Select Songs");
        jFileChooser.setPreferredSize(new Dimension(600,500));
        int a=jFileChooser.showDialog(this, "Insert");
        mainController.startInsert(a, JFileChooser.APPROVE_OPTION, jFileChooser.getSelectedFiles());
    }//GEN-LAST:event_insertBtnActionPerformed

    private void clearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseClicked
        processStatusTA.setText("");
    }//GEN-LAST:event_clearBtnMouseClicked

    private void searchETKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchETKeyReleased
        String searchText = searchET.getText();
        new SongCatalogController().searchAll(searchText, catalogTable);           
    }//GEN-LAST:event_searchETKeyReleased

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
       int[] selectedRows = catalogTable.getSelectedRows();
       int confirm = JOptionPane.showOptionDialog(this,
               "Are you sure ?", 
               "Delete "+selectedRows.length+" Row(s)", 
               JOptionPane.YES_NO_OPTION, 
               JOptionPane.QUESTION_MESSAGE, null, null, null);
       
       if(confirm == JOptionPane.YES_OPTION){
           mainController.startDelete(catalogTable,selectedRows);
       }       
    }//GEN-LAST:event_deleteBtnMouseClicked

    private void insertBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertBtnMouseEntered
        insertBtn.setBackground(BUTTON_HOVER_COLOR);
    }//GEN-LAST:event_insertBtnMouseEntered

    private void insertBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertBtnMouseExited
        insertBtn.setBackground(BUTTON_DEFAULT_COLOR);
    }//GEN-LAST:event_insertBtnMouseExited

    private void deleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseEntered
        deleteBtn.setBackground(BUTTON_HOVER_COLOR);
    }//GEN-LAST:event_deleteBtnMouseEntered

    private void deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseExited
        deleteBtn.setBackground(BUTTON_DEFAULT_COLOR);
    }//GEN-LAST:event_deleteBtnMouseExited

    @Override
    public void updateProcessStatusTA(final String processStatusTAText){
        Runnable doSetProcessStatusValue = () -> {
            processStatusTA.append(" "+processStatusTAText+"\n");
        };
        SwingUtilities.invokeLater(doSetProcessStatusValue);
    }
    @Override
    public void browseBtnSetEnabled(Boolean enable){
        insertBtn.setEnabled(enable);
    }
    
    @Override
    public void showOptionPaneErrorDialog(String message){
        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void refreshTable() {
        new SongCatalogController().selectAll(catalogTable);
    }
    
    class TypeOfFile extends FileFilter
    {
        @Override
        public boolean accept(File f)
        {
            return f.getName().toLowerCase().endsWith(".mp3")||f.isDirectory();
        }
        //Set description for the type of file that should be displayed
        public String getDescription()
        {
            return ".mp3 files";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable catalogTable;
    private javax.swing.JLabel clearBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel manageDBPanel;
    private java.awt.TextArea processStatusTA;
    private javax.swing.JTextField searchET;
    // End of variables declaration//GEN-END:variables
}
