import java.time.LocalDate;

public class Ejecutable {

	public static void main(String[] args) {
		//instanciaciòn de tarjets
		Visa visa = new Visa(1234123412341234L,"Eldar Gonzales",LocalDate.of(2025,04,30),"VISA");
		Nara nara = new Nara(3456345634563456L,"Eldar Giménez",LocalDate.of(2023,04,30),"NARA");
		Amex amex = new Amex(6789678967896789L,"Eldar Giménez",LocalDate.of(2023,12,31),"AMEX");

		System.out.println("Mostrar informacion de una tarjeta \n"
				+ visa.toString() +"\n");
		
		
		System.out.println("Tarjeta Válida? \n" 
				+ "NARA: " + nara.validarTarjeta() +"\n");
		
		System.out.println("comparar tarjetas - número \n" 
				+ (nara.compararTarjeta(amex)?"Tarjeta Duplicada":"Tarjeta Distintas") + "\n"
				+ (nara.compararTarjeta(nara)?"Tarjeta Duplicada":"Tarjeta Distintas") + "\n");
		
		
		System.out.println("consultar tasa (% y $) de una marca (visa con producto de $920.5)");
		System.out.println(visa.tasaInformacion(920.50f) + "\n");

		
		float valor = 4520.99f;
		float limite = 1000f;
		System.out.println("operación válida? \n"
				+ (visa.validarOperacion(valor,limite)?"Total a pagar: $"+visa.tasa(valor):"Excede el lìmite: $"+limite) + "\n");
		
		valor = 920.5f;
		System.out.println("operación válida? \n" 
				+ (amex.validarOperacion(valor,limite)?"Total a pagar: $"+amex.tasa(valor):"Excede el lìmite: $"+limite) + "\n");		
	}
	
	

}
