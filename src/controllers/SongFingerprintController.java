/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.SongFingerprintsDAOImpl;

/**
 *
 * @author nur4nnis4@gmail.com
 */
public class SongFingerprintController {
    public void delete(int[] songIds){
        new SongFingerprintsDAOImpl().delete(songIds);
    }
}
