/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.controller;

import cr.grupojf.sigp.sigp_ws.service.ProveedoresService;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author sigp
 */
@Path("/ProveedoresController")
public class ProveedoresController {
    @EJB
    private ProveedoresService service;
}
