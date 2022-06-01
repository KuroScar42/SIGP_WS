package cr.grupojf.sigp.sigp_ws.service;

import cr.grupojf.sigp.sigp_ws.model.AperturaCajas;
import cr.grupojf.sigp.sigp_ws.model.BodegaDto;
import cr.grupojf.sigp.sigp_ws.model.BodegasProductos;
import cr.grupojf.sigp.sigp_ws.model.Cerdos;
import cr.grupojf.sigp.sigp_ws.model.Embarazos;
import cr.grupojf.sigp.sigp_ws.model.EmbarazosDto;
import cr.grupojf.sigp.sigp_ws.model.Facturas;
import cr.grupojf.sigp.sigp_ws.model.Inseminacion;
import cr.grupojf.sigp.sigp_ws.model.InseminacionDto;
import cr.grupojf.sigp.sigp_ws.model.ProductosDto;
import cr.grupojf.sigp.sigp_ws.model.ReporteCajaDto;
import cr.grupojf.sigp.sigp_ws.model.ReporteCerdaDto;
import cr.grupojf.sigp.sigp_ws.model.ReporteGananciaDto;
import cr.grupojf.sigp.sigp_ws.model.ReporteInventarioDto;
import cr.grupojf.sigp.sigp_ws.model.ReportePendienteDto;
import cr.grupojf.sigp.sigp_ws.util.CodigoRespuesta;
import cr.grupojf.sigp.sigp_ws.util.DateUtils;
import cr.grupojf.sigp.sigp_ws.util.LocalDateAdapter;
import cr.grupojf.sigp.sigp_ws.util.Respuesta;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

    private static final Logger LOG = Logger.getLogger(ReportesService.class.getName());
    @PersistenceContext(unitName = "sigp_PU")
    protected EntityManager em;

    public Respuesta getReporteCajas() {
        try {
//            Query query = em.createNamedQuery("AperturaCajas.numCajas", AperturaCajas.class);
            Query query = em.
                    createNativeQuery("SELECT a.NUM_CAJA,DATE(a.FECHA_CAJA),COUNT(a.ID_APERTURA), COUNT(c.ID_CIERRE) FROM Apertura_Cajas a LEFT JOIN Cierres_Cajas c ON c.ID_APERTURA = a.ID_APERTURA GROUP BY a.NUM_CAJA,DATE(a.FECHA_CAJA);");
            List<Object[]> aperturas = query.getResultList();
            List<ReporteCajaDto> reporteDto = new ArrayList<>();
//            for (int i = 0; i < 10; i++) {
//                reporteDto.add(new ReporteCajaDto(String.valueOf(i), "10-10-2010", 5, 5));
//
//            }
            for (Object[] a : aperturas) {
                reporteDto.add(new ReporteCajaDto((String) a[0], LocalDateAdapter.adaptToJson((Date) a[1]), Integer.valueOf(String.valueOf(a[2])), Integer.valueOf(String.valueOf(a[3]))));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", reporteDto);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar las cajas en el sistema", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar las cajas en el sistema.", "getReporteCajas " + ex.getMessage());
        }
    }

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

    public Respuesta getReporteGanancias() {
        try {
//            Query query = em.createNamedQuery("Cerdos.findAll", Cerdos.class);
            Query query = em.createNativeQuery("SELECT DATE(f.FECHA_FACTURA), SUM(f.TOTAL_FACTURA) FROM Facturas f GROUP BY DATE(f.FECHA_FACTURA);");
            List<Object[]> reporte = query.getResultList();
            List<ReporteGananciaDto> reporteDto = new ArrayList<>();
            for (Object[] g : reporte) {
                reporteDto.add(new ReporteGananciaDto(LocalDateAdapter.adaptToJson((Date) g[0]), Float.valueOf(String.valueOf(g[1]))));
            }
            
//            for (int i = 0; i < 10; i++) {
//                reporteDto.add(new ReporteGananciaDto("10-10-2010", 505000f));
//
//            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", reporteDto);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar las ganancias en el sistema", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar las ganancias en el sistema.", "getReporteGanancias " + ex.getMessage());
        }
    }

    public Respuesta getReporteInventarios() {
        try {
            Query query = em.createNamedQuery("BodegasProductos.findAll", BodegasProductos.class);
            List<BodegasProductos> bodegasProductos = query.getResultList();
            List<ReporteInventarioDto> reporteDto = new ArrayList<>();
            for (BodegasProductos bp : bodegasProductos) {
                reporteDto.add(new ReporteInventarioDto(new ProductosDto(bp.getIdProducto()), bp.getCantidadProducto(), new BodegaDto(bp.getIdBodega())));
            }
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", reporteDto);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar los inventarios del sistema", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar los inventarios del sistema.", "getReporteInventarios " + ex.getMessage());
        }
    }

    public Respuesta getReportePendientes() {
        try {
            Query query = em.createNamedQuery("Facturas.pendientes", Facturas.class);
            List<Object[]> reportResult = query.getResultList();
            List<ReportePendienteDto> reportesDto = new ArrayList<>();
            for (Object[] r : reportResult) {
                Date date = ((Facturas) r[0]).getFechaFactura();
                Float total = ((Facturas) r[0]).getTotalFactura();
                Float pagado = Float.valueOf(String.valueOf(((Double) r[1])));
                reportesDto.add(new ReportePendienteDto(((Facturas) r[0]).getIdCliente().getIdPersona().getFullname(),
                        total,
                        total - pagado,
                        LocalDateAdapter.adaptToJson(date),
                        new DateUtils().daysBetween(date, new Date())));
            }
//            for (int i = 0; i < 10; i++) {
//                reportesDto.add(new ReportePendienteDto("Cliente" + i, 0f, 0f, "10-10-2010", i));
//
//            }
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", reportesDto);
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar las cajas en el sistema", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar las pendientes del sistema.", "getReportePendientes " + ex.getMessage());
        }
    }

}
