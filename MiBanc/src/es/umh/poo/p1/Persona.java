package es.umh.poo.p1;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Clase que representa a una persona, validando lo que se introduce.
 */
public class Persona {
	
	private static final String ERROR_FECHA_FORMATO = "Formato de fecha incorrecto.";
	private static final String ERROR_FECHA_LOGICO = "La fecha no puede ser posterior a la actual.";
	private static final String CADENA_FECHA_FORMATO = "dd/MM/yyyy";

	
	private String nombre, apellido1, apellido2 ;
	private LocalDate fecha;
	private Float iba;
	 
	// NOMBRE ------------------------------------------
	/**
	 * Devuelve el nombre de la persona.
	 * @return El nombre de la persona.
	 */
	public String getNombre() {
	    return nombre;
	}

	/**
	 * Establece el nombre de la persona, sin permitir que sea:
	 * - Null
	 * - Vacío
	 * - Carácteres no validos para un nombre.
	 * 
	 * @param nombre El nombre que se quiere poner.
	 * @throws Exception Si el nombre es nulo, está vacío o contiene caracteres no validos.
	 */
	public void setNombre(String nombre) throws Exception {
	    if (nombre == null || nombre.trim().isEmpty()) {
	        throw new Exception();
	    }
	    if (!nombre.matches("^[a-zA-Z\\s]+$")) {
	        throw new Exception();
	    }
	    this.nombre = nombre;
	}
	
	// APELLIDO1 ------------------------------------------
	/**
	 * Devuelve el primer apellido de la persona.
	 * @return El primer apellido de la persona.
	 */
	public String getApellido1() {
	    return apellido1;
	}

	/**
	 * Establece el primer apellido de la persona, sin permitir que sea:
	 * - Null
	 * - Vacio
	 * - Carácteres no validos para un nombre. 
	 * @param apellido1 El primer apellido que se quiere poner.
	 * @throws Exception Si el apellido es nulo, está vacio o contiene caracteres no validos.
	 */
	public void setApellido1(String apellido1) throws Exception {
	    if (apellido1 == null || apellido1.trim().isEmpty()) {
	        throw new Exception();
	    }
	    if (!nombre.matches("^[a-zA-Z\\s]+$")) {
	        throw new Exception();
	    }
	    this.apellido1 = apellido1;
	}
	
	// APELLIDO2 ------------------------------------------
	/**
	 * Devuelve el segundo apellido de la persona. 
	 * @return El segundo apellido de la persona.
	 */
	public String getApellido2() {
	    return apellido2;
	}

	/**
	 * Establece el segundo apellido de la persona, en este caso puede ser nullo o vacio.
	 * @param apellido2 El segundo apellido que se quiere poner.
	 * @throws Exception Si el apellido contiene caracteres no validos.
	 */
	public void setApellido2(String apellido2) throws Exception {
		if (!nombre.matches("^[a-zA-Z\\s]+$")) {
	        throw new Exception();
	    }
	    this.apellido2 = apellido2;
	}

	// FECHA ------------------------------------------
	/**
	 * Devuelve la fecha.
	 * @return La fecha almacenada en el objeto.
	 */
	public LocalDate getFecha() {
	    return fecha;
	}

	/**
	 * Establece la fecha, dado el fomrato "dd/MM/yyyy", validandolo, en caso contrario 
	 * lanzara una excepcion con un mensaje de ERROR dado el caso.
	 * @param fechaString Una fecha con dia, mes y anyo.
	 * @throws Exception Si la fecha no esta en el formato adecuado o si es posterior a la fecha actual.
	 */
	public void setFecha(String fechaString) throws Exception {
	    try {
	        LocalDate fechaValidada = LocalDate.parse(fechaString, DateTimeFormatter.ofPattern(CADENA_FECHA_FORMATO));
	        LocalDate fechaActual = LocalDate.now();

	        if (fechaValidada.isAfter(fechaActual)) {
	            throw new Exception(ERROR_FECHA_LOGICO);
	        } else {
	            fecha = fechaValidada;
	        }
	    } catch (DateTimeParseException e) {
	        throw new Exception(ERROR_FECHA_FORMATO);
	    }
	}

	
	// SALARIO BRUTO ANUAL ------------------------------------------
	/**
	 * Devuelve el valor del IBA (Ingreso del salario bruto anual).
	 * @return El valor del IBA.
	 */
	public float getIba() {
	    return iba;
	}

	/**
	 * Establece el valor del IBA (Ingreso del salario bruto anual).
	 * @param iba El valor del IBA a establecer.
	 * @throws Exception Si se intenta establecer un valor no valido (menor o igual a 0).
	 */
	public void setIba(float iba) throws Exception {
	    this.iba = iba;
	}
 
    
	// FUNCIONES ---------------------------------------------------------------

    /**
     * Dado una variable tipo LocalDate, calcula la diferencia entre la fecha actua 
     * y la fecha que contenga esa variable que se le ha pasado devolveindo la anyos que hay.
     * @param fechaDeNacimiento Debe de ser un parametro VALIDOS con un día, mes y anyo.
     * @return Retorna un entero de los anyos, truncando los decimales.
     */
    public static int calcularEdad(LocalDate fechaDeNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaDeNacimiento, fechaActual).getYears();
    }
    
    /**
     * Calcula la edad anyadiendo los meses proporcionados a la fecha de nacimiento
     * y luego calculando la diferencia de anyos con la fecha actual.
     * @param fechaDeNacimiento Fecha de nacimiento en LocalDate
     * @param meses Meses a anyadir a la fecha de nacimiento
     * @return Edad en anyos teniendo en cuenta los meses adicionales
     */
    public static int calcularEdad(LocalDate fechaDeNacimiento, int meses) {
        LocalDate fechaConMeses = fechaDeNacimiento.plusMonths(meses);
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaConMeses, fechaActual).getYears();
    }
}
