package main;

import java.lang.reflect.Field;

public class ObtenedorDeInformacionDeClase {


	public Atributo traerInformacionDeAtributos(String nombreClase) {

		Atributo atributoC = null, atriAux = null;
		String tipoAtributo, nombreAtributo, claseAtributo;

		Class<? extends Object> clase = null;

		try {
			clase = Class.forName(nombreClase);

			Field[] atributos = clase.getDeclaredFields();

			atributoC = new AtributoCompuesto();

			for (Field atr : atributos) {
				atr.setAccessible(true);
				nombreAtributo = atr.getName();
				tipoAtributo = atr.getType().getSimpleName();
				atriAux = new AtributoSimpleClase(nombreAtributo, tipoAtributo);
				if (atr.getType().isPrimitive()) {
					atriAux = new AtributoSimpleClase(nombreAtributo, tipoAtributo);
				} else {
					atriAux=traerInformacionDeAtributos(atr.getType().getTypeName());
					if(atriAux!=null){
						atriAux.setNombre(nombreAtributo);
						atriAux.setTipo(tipoAtributo);
					}
				}
				atributoC.agregarHijo(atriAux);
			}
			

			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			return null;
		}

		return atributoC;
	}

}
