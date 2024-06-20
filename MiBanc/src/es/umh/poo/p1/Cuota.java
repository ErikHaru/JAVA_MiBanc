package es.umh.poo.p1;

/**
 * Clase que hace referencia a una cuota de un prestamo.
 */
public class Cuota {
	
	private static final String CADENA_NUMERO_CUOTA = "Cuota ";
	private static final String CADENA_IMPORTE_INTERESES_CUOTA = "Importe intereses cuotas: ";
	private static final String CADENA_IMPORTE_AMORTIZADO = "Importe amortizado: ";
	private static final String CADENA_IMPORTE_CUOTAS = "Importe de cuota: ";
	private static final String CADENA_IMPORTE_PENDIENTE = "Importe pendiente: ";
	
	private int numero;
	private double importeIntereses;
	private double importeAmortizado;
	private double importeCuota;
	private double capitalPendiente;
	
	// NUMERO DE LA CUOTA ------------------------------------------
	/**
	 * Devuelve el numero de la cuota, equivalente al numero del meses.
	 * @return El numero.
	 */
	public int getNumero() {
	    return numero;
	}
	/**
	 * Establece el numero de la cuota, equivalente al numero del meses.
	 * @param numero El numero a establecer.
	 */
	public void setNumero(int numero) {
	    this.numero = numero;
	}

	// IMPORTE DE INTERES ------------------------------------------
	/**
	 * Devuelve el importe de intereses.
	 * @return El importe de intereses.
	 */
	public double getImporteIntereses() {
	    return importeIntereses;
	}
	/**
	 * Establece el importe de intereses.
	 * @param porcenInteres El importe de intereses a establecer.
	 */
	public void setImporteIntereses(double porcenInteres) {
	    this.importeIntereses = porcenInteres;
	}

	// IMPORTE AMORTIZADO ------------------------------------------
	/**
	 * Devuelve el importe amortizado.
	 * @return El importe amortizado.
	 */
	public double getImporteAmortizado() {
	    return importeAmortizado;
	}
	/**
	 * Establece el importe amortizado.
	 * @param importeAmortizado El importe amortizado a establecer.
	 */
	public void setImporteAmortizado(double importeAmortizado) {
	    this.importeAmortizado = importeAmortizado;
	}

	// IMPORTE DE CUOTA ------------------------------------------
	/**
	 * Devuelve el importe de la cuota.
	 * @return El importe de la cuota.
	 */
	public double getImporteCuota() {
	    return importeCuota;
	}
	/**
	 * Establece el importe de la cuota.
	 * @param d El importe de la cuota a establecer.
	 */
	public void setImporteCuota(double d) {
	    this.importeCuota = d;
	}

	// CAPITAL PENDEIENTE ------------------------------------------
	/**
	 * Devuelve el capital pendiente.
	 * @return El capital pendiente.
	 */
	public double getCapitalPendiente() {
	    return capitalPendiente;
	}
	/**
	 * Establece el capital pendiente.
	 * @param capitalPendiente El capital pendiente a establecer.
	 */
	public void setCapitalPendiente(double capitalPendiente) {
	    this.capitalPendiente = capitalPendiente;
	}
	
	// FUNCIONES ------------------------------------------------------------------------------------------------
	/**
	 * Construye y devuelve una cadena con los detalles de la cuota.
	 * @return Una cadena con los detalles de la cuota.
	 */
	public String mostrarDetallado() {
	    StringBuilder cadena = new StringBuilder();
	    
	    cadena.append("\n").append(CADENA_NUMERO_CUOTA).append(getNumero()).append(" ------------------------").append("\n");
	    cadena.append(CADENA_IMPORTE_INTERESES_CUOTA).append(String.format("%.2f", getImporteIntereses())).append("\n");
	    cadena.append(CADENA_IMPORTE_AMORTIZADO).append(String.format("%.2f", getImporteAmortizado())).append("\n");
	    cadena.append(CADENA_IMPORTE_CUOTAS).append(String.format("%.2f", getImporteCuota())).append("\n");
	    cadena.append(CADENA_IMPORTE_PENDIENTE).append(String.format("%.2f", getCapitalPendiente())).append("\n");
	

	    return cadena.toString();
	}
}
