package main;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Clonador {

	public static Object Clone(Object src){
		
		try {
			Class<? extends Object> clase = src.getClass();

			 Constructor constructorSinParametros = clase.getConstructor();
				
			 Object nuevoObjetoDeMiClase =  constructorSinParametros.newInstance();
		 
	    copiaAtributos(src, nuevoObjetoDeMiClase, src.getClass());
	    return nuevoObjetoDeMiClase;
	    
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private static void copiaAtributos(Object src, Object dest, Class<?> clase) {
	    Field[] fields = clase.getDeclaredFields();
	    for (Field f : fields) {
	        f.setAccessible(true);
	        copiaValorAtributo(src, dest, f);
	    }

	    clase = clase.getSuperclass();
	    if (clase != null) {
	        copiaAtributos(src, dest, clase);
	    }
	}

	private static void copiaValorAtributo(Object src, Object dest, Field f) {
	    try {
	        Object value = f.get(src);
	        f.set(dest, value);
	    } catch (ReflectiveOperationException e) {
	        throw new RuntimeException(e);
	    }
	}
}
