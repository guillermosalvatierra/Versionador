package main;

public class UtilidadesJson {

	public static String encapsularCadenaJson(String cadena) {
		return "{" + cadena + "}";
	}

	public static String desEncapsularCadenaJson(String cadena) {
		cadena.substring(1, cadena.length() - 1);
		return cadena.substring(1, cadena.length() - 1);
	}

	public static String encapsularAtributoConSeparador(String cadena, int inicio, int fin) {
		if (!esUltimaIteracion(inicio, fin)) {
			cadena += ",";
			return cadena;
		}
		return cadena;
	}

	public static boolean esUltimaIteracion(int inicio, int fin) {
		return (inicio + 1) == fin;
	}

	public static String obtenerAtributoConSeparador(String cadena) {
		String cadenaAux="";
		while (!cadena.isEmpty()) {
			
			if(cadena.indexOf(',')>0){
				cadenaAux = cadena.substring(cadena.indexOf(':') + 1, cadena.indexOf(',') );			
				cadena = cadena.substring(cadena.indexOf(',') + 1, cadena.length());
			}else{
				cadenaAux = cadena.substring(cadena.indexOf(':') + 1, cadena.length());			
				cadena ="";
			}
		}
		return cadenaAux;
	}

}
