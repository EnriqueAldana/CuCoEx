/**
 * 
 */
package com.cucoex.util;

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
	
	
	public static Date sumarDias(Date fecha, int dias) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, dias);
		return calendar.getTime();
		
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
