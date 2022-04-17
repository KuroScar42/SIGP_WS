/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.grupojf.sigp.sigp_ws.model;

import java.util.ArrayList;

/**
 *
 * @author Hernan
 */
public class SaveCerdo {
    
    private CerdosDto cerdo;
    private ArrayList<InseminacionDto> inseminaciones;

    public SaveCerdo() {
    }

    public CerdosDto getCerdo() {
        return cerdo;
    }

    public void setCerdo(CerdosDto cerdo) {
        this.cerdo = cerdo;
    }

    public ArrayList<InseminacionDto> getInseminaciones() {
        return inseminaciones;
    }

    public void setInseminaciones(ArrayList<InseminacionDto> inseminaciones) {
        this.inseminaciones = inseminaciones;
    }
}
