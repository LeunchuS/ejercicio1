import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Visa extends Tarjeta{
	public Visa(long numero, String cardholder, LocalDate fechaExpiracion, String marca) {
		super(numero, cardholder, fechaExpiracion, "VISA");
	}

	//devuelve la tasa(en puntos porcentuales)
	public float tasa() {
		//tasa = a�o / mes (Ejemplo 20/12)
		LocalDate fechaActual = LocalDate.now();		
		String a�o = DateTimeFormatter.ofPattern("yy").format(fechaActual);
		int mes = fechaActual.getMonthValue();
		//Calculo la tasa en base a la funcion indicada
		float tasa = Float.parseFloat(a�o)/mes;
		//verifico que la tasa se encuentre en el rango 0.3 - 5
		tasa = Math.max(0.3f, tasa);
		tasa = Math.min(tasa, 5f);
		//System.out.println(tasa);
		return tasa;	
	}
	

	


	
	
}
