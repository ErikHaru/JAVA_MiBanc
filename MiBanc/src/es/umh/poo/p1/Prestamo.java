package es.umh.poo.p1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
/**
 * Clase que representa un prestamo, validando lo que se introduce y 
 * puediendo mandar cadenas con informacion del prestamo.
 */
public class Prestamo {
	
	private static final String CADENA_FECHA_HORA_SOLICITUD = "Fecha y hora de solicictud: ";
	private static final String CADENA_SOLICITANTE = "Solicitante: ";
	private static final String CADENA_IMPORTE_SOLICITADO = "Importe solicitado: ";
	private static final String CADENA_PLAZO_AMORTIZACION = "Plazo de amortización: ";
	private static final String CADENA_TIPO_PRESTAMO_SOLICITADO = "Tipo de prestamo solicitado: ";
	private static final String CADENA_TIPO_INTERES = "Tipo de interes aplicado: ";
	private static final String CADENA_IMPORTE_INTERESES = "Importe intereses: ";
	private static final String CADENA_IMPORTE_TOTAL = "Importe total: ";
	private static final String CADENA_COMODIDAD = "Comodidad para pagar: ";
	private static final String CADENA_ANYO_S = " anyo/s ";
	private static final String CADENA_ANYOS = " anyos ";
	private static final String CADENA_MES_ES = " mes/es ";
	private static final String CADENA_COMODIDAD_MB = "Muy buena";
	private static final String CADENA_COMODIDAD_B = "Buena";
	private static final String CADENA_COMODIDAD_R = "Regular";
	private static final String CADENA_COMODIDAD_D = "Desconocida";
	private static final String ERROR_INGRESOS = "Lamentamos comunicarle que el importe de la cuota supera el 40% de sus ingresos brutos, no es posible conceder el prestamo.";
	private static final String ERROR_FECHA_EDAD_MAYOR = "Lamentamos comunicarle que la fecha de amortización del último pago supera la edad máxima de 75 años y no es posible conceder el prestamo.";
	private static final String ERROR_FECHA_EDAD_MENOR = "Requisito de edad invalido, el solcitatnte debe de ser mayor de edad." ;

	private Persona solicitante;
	private int importe;
	private int plazoEnMeses;
	private double porcenInteres;	
	private ArrayList<Cuota> arrayCuotas;
	private TipoPrestamo tipo; 
	private TPrestamo tipoPrestamo;
	/**
	 * Tipos de prestamos que hay.
	 */
	public enum TPrestamo {
	    /**
	     * Tipo de préstamo personal.
	     */
	    PERSONAL,

	    /**
	     * Tipo de préstamo hipotecario.
	     */
	    HIPOTECARIO;
	} 
		
	// PERSONA  ------------------------------------------

	/**
	 * Constructor de la clase prestamo que toma un objeto Persona como solicitante del prestamo.
	 * @param solicitante El objeto Persona que solicita el prestamo.
	 * @throws Exception Si la edad del solicitante es menor de 18 anyos.
	 */
	public Prestamo(Persona solicitante) throws Exception {
	    if (Persona.calcularEdad(solicitante.getFecha()) < 18) {
	        throw new Exception(ERROR_FECHA_EDAD_MENOR);
	    } else {
	        this.solicitante = solicitante;
	    }
	}
	
	// IMPORTE A SOLICITAR  ------------------------------------------
	/**
	 * Obtiene el importe del prestamo.
	 * @return El importe del prestamo.
	 */
	public int getImporte() {
	    return importe;
	}
	/**
	 * Establece el importe del prestamo.
	 * @param importe El importe del préstamo a establecer.
	 * @throws Exception Si el importe excede el importe máximo permitido por el tipo de prestamo.
	 */
	public void setImporte(String importe) throws Exception {
	    try {
	        if (Integer.parseUnsignedInt(importe) <= tipo.getImporteMaximo()) {
	            this.importe = Integer.parseInt(importe);
	        } else {
	            throw new Exception();
	        }
	    } catch (Exception e) {
	        throw new Exception();
	    }
	}

	// PLAZOS SOLICITADOS  ------------------------------------------
	/**
	 * Obtiene el plazo en meses del prestamo.
	 * @return El plazo en meses del prestamo.
	 */
	public int getPlazoEnMeses() {
	    return plazoEnMeses;
	}
	/**
	 * Establece el plazo en meses del prestamo.
	 * @param plazoEnMeses El plazo en meses del prestamo a establecer.
	 * @throws Exception Si el plazo excede el plazo maximo permitido por el tipo de prestamo.
	 */
	public void setPlazoEnMeses(String plazoEnMeses) throws Exception {
	    try {
	        if (Integer.parseUnsignedInt(plazoEnMeses) <= tipo.getPlazo()) {
	            this.plazoEnMeses = Integer.parseInt(plazoEnMeses);
	        } else {
	            throw new Exception();
	        }
	    } catch (Exception e) {
	        throw new Exception();
	    }
	}

	// TIPOPRESTAMO  ------------------------------------------
	/**
	 * Obtiene el diferentes valores de la clase TipoPrestamo.
	 * @return El tipo de prestamo.
	 */
	public TipoPrestamo getTipo() {
	    return tipo;
	}
	

	// TIPO PORCENTAJE  ------------------------------------------
	/**
	 * Establece el tipo de prestamo aplicando antes el descuento por edad.
	 * @param tipo El tipo de prestamo a establecer.
	 * @throws Exception Si hay un error al calcular los intereses del préstamo.
	 */
	public void setTipo(TipoPrestamo tipo) throws Exception {
	    calcularInteres(tipo);
	    this.tipo = tipo;
	}

	// TIPO DE PRESTAMO   ------------------------------------------
	/**
	 * Obtiene el tipo de prestamo PERSONAL o HIPOTECARIO.
	 * @return El tipo de prestamo PERSONAL o HIPOTECARIO.
	 */
	public TPrestamo getTipoPrestamo() {
	    return tipoPrestamo;
	}
	/**
	 * Establece el tipo de prestamo PERSONAL o HIPOTECARIO.
	 * @param tipoPrestamo El tipo de prestamo PERSONAL o HIPOTECARIO a establecer.
	 */
	public void setTipoPrestamo(TPrestamo tipoPrestamo) throws Exception {
	    this.tipoPrestamo = tipoPrestamo;
	}


	// FUNCIONES  ----------------------------------------------------------------------------------
	/**
	 * Calcula el interes del prestamo basado en la edad del solicitante y el tipo de prestamo.
	 * @param tipo El tipo de prestamo para el calculo del interés.
	 */
	public void calcularInteres(TipoPrestamo tipo) {
		int edad = Persona.calcularEdad(solicitante.getFecha());
		if(edad < 35)
			porcenInteres = (tipo.getTipo()*0.9);
		else if(edad >= 35 && (edad < 45 || edad > 65))
			porcenInteres = (tipo.getTipo()*0.95);
		else
			porcenInteres = tipo.getTipo();
		
	}
	
	/**
	 * Genera un resumen del prestamo con informacion relevante, incluyendo detalles del solicitante,
	 * importe, plazo de amortizacion, tipo de prestamo, porcentaje de interés, importe de intereses,
	 * importe total y comodidad del prestamo.
	 * @return Una cadena con el resumen detallado del prestamo.
	 * @throws Exception Si hay un error al calcular las cuotas del prestamo.
	 */
    public String imprimirResumen()throws Exception {
        StringBuilder cadena = new StringBuilder();
		try {
			calcularCuotas();
		} catch (Exception e){
            throw new Exception(e.getMessage());
		}
        cadena.append(CADENA_FECHA_HORA_SOLICITUD).append(fechaActualConHora()).append("\n");
        cadena.append(CADENA_SOLICITANTE).append(solicitante.getNombre()).append(", ").append(solicitante.getApellido1()).append(" ").append(solicitante.getApellido2()).append(" ").append(Persona.calcularEdad(solicitante.getFecha())).append(CADENA_ANYOS).append("\n");
        cadena.append(CADENA_IMPORTE_SOLICITADO).append(importe).append(" €").append("\n");
        cadena.append(CADENA_PLAZO_AMORTIZACION).append(plazoEnMeses / 12).append(CADENA_ANYO_S).append(plazoEnMeses % 12).append(CADENA_MES_ES).append("\n");
        cadena.append(CADENA_TIPO_PRESTAMO_SOLICITADO).append(tipo.getTipoPrestamo()).append("\n");
        cadena.append(CADENA_TIPO_INTERES).append(porcenInteres).append("%\n");
        cadena.append(CADENA_IMPORTE_INTERESES).append(String.format("%.2f",calcularImporteInteres())).append("%\n");
        cadena.append(CADENA_IMPORTE_TOTAL).append(String.format("%.2f",importe + calcularImporteInteres())).append("\n");
        cadena.append(CADENA_COMODIDAD).append(calcularComodidad()).append("\n");

        return cadena.toString();
    }
    
    /**
     * Genera un resumen detallado del prestamo incluyendo informacion del resumen general y detalles de cada cuota.
     * @return Una cadena con el resumen detallado del prestamo.
     * @throws Exception Si hay un error al generar el resumen general o al mostrar los detalles de las cuotas.
     */
    public String imprimirDetallado()throws Exception {
        StringBuilder cadena = new StringBuilder();
        cadena.append(imprimirResumen());
        for(int i = 0; i < plazoEnMeses; i++)
        	cadena.append(arrayCuotas.get(i).mostrarDetallado());
        return cadena.toString();
    }
    
    /**
     * Calcula las cuotas del prestamo en base al importe, plazo en meses y porcentaje de interes.
     * @throws Exception Si hay un error en los calculos de las cuotas, como edad limite excedida, ingresos insuficientes,
     * importe, plazo o porcentaje de interes no validos, o si ocurre un error inesperado durante el calculo.
     */
	public void calcularCuotas() throws Exception {
		if(importe!=0 && plazoEnMeses!=0 && porcenInteres!=0)
		{
			if(Persona.calcularEdad(solicitante.getFecha(), plazoEnMeses) > 75)
				throw new Exception(ERROR_FECHA_EDAD_MAYOR);
			if( calcularCuotaConst() >= solicitante.getIba()*0.4 )
				throw new Exception(ERROR_INGRESOS);	
			if(arrayCuotas == null) {
				arrayCuotas = new ArrayList<Cuota>();
			}

			double cuotaConst = calcularCuotaConst();
			for( int i = 0; i < plazoEnMeses; i++) {
				Cuota c = new Cuota ();				

				c.setNumero(i+1);				
				c.setImporteCuota(cuotaConst);
				if (i == 0)
					c.setCapitalPendiente(importe);
				else
					c.setCapitalPendiente(arrayCuotas.get(i-1).getCapitalPendiente() - arrayCuotas.get(i-1).getImporteAmortizado());		
				c.setImporteIntereses((porcenInteres/12*0.01)* c.getCapitalPendiente());
				c.setImporteAmortizado(cuotaConst - c.getImporteIntereses());
				
				arrayCuotas.add(c);
			}
		}
		else
			throw new Exception("");
	}
	
	/**
	 * Calcula la cuota constante del prestamo basada en el importe, plazo en meses y porcentaje de interes.
	 * @return El valor de la cuota constante del prestamo.
	 */
	private double calcularCuotaConst()
	{		
		 return (importe*(( (porcenInteres/12*0.01)*Math.pow(1+porcenInteres/12*0.01,plazoEnMeses) ) / (Math.pow(1+porcenInteres/12*0.01,plazoEnMeses) - 1)));
	}
    
    /**
     * Devuelve la fecha y la hora exactas al ser llamda con el formato "dd/MM/yyyy HH:mm:ss"
     * @return La fecha y hora
     */
    public static String fechaActualConHora() {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = fechaHoraActual.format(formatter);

        return fechaFormateada;
    }
    
    /**
     * Calcula la cuota constante del prestamo basada en el importe, plazo en meses y porcentaje de interes.
     * @return El valor de la cuota constante del prestamo.
     */
	public double calcularImporteInteres() {
        double totalInteres = 0;
		for(int i = 0; i < plazoEnMeses; i++)
	        totalInteres += arrayCuotas.get(i).getImporteIntereses();
		return totalInteres;
	}
	
	/**
	 * Calcula el nivel de comodidad para pagar la cuota del prestamo en base a los ingresos del solicitante.
	 * @return Una descripción del nivel de comodidad para pagar la cuota del prestamo.
	 */
	public String calcularComodidad() {
	    String comodidadParaPagar;
	    
	    if (calcularCuotaConst() <= solicitante.getIba() * 0.2)
	        comodidadParaPagar = CADENA_COMODIDAD_MB;
	    else if (calcularCuotaConst() <= solicitante.getIba() * 0.3)
	        comodidadParaPagar = CADENA_COMODIDAD_B;
	    else if (calcularCuotaConst() <= solicitante.getIba() * 0.4)
	        comodidadParaPagar = CADENA_COMODIDAD_R;
	    else
	        comodidadParaPagar = CADENA_COMODIDAD_D;
	    
	    return comodidadParaPagar;
	}

}
