/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.grupojf.sigp.sigp_ws.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ccarranza
 */
public class LocalDateAdapter {

    private static final Logger LOG = Logger.getLogger(LocalDateAdapter.class.getName());
    private DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
    private static final DateFormat format = new SimpleDateFormat("yy-mm-dd hh:mm:ss");

    public static String adaptToJson(Date date) throws Exception {
        try {
            if (date == null) {
                return null;
            } else {
//                return formatter.format(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                return format.format(date);
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Error al deserializar la fecha [" + date + "].", ex);
            throw ex;
        }
    }

    public static Date adaptFromJson(String date) throws Exception {
        try {
            if (date == null) {
                return null;
            } else {
//                return new Date().from(Instant.from(formatter.parse(date)).atZone(ZoneId.systemDefault()).toInstant());
                return format.parse(date);
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Error al serializar la fecha [" + date + "].", ex);
            throw ex;
        }
    }

}
