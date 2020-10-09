/**
 * 
 */
package com.cucoex.util;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @author enrique
 *
 */
public final class Utileria {

	/**
	 * 
	 */
	public Utileria() {
		
	}
	
	
	public static LocalDate sumarDias(LocalDate fecha, Long dias) {
		
		return fecha.plusDays(dias);
		
	}
	
	public static Date sumarMeses(Date fecha, int meses) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.MONTH, meses);
		return calendar.getTime();
		
	}

	public static Date sumarAnios(Date fecha, int anios) {
	
	Calendar calendar = Calendar.getInstance();
	calendar.setTime(fecha);
	calendar.add(Calendar.YEAR, anios);
	return calendar.getTime();
	
}
	

}
