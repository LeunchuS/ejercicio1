import java.time.LocalDate;

public abstract class Tarjeta {
	private String marca;
	private long numero;
	private String cardholder;
	private LocalDate fechaVencimiento;

	public Tarjeta(long numero, String cardholder, LocalDate fechaVencimiento, String marca) {
		this.numero = numero;
		this.cardholder = cardholder;
		this.fechaVencimiento = fechaVencimiento;
		this.marca = marca;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return cardholder;
	}

	public void setNombre(String cardholder) {
		this.cardholder = cardholder;
	}

	public LocalDate getFechaExpiración() {
		return fechaVencimiento;
	}

	public void setFechaExpiración(LocalDate fechaExpiración) {
		this.fechaVencimiento = fechaExpiración;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String toString() {
		return "Tarjeta => numero=" + numero + ", nombre=" + cardholder + ", fechaExpiración=" + fechaVencimiento
				+ ", marca=" + marca;
	}

	// devuelve la tasa en %
	public abstract float tasa();

	//devuelve el valor con la tasa aplicada si es finito, !Nan y mayor que 0, caso contrario devuelve -1
	public float tasa(float valor){
		if (Float.isFinite(valor) && valor >= 0)
			valor = valor *(1+(tasa()/100));
		else
			valor = -1;
		return valor;
	}

	// devuelve la marca de la tarjeta y la tasa en % y $ (string)
	public String tasaInformacion(float valor) {
		String info = "";
		try {
			if (Float.isFinite(valor) && valor >= 0)
				info = getMarca() + " - tasa: " + tasa() + "%|$" + (valor - tasa(valor));
			else
				info = "Error, verificar valor ingresado";
		} catch (Exception e) {
			info = e.getMessage();
		}
		return info;
	}

	public boolean validarTarjeta() {
		boolean añoMenor = (LocalDate.now().getYear() < fechaVencimiento.getYear());
		boolean añoIgual = (LocalDate.now().getYear() == fechaVencimiento.getYear());
		boolean mesMenorIgual = (LocalDate.now().getMonthValue() <= fechaVencimiento.getMonthValue());
		return (añoMenor || (añoIgual && mesMenorIgual));
	}

	public boolean compararTarjeta(Tarjeta tarjeta) {
		return this.numero == tarjeta.getNumero();
	}

	public boolean validarOperacion(float valor, float limite) {
		return (limite > (tasa(valor)));
	}
}
