package es.umh.poo.p1;

import java.util.ArrayList;
import es.umh.poo.p1.Prestamo.TPrestamo;

/**
 * Clase que almacena los tipos de prestamo que pueden haber.
 */
public class TipoPrestamo {
	private static final String CADENA_PRESTAMO = "Prestamo ";
	private static final String CADENA_TIPO = "Tipo " ;
	private static final String CADENA_IMPORTE_MAX = "Importe máximo: " ;
	private static final String CADENA_PLAZO_MAX = "Plazo máximo: " ;
	private static final String CADENA_MESES = " meses";
	private float tipo;
	private int importeMaximo;
	private int plazo;
	private TPrestamo tipoPrestamo;

	
	// TIPO ------------------------------------------
	/**
	 * Devuelve el porcentaje del tipo de prestamo.
	 * @return El tipo.
	 */
	public float getTipo() {
	    return tipo;
	}
	/**
	 * Establece el tipo.
	 * @param tipo El tipo a establecer.
	 */
	public void setTipo(float tipo) {
	    this.tipo = tipo;
	}

	// IMPORTE MAXIMO ------------------------------------------
	/**
	 * Devuelve el importe maximo.
	 * @return El importe maximo.
	 */
	public int getImporteMaximo() {
	    return importeMaximo;
	}
	/**
	 * Establece el importe maximo.
	 * @param importeMaximo El importe maximo a establecer.
	 */
	public void setImporteMaximo(int importeMaximo) {
	    this.importeMaximo = importeMaximo;
	}

	// PLAZOS ------------------------------------------
	/**
	 * Devuelve el plazo. 
	 * @return El plazo.
	 */
		public int getPlazo() {
	    return plazo;
	}
	/**
	 * Establece el plazo.
	 * @param plazo El plazo a establecer.
	 */
	public void setPlazo(int plazo) {
	    this.plazo = plazo;
	}

	// TIPO DE PRESTAMO  ------------------------------------------
	/**
	 * Devuelve el tipo de prestamo, PERSONAL o HIPORTECARIO.
	 * @return El tipo de prestamo.
	 */
	public TPrestamo getTipoPrestamo() {
	    return tipoPrestamo;
	}

	/**
	 * Establece el tipo de prestamo.
	 * @param tipoPrestamo El tipo de prestamo a establecer.
	 */
	public void setTipoPrestamo(TPrestamo tipoPrestamo) {
	    this.tipoPrestamo = tipoPrestamo;
	}

	
	// FUNCIONES  ----------------------------------------------------------------------------------
	/**
	 * Crea un arraList de esta misma clase, anyadiendo 4 objetos, con sus respectivas caracteristicas, 
	 * que representan los tipos de prestamos que hay.
	 * @return El arrayList TipoPrestamo con 4 objetos.
	 */
	public static ArrayList<TipoPrestamo> damePrestamos() {	
		ArrayList<TipoPrestamo> array = new ArrayList<TipoPrestamo>();
		
		TipoPrestamo tp1 = new TipoPrestamo();
		tp1.setTipoPrestamo(TPrestamo.PERSONAL);
		tp1.setTipo(5);
		tp1.setImporteMaximo(1500);
		tp1.setPlazo(48);
		array.add(tp1);
		
		TipoPrestamo tp2 = new TipoPrestamo();
		tp2.setTipoPrestamo(TPrestamo.PERSONAL);
		tp2.setTipo(7);
		tp2.setImporteMaximo(30000);
		tp2.setPlazo(72);
		array.add(tp2);
		
		
		TipoPrestamo tp3 = new TipoPrestamo();
		tp3.setTipoPrestamo(TPrestamo.HIPOTECARIO);
		tp3.setTipo((float)0.99);
		tp3.setImporteMaximo(200000);
		tp3.setPlazo(72);
		array.add(tp3);
		
		TipoPrestamo tp4 = new TipoPrestamo();
		tp4.setTipoPrestamo(TPrestamo.HIPOTECARIO);
		tp4.setTipo((float)1.5);
		tp4.setImporteMaximo(300000);
		tp4.setPlazo(72);
		array.add(tp4);
		
		return array;
	}
	
	/**
	 * Construye y devuelve una cadena que representa los detalles del prestamo.
	 * @return Una cadena con los detalles del prestamo.
	 */
	public String dameCadena() {
	    StringBuilder cadena = new StringBuilder();

	    cadena.append(CADENA_PRESTAMO).append(tipoPrestamo).append("\n");
	    cadena.append(CADENA_TIPO).append(tipo).append("\n");
	    cadena.append(CADENA_IMPORTE_MAX).append(importeMaximo).append("€").append("\n");
	    cadena.append(CADENA_PLAZO_MAX).append(plazo).append(CADENA_MESES).append("\n");

	    return cadena.toString();
	}
}
