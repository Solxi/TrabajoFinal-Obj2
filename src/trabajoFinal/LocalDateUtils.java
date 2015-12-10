package trabajoFinal;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.Days;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDate;

public class LocalDateUtils {
	
	public LocalDateUtils() { }
		
	public static List<LocalDate> fechasIntermedias(LocalDate fechaDeInicio, LocalDate fechaDeFin){
		List<LocalDate> fechas = new ArrayList<LocalDate>();
		int cantidadDeDias = Days.daysBetween(fechaDeInicio, fechaDeFin).getDays();
		for (int i=0; i <= cantidadDeDias; i++) {
			LocalDate d = fechaDeInicio.withFieldAdded(DurationFieldType.days(), i);
			fechas.add(d);
		}
		return fechas;
	}
	
}
