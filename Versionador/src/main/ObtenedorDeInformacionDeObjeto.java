package main;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObtenedorDeInformacionDeObjeto {


	
	public static Atributo traerInformacionDeAtributos( Object o ){

		Atributo atributoR = null,atrAux = null;
		
		if(o==null ){
			return null;
		}
		
		Class<? extends Object> clase = o.getClass();
		
		Field[] atributos = clase.getDeclaredFields();			

		atributoR = new AtributoCompuesto();

		for (Field atr: atributos){
			atr.setAccessible(true);
			if (atr.getType().isPrimitive()){			
				atrAux=new AtributoSimpleObjeto(atr.getName(),atr.getType().getSimpleName(),buscaObjeto(atr,o).toString());
			}else{
				atrAux=traerInformacionDeAtributos(buscaObjeto(atr,o));
				atrAux.setNombre(atr.getName());
				atrAux.setTipo(atr.getType().getSimpleName());

			}

			atributoR.agregarHijo(atrAux);		

		}
	
		return atributoR;

}	
	
	private static Object buscaObjeto(Field atr, Object o){
		Object a = null;
		atr.setAccessible(true);			
		try {
			a = atr.get(o);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
	
		}
		return a;
		
	}
	
	public static String mostrarNombreDeClase(Object cx){
		if(cx==null ){
			return "El objeto no debe ser nulo";
		}
		
		Class<? extends Object> clase = cx.getClass();
		return clase.getSimpleName();

	}
	
	
	
	
	

}
