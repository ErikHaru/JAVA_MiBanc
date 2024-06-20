package es.umh.poo.p1;

import java.util.ArrayList;
import java.util.Scanner;
import es.umh.poo.p1.Prestamo.TPrestamo;

/**
 * Clase principal que manipula la interaccion con el usuario para solicitar datos de persona y prestamo, 
 * tambien dando la posibilidad de mostrar la informacion.
 */
public class Main {
	
	private static final String ERROR_GENERAL = "Algo ha salido mal, disculpe las molestias.";
	// pedirDatosPer
	private static final String CADENA_NOMBRE = "Nombre: ";
	private static final String CADENA_APELLIDO1 = "Primer apellido: ";
	private static final String CADENA_APELLIDO2 = "Segundo apellido: ";
	private static final String CADENA_FECHA = "Fecha de nacimiento dd/MM/aaaa: ";
	private static final String CADENA_SALARIO_BRUTO = "Salario bruto: ";
	private static final String ERROR_NOMBRE = "Se han utilizado caracteres no validos.";
	private static final String ERROR_FECHA_FORMATO = "Fecha inválida, revise la el formato o los números.";
	private static final String ERROR_SALARIO_BRUTO = "Salario inválida, deben de ser núemeros positivos.";
	// pedirDatosCre
	private static final String CADENA_INTRODUCIR_PALABRA = "Introduzca LA PALABRA del tipo de prestamo que desea: ";
	private static final String CADENA_PERSONAL = "    PERSONAL";
	private static final String CADENA_HIPOTECARIO = "    HIPOTECARIO";
	private static final String CADENA_INTRODUCIR_NUMERO = "Introduzca EL NÚMERO del tipo que desea: ";
	private static final String CADENA_IMPORTE_A_SOLICITAR = "Importe a solicitar: ";
	private static final String CADENA_PLAZOS_DE_AMORTIZACION = "Plazos de amortización (meses): ";
	private static final String ERROR_TIPO_PRESTAMO = "Tipo de prestamo no reconocido.";
	private static final String ERROR_IMPORTE = "Importe inválido, recuerde que no puede superar el importe máximo.";
	private static final String ERROR_PLAZOS = "Plazo inválido, recuerde que no puede superar el plazo máximo.";
	// datosInforme
	private static final String CADENA_INFORME = "Introduzca LA PALABRA del tipo de informe que desea viusualizar: ";
	private static final String CADENA_INFORME_RESUMEN = "    RESUMEN";
	private static final String CADENA_INFORME_DETALLADO = "    DETALLADO";
	private static final String ERROR_INFORME = "Tipo de informe no reconocido.";
	
	private static Scanner scanIn = new Scanner(System.in);

	private static ArrayList<TipoPrestamo> arrayPrestamos;

	/**
	 * Donde se ejecuta el programa y se puede manipular todo.
	 * En caso de que se le mande una excepción, se imprimirá y se termina el programa.
	 * @param args  Argumentos de línea de comandos, NO se usa.
	 * @throws Exception En caso de que algo salga mal o que el programa decida terminar.
	 */
	public static void main(String[] args) throws Exception {

		try {
			Persona per1 = new Persona();
			pedirDatosPersona(per1);

			Prestamo prest = new Prestamo(per1);
			pedirDatosPrestamo(prest);
			
			mostrarDatosCredito(prest);

		} catch (Exception e) {
			if(e.getMessage() != null && e.getMessage().isEmpty())
				System.out.println(ERROR_GENERAL);
			else
				System.out.println(e.getMessage());
			System.exit(0);
		}


	}

	/**
	 * Dado una cadena tipo String, nos la imprime por pantalla y lee por pantalla,
	 * retornando la cadena que lee tipo string.
	 * 
	 * @param cadena Es la cadena que se quiere imprimir.
	 * @return Se lee por pantalla y se retorna la cadena tipo String.
	 */
	private static String imprimir(String cadena) {
		System.out.println(cadena);

		return (scanIn.nextLine());
	}

	/**
	 * Pide al usuario, usando la función "imprimir": 
	 * 1. Nombre. 
	 * 2. Apellido 1. 
	 * 3. Apellido 2. 
	 * 4. Fecha de naciemiento. 
	 * 5. Salario bruto. Estos los guarda en una clase tipo Persona.
	 * 
	 * @param per1 Es la clase tipo Persona donde se quiere guardar los datos
	 */
	private static void pedirDatosPersona(Persona per1) {
		boolean correcto = false;

		while (correcto == false) {
			try {
				per1.setNombre(imprimir(CADENA_NOMBRE));
				per1.setApellido1(imprimir(CADENA_APELLIDO1));
				per1.setApellido2(imprimir(CADENA_APELLIDO2));
				correcto = true;
			} catch (Exception e) {
				System.out.println(ERROR_NOMBRE);
			}
		}
		
		correcto = false;
		while (correcto == false) {	
			try {
				per1.setFecha(imprimir(CADENA_FECHA));
				correcto = true;
			} catch (Exception e) {
				System.out.println(ERROR_FECHA_FORMATO);
			}
		}
		
		correcto = false;
		while (correcto == false) {	
			try {
				per1.setIba(Integer.parseInt(imprimir(CADENA_SALARIO_BRUTO)));
				correcto = true;
			} catch (Exception e) {
				System.out.println(ERROR_SALARIO_BRUTO);
			}
		}

	}

	/**
	 * Pide al usuario, usando la función "imprimir": 
	 * 1. El tipo de prestamo que quiere solicitar imprimiendo solo las características de ese tipo. 
	 * 2. El importe que dispone la persona. 
	 * 3. El plazo con el que quiere amortizar la persona el importe. Todos los datos solicitados se guardan
	 * en una clase tipo Prestamo, en caso de introducir información inválida lanza una excepción imprimiendo
	 * por pantalla el error.
	 * 
	 * @param prest  Es la clase tipo prestamo donde se quiere guardar los datos
	 * @throws Exception En caso de que el usuario no introduzca lo que se le solicita
	 */
	private static void pedirDatosPrestamo(Prestamo prest) throws Exception {
		boolean correcto = false;

		// Solicitamos tipo de prestamo
		while (correcto == false) {
			try {

				arrayPrestamos = TipoPrestamo.damePrestamos();

				prest.setTipoPrestamo(TPrestamo.valueOf(
						imprimir(CADENA_INTRODUCIR_PALABRA + "\n" + CADENA_PERSONAL + "\n" + CADENA_HIPOTECARIO).toUpperCase()));

				if (prest.getTipoPrestamo() == TPrestamo.PERSONAL) {
					System.out.println("1 - " + arrayPrestamos.get(0).dameCadena());
					System.out.println("2 - " + arrayPrestamos.get(1).dameCadena());
				} else {
					System.out.println("3 - " + arrayPrestamos.get(2).dameCadena());
					System.out.println("4 - " + arrayPrestamos.get(3).dameCadena());
				}

				// Pedimos al usuario el tipo concreto y se lo pasamos a PRESTAMO
				prest.setTipo(arrayPrestamos.get(Integer.parseInt(imprimir(CADENA_INTRODUCIR_NUMERO)) - 1));
				correcto = true ;				

			} catch (Exception e) {
				System.out.println(ERROR_TIPO_PRESTAMO);
			}
		}
		
		// Solicitamos el importe que dispone la presona
		correcto = false;
		while(correcto == false) {
			try {
				prest.setImporte(imprimir(CADENA_IMPORTE_A_SOLICITAR));
				correcto = true;
			} catch (Exception a) {
				System.out.println(ERROR_IMPORTE);
			}
		}
		
		// Solicitamos en el plazo que quiere amortizarlo
		correcto = false;
		while(correcto == false) {	
			try {
				prest.setPlazoEnMeses(imprimir(CADENA_PLAZOS_DE_AMORTIZACION));
				correcto = true;

			} catch (Exception c) {
				System.out.println(ERROR_PLAZOS);
			}
		}
	}
	
	/**
	 * Solicita al usuario el tipo de informe que desea, RESUMEN o DETALLADO, imprimiendo los datos de del seleccionado.
	 * En caso de fallar lanza una excepcion del respectivo error.
	 * @param prest variable tipo Pretamo.
	 * @throws Exception En caso de no haber seleccionado correctamente el numero o que falle la impresión del informe
	 */
	private static void mostrarDatosCredito(Prestamo prest) throws Exception {
		
		String cad;
		boolean correcto = false;
		
		while(correcto == false) {
			cad = imprimir(CADENA_INFORME + "\n" + CADENA_INFORME_RESUMEN+ "\n" + CADENA_INFORME_DETALLADO );
	
			if(cad.compareTo("1") != 0 && cad.compareTo("2") != 0 )
				System.out.println(ERROR_INFORME);
			else {
				try {
					if (cad.compareTo("1") == 0)
						System.out.println(prest.imprimirResumen());
					if (cad.compareTo("2") == 0)
						System.out.println(prest.imprimirDetallado());
				} catch (Exception e) {
					throw new Exception (e.getMessage());
				}
				correcto = true;
			}	
		}
	}
	
	
	
}
