import java.time.LocalDate;

public class Nara extends Tarjeta{
	public Nara(long numero, String cardholder, LocalDate fechaExpiracion, String marca) {
		super(numero, cardholder, fechaExpiracion, "NARA");
	}

	public float tasa() {
		//tasa = dia del mes * 0.5 (Ejemplo 27*0.5)
		LocalDate fechaActual = LocalDate.now();
		
		float diaDelMes = fechaActual.getDayOfMonth();
		//Calculo la tasa en base a la funcion indicada
		float tasa = diaDelMes * 0.5f;
		//verifico que la tasa se encuentre en el rango 0.3 - 5
		tasa = Math.max(0.3f, tasa);
		tasa = Math.min(tasa, 5f);
		//System.out.println(tasa);
		return tasa;
	}
	

}