/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.service;

import cr.grupojf.sigp.sigp_ws.model.PersonasDto;
import cr.grupojf.sigp.sigp_ws.model.Usuarios;
import cr.grupojf.sigp.sigp_ws.util.CodigoRespuesta;
import cr.grupojf.sigp.sigp_ws.util.Respuesta;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sigp
 */
@Stateless
@LocalBean
public class UsuariosService {
    
    private static final Logger LOG = Logger.getLogger(UsuariosService.class.getName());
    @PersistenceContext(unitName = "sigp_PU")
    protected EntityManager em;
    
    public Respuesta getUsuByNomContra(String nombre, String contrasenia) {
        try {
            Query query = em.createNamedQuery("Usuarios.findByNombreUsuarioContrasenia", Usuarios.class);
            query.setParameter("nombreUsuario", nombre);
            query.setParameter("contrasennaUsuario", contrasenia);
            Usuarios usuario = (Usuarios) query.getSingleResult();
            PersonasDto personaDto = new PersonasDto(usuario.getIdPresona());

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "personaUsuario", personaDto);
        } catch (NoResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "No existe el usuario con las credeciales especificadas","getUsuByNomContra" + ex.getMessage());
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el usuario", "getUsuByNomContra " + ex.getMessage());
        }
    }
    
}
