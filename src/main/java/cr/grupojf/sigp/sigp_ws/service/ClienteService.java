/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.grupojf.sigp.sigp_ws.service;

import cr.grupojf.sigp.sigp_ws.model.Clientes;
import cr.grupojf.sigp.sigp_ws.model.ClientesDto;
import cr.grupojf.sigp.sigp_ws.model.Empresas;
import cr.grupojf.sigp.sigp_ws.model.EmpresasDto;
import cr.grupojf.sigp.sigp_ws.model.Personas;
import cr.grupojf.sigp.sigp_ws.model.PersonasDto;
import cr.grupojf.sigp.sigp_ws.util.CodigoRespuesta;
import cr.grupojf.sigp.sigp_ws.util.Respuesta;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author herna
 */
public class ClienteService {
    
    private static final Logger LOG = Logger.getLogger(ClienteService.class.getName());
    @PersistenceContext(unitName = "sigp_PU")
    protected EntityManager em;
    
    public Respuesta guardarCliente(ClientesDto clienteDto) {
        try {
            Clientes cliente;
            if (clienteDto.getId() != null && clienteDto.getId() > 0) {
                cliente = em.find(Clientes.class, clienteDto.getId());
                if (cliente == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro el cliente especificado", "guardarCliente NoResultException");
                }
                cliente = actualizar(cliente, clienteDto);
                cliente.actualizarPedido(clienteDto);
                cliente = em.merge(cliente);
            } else {
                cliente = new Clientes(clienteDto);
                cliente = actualizar(cliente, clienteDto);
                em.persist(cliente);
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "cliente", new ClientesDto(cliente));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el cliente.", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el cliente.", "guardarCliente " + e.getMessage());
        }
    }
    
    private Clientes actualizar(Clientes c, ClientesDto cd){
        if (cd.getPersona() != null) {
            Respuesta res = guardarPersona(cd.getPersona());
            if (res.getEstado()) {
                c.setIdPersona((Personas) res.getResultado("persona"));
            }else{
                // validar la accion si fallara 
            }
        } else if (cd.getEmpresa() != null) {
            Respuesta res = guardarEmpresa(cd.getEmpresa());
            if (res.getEstado()) {
                c.setIdEmpresa((Empresas) res.getResultado("empresa"));
            }else{
                // validar la accion si fallara
            }
        }
        return c;
    }
    
    public Respuesta guardarPersona(PersonasDto personaDto) {
        try {
            Personas persona;
            if (personaDto.getId() != null && personaDto.getId() > 0) {
                persona = em.find(Personas.class, personaDto.getId());
                if (persona == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro la persona en especifico", "guardarPersona NoResultException");
                }
                persona.actualizarPedido(personaDto);
                persona = em.merge(persona);
            } else {
                persona = new Personas(personaDto);
                em.persist(persona);
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "persona", new PersonasDto(persona));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la persona.", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar la persona.", "guardarPersona " + e.getMessage());
        }
    }
    
    public Respuesta guardarEmpresa(EmpresasDto empresaDto) {
        try {
            Empresas empresa;
            if (empresaDto.getId() != null && empresaDto.getId() > 0) {
                empresa = em.find(Empresas.class, empresaDto.getId());
                if (empresa == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encontro la empresa en especifico", "guardarEmpresa NoResultException");
                }
                empresa.actualizarPedido(empresaDto);
                empresa = em.merge(empresa);
            } else {
                empresa = new Empresas(empresaDto);
                em.persist(empresa);
            }
            em.flush();
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "empresa", new EmpresasDto(empresa));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar la empresa.", e);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar la empresa.", "guardarEmpresa " + e.getMessage());
        }
    }
    
    
}
