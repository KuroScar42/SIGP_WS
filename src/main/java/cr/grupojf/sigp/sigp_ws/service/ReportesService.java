package cr.grupojf.sigp.sigp_ws.service;

import cr.grupojf.sigp.sigp_ws.model.Cerdos;
import cr.grupojf.sigp.sigp_ws.model.Embarazos;
import cr.grupojf.sigp.sigp_ws.model.EmbarazosDto;
import cr.grupojf.sigp.sigp_ws.model.Inseminacion;
import cr.grupojf.sigp.sigp_ws.model.InseminacionDto;
import cr.grupojf.sigp.sigp_ws.model.ReporteCerdaDto;
import cr.grupojf.sigp.sigp_ws.util.CodigoRespuesta;
import cr.grupojf.sigp.sigp_ws.util.Respuesta;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
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
            Query query = em.createNamedQuery("Cerdos.findAll", Cerdos.class);
            List<Cerdos> cerdas = query.getResultList();
            List<ReporteCerdaDto> cerdasReporteDto = new ArrayList<>();
//            for (int i = 0; i < 10; i++) {
//                cerdasReporteDto.add(new ReporteCerdaDto(1,"NO",new InseminacionDto(),new EmbarazosDto(),10));
//                
//            }
            for (Cerdos cerda : cerdas) {
                Inseminacion inseminacion = new Inseminacion();
                Embarazos embarazo = new Embarazos();
                Integer numEmbarazo = 0;
                String estadoCerda = "Sin aumentar";

                // se obtiene la ultima inseminacion
                Query qI = em.createNamedQuery("Inseminacion.inseminacionByCerda", Inseminacion.class);
                qI.setParameter("idCerdo", cerda.getIdCerdo());
                Optional<Inseminacion> i = qI.getResultStream().findFirst();

                if (i.isPresent()) {
                    inseminacion = i.get();
                }

                // se obtiene el ultimo embarazo
                Query qE = em.createNamedQuery("Embarazos.embarazosByCerdo", Embarazos.class);
                qE.setParameter("idCerdo", cerda.getIdCerdo());
                Stream<Embarazos> stream = qE.getResultStream();
                Optional<Embarazos> e = stream.findFirst();
                numEmbarazo = qE.getResultList().size();
                if (e.isPresent()) {
                    embarazo = e.get();
                    estadoCerda = "A".equals(embarazo.getEstadoEmbarazo()) ? "Aumentada" : "Sin Aumentar";
                    embarazo = "A".equals(embarazo.getEstadoEmbarazo()) ? new Embarazos() : embarazo;
                }

                cerdasReporteDto.add(new ReporteCerdaDto(cerda.getIdCerdo(), estadoCerda, new InseminacionDto(inseminacion), new EmbarazosDto(embarazo), numEmbarazo));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", cerdasReporteDto);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar las cerdas en el sistema", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar las cerdas en el sistema.", "getReporteCerdas " + ex.getMessage());
        }
    }

}
