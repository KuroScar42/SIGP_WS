/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.grupojf.sigp.sigp_ws.util;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author sigp
 */
public class DateUtils {

    public DateUtils() {
    }

    public Integer daysBetween(Date d1, Date d2) {
        Long diff = d2.getTime() - d1.getTime();
        return Integer.valueOf(String.valueOf(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)));
    }

}
