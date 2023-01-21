/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import java.awt.Frame;

/**
 *
 * @author nur4nnis4@gmail.com
 */
public class MainFrame extends javax.swing.JFrame {
    private static final Color PANE_CLICK_COLOR = new Color(102, 204, 0);
    private static final Color PANE_DEFAULT_COLOR= new Color(51, 51, 51);
    private static final Color PANE_MOUSE_ENTERED_COLOR = new Color(0,0,0);
    private static final Color GRAY = new Color (90,89,89);    
    private static final Color DARK_GRAY = new Color (51,51,51);
    private static final Color RED = new Color(230,0,0);
    
    private static boolean managePaneActive;
    private static boolean aboutPaneActive;
    
            
    int x,y;
    
    public MainFrame() {
        initComponents();
        ManageDatabase md = new ManageDatabase();
        mainPanel.removeAll();
        mainPanel.add(md).setVisible(true);
        managePaneActive = true;
        aboutPaneActive = false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        minimizePanel = new javax.swing.JPanel();
        minimizeBtn = new javax.swing.JLabel();
        closePanel = new javax.swing.JPanel();
        closeBtn = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        menuBar = new javax.swing.JPanel();
        managePane = new javax.swing.JPanel();
        manageDBLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        manageIcon = new javax.swing.JLabel();
        aboutPane = new javax.swing.JPanel();
        aboutLabel = new javax.swing.JLabel();
        aboutIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel8.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 100, 100)));
        jPanel8.setPreferredSize(new java.awt.Dimension(930, 563));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topPanel.setBackground(new java.awt.Color(51, 51, 51));
        topPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        topPanel.setPreferredSize(new java.awt.Dimension(940, 20));
        topPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                topPanelMouseDragged(evt);
            }
        });
        topPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                topPanelMousePressed(evt);
            }
        });

        minimizePanel.setBackground(new java.awt.Color(51, 51, 51));

        minimizeBtn.setBackground(new java.awt.Color(0, 0, 0));
        minimizeBtn.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        minimizeBtn.setForeground(new java.awt.Color(102, 204, 0));
        minimizeBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizeBtn.setText("-");
        minimizeBtn.setPreferredSize(new java.awt.Dimension(30, 30));
        minimizeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeBtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout minimizePanelLayout = new javax.swing.GroupLayout(minimizePanel);
        minimizePanel.setLayout(minimizePanelLayout);
        minimizePanelLayout.setHorizontalGroup(
            minimizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(minimizePanelLayout.createSequentialGroup()
                .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        minimizePanelLayout.setVerticalGroup(
            minimizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, minimizePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(minimizeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        closePanel.setBackground(new java.awt.Color(51, 51, 51));

        closeBtn.setBackground(new java.awt.Color(0, 0, 0));
        closeBtn.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        closeBtn.setForeground(new java.awt.Color(102, 204, 0));
        closeBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        closeBtn.setText("x");
        closeBtn.setPreferredSize(new java.awt.Dimension(30, 30));
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeBtnMouseExited(evt);
            }
        });

        javax.swing.GroupLayout closePanelLayout = new javax.swing.GroupLayout(closePanel);
        closePanel.setLayout(closePanelLayout);
        closePanelLayout.setHorizontalGroup(
            closePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        closePanelLayout.setVerticalGroup(
            closePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(closePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(229, 230, 229));
        jLabel5.setText("Song Recognition");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic_songrecognition_40px.png"))); // NOI18N

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 736, Short.MAX_VALUE)
                .addComponent(minimizePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(closePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(minimizePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(closePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(jLabel2)))
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5)))
                .addGap(19, 19, 19))
        );

        jPanel8.add(topPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 1, 1005, 60));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel3.setText("Copyright © 2019 Nur Annisa Ilmu Komputer USU");
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(703, 1461, -1, -1));

        mainPanel.setBackground(new java.awt.Color(102, 102, 102));
        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        mainPanel.setPreferredSize(new java.awt.Dimension(880, 628));
        mainPanel.setLayout(new java.awt.CardLayout());
        jPanel8.add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        menuBar.setBackground(new java.awt.Color(51, 51, 51));
        menuBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        menuBar.setPreferredSize(new java.awt.Dimension(940, 71));

        managePane.setBackground(new java.awt.Color(102, 204, 0));
        managePane.setPreferredSize(new java.awt.Dimension(118, 100));
        managePane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                managePaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                managePaneMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                managePaneMousePressed(evt);
            }
        });

        manageDBLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        manageDBLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        manageDBLabel.setText("Manage");

        jPanel3.setBackground(new java.awt.Color(218, 239, 206));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        manageIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic_managedb_black.png"))); // NOI18N

        javax.swing.GroupLayout managePaneLayout = new javax.swing.GroupLayout(managePane);
        managePane.setLayout(managePaneLayout);
        managePaneLayout.setHorizontalGroup(
            managePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(manageDBLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managePaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(manageIcon)
                .addGap(39, 39, 39))
        );
        managePaneLayout.setVerticalGroup(
            managePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managePaneLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(manageIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manageDBLabel)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        aboutPane.setBackground(new java.awt.Color(51, 51, 51));
        aboutPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(42, 42, 42)));
        aboutPane.setForeground(new java.awt.Color(255, 255, 255));
        aboutPane.setPreferredSize(new java.awt.Dimension(118, 100));
        aboutPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutPaneMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                aboutPaneMousePressed(evt);
            }
        });

        aboutLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        aboutLabel.setForeground(new java.awt.Color(255, 255, 255));
        aboutLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aboutLabel.setText("About");

        aboutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic_about_white.png"))); // NOI18N

        javax.swing.GroupLayout aboutPaneLayout = new javax.swing.GroupLayout(aboutPane);
        aboutPane.setLayout(aboutPaneLayout);
        aboutPaneLayout.setHorizontalGroup(
            aboutPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(aboutLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(aboutPaneLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(aboutIcon)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        aboutPaneLayout.setVerticalGroup(
            aboutPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutPaneLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(aboutIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aboutLabel)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout menuBarLayout = new javax.swing.GroupLayout(menuBar);
        menuBar.setLayout(menuBarLayout);
        menuBarLayout.setHorizontalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(managePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(aboutPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menuBarLayout.setVerticalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuBarLayout.createSequentialGroup()
                .addComponent(managePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(aboutPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 428, Short.MAX_VALUE))
        );

        jPanel8.add(menuBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 120, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void managePaneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managePaneMousePressed
        managePaneActive = true;
        aboutPaneActive = false;
        aboutPane.setBackground(PANE_DEFAULT_COLOR);
        managePane.setBackground(PANE_CLICK_COLOR);
        manageDBLabel.setForeground(Color.BLACK);
        aboutLabel.setForeground(Color.WHITE);
        aboutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic_about_white.png")));
        manageIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic_managedb_black.png")));
        
        ManageDatabase md = new ManageDatabase();
        mainPanel.removeAll();
        mainPanel.add(md).setVisible(true);
    }//GEN-LAST:event_managePaneMousePressed

    private void aboutPaneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutPaneMousePressed
        managePaneActive = false;
        aboutPaneActive = true;
        aboutPane.setBackground(PANE_CLICK_COLOR);
        managePane.setBackground(PANE_DEFAULT_COLOR);
        manageDBLabel.setForeground(Color.WHITE);
        aboutLabel.setForeground(Color.BLACK);
        aboutIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic_about_black.png")));        
        manageIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ic_managedb_white.png")));
        mainPanel.removeAll();
        About about = new About();
        mainPanel.add(about).setVisible(true);
    }//GEN-LAST:event_aboutPaneMousePressed

    private void closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeBtnMouseClicked

    private void closeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseEntered
        closePanel.setBackground(RED);
    }//GEN-LAST:event_closeBtnMouseEntered

    private void closeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseExited
        closePanel.setBackground(DARK_GRAY);
    }//GEN-LAST:event_closeBtnMouseExited

    private void topPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPanelMouseDragged
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        this.setLocation(xx-x,yy-y);
    }//GEN-LAST:event_topPanelMouseDragged

    private void topPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPanelMousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_topPanelMousePressed

    private void minimizeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtnMouseExited
        minimizePanel.setBackground(DARK_GRAY);
    }//GEN-LAST:event_minimizeBtnMouseExited

    private void minimizeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtnMouseEntered
        minimizePanel.setBackground(GRAY);
    }//GEN-LAST:event_minimizeBtnMouseEntered

    private void minimizeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtnMouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_minimizeBtnMouseClicked

    private void managePaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managePaneMouseEntered
        if(!managePaneActive)
            managePane.setBackground(PANE_MOUSE_ENTERED_COLOR);
    }//GEN-LAST:event_managePaneMouseEntered

    private void managePaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_managePaneMouseExited
        if(!managePaneActive)
            managePane.setBackground(PANE_DEFAULT_COLOR);
    }//GEN-LAST:event_managePaneMouseExited

    private void aboutPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutPaneMouseEntered
        if(!aboutPaneActive)
            aboutPane.setBackground(PANE_MOUSE_ENTERED_COLOR);
    }//GEN-LAST:event_aboutPaneMouseEntered

    private void aboutPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutPaneMouseExited
        if(!aboutPaneActive)
            aboutPane.setBackground(PANE_DEFAULT_COLOR);
    }//GEN-LAST:event_aboutPaneMouseExited

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aboutIcon;
    private javax.swing.JLabel aboutLabel;
    private javax.swing.JPanel aboutPane;
    private javax.swing.JLabel closeBtn;
    private javax.swing.JPanel closePanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel manageDBLabel;
    private javax.swing.JLabel manageIcon;
    private javax.swing.JPanel managePane;
    private javax.swing.JPanel menuBar;
    private javax.swing.JLabel minimizeBtn;
    private javax.swing.JPanel minimizePanel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
