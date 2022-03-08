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
    private ArrayList<PartosDto> partos;
    private ArrayList<EmbarazosDto> embarazos;

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

    public ArrayList<PartosDto> getPartos() {
        return partos;
    }

    public void setPartos(ArrayList<PartosDto> partos) {
        this.partos = partos;
    }

    public ArrayList<EmbarazosDto> getEmbarazos() {
        return embarazos;
    }

    public void setEmbarazos(ArrayList<EmbarazosDto> embarazos) {
        this.embarazos = embarazos;
    }
    
    
    
    
}
