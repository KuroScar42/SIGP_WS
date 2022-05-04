package cr.grupojf.sigp.sigp_ws.service;

import cr.grupojf.sigp.sigp_ws.model.Cerdos;
import cr.grupojf.sigp.sigp_ws.model.EmbarazosDto;
import cr.grupojf.sigp.sigp_ws.model.InseminacionDto;
import cr.grupojf.sigp.sigp_ws.model.ReporteCerdaDto;
import cr.grupojf.sigp.sigp_ws.util.CodigoRespuesta;
import cr.grupojf.sigp.sigp_ws.util.Respuesta;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sigp
 */
@Stateless
@LocalBean
public class ReportesService {
    
    private static final Logger LOG = Logger.getLogger(UsuariosService.class.getName());
    @PersistenceContext(unitName = "sigp_PU")
    protected EntityManager em;
    
    public Respuesta getReporteCerdas() {
        try {
            Query query = em.createNamedQuery("Usuarios.findAll", Cerdos.class);
            List<Cerdos> cerdas = query.getResultList();
            List<ReporteCerdaDto> cerdasReporteDto = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                cerdasReporteDto.add(new ReporteCerdaDto(1,"NO",new InseminacionDto(),new EmbarazosDto(),10));
                
            }
//            for (Cerdos cerda : cerdas) {
//                cerdasReporteDto.add(new ReporteCerdaDto(1,"NO",new InseminacionDto(),new EmbarazosDto(),10));
//            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", cerdasReporteDto);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar las cerdas en el sistema", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar las cerdas en el sistema.", "getReporteCerdas " + ex.getMessage());
        }
    }
    
}
