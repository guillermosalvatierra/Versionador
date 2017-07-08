package main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MapperRegistry {

	public static void Insert(Object value) {

		System.out.println(ObtenedorDeInformacionDeObjeto.traerInformacionDeAtributos(value).obtenerAtributosJSON());
		// que no tengo DB aunque podria hacer otro mapa para realizar esto
	}

	public static void Update(Object value) {
		int id = tomaID(value);
		
		if(!ObtenedorDeInformacionDeObjeto.traerInformacionDeAtributos(IdentityMap.traerOriginal(id)).obtenerAtributosJSON().equals(ObtenedorDeInformacionDeObjeto.traerInformacionDeAtributos(value).obtenerAtributosJSON())){
			aumentaVersion(value);
			System.out.println(ObtenedorDeInformacionDeObjeto.traerInformacionDeAtributos(value).obtenerAtributosJSON());
		}
	}

	public static void Delete(Object value) {
		remueveVersion(value);// pone el numero de version en cero
		System.out.println(ObtenedorDeInformacionDeObjeto.traerInformacionDeAtributos(value).obtenerAtributosJSON());
	}

	public static int tomaID(Object obj) {

		Class<? extends Object> objetoDeClassConInfoDeMiClase = obj.getClass();
		int valorRetorno = -1;
		Method metodo;
		try {
			metodo = objetoDeClassConInfoDeMiClase.getMethod("getId", null);
			valorRetorno = (int) metodo.invoke(obj, null);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
			System.out.println("No se encontro el ID");
		}

		return valorRetorno;
	}

	public static int tomaVersion(Object obj) {

		Class<? extends Object> objetoDeClassConInfoDeMiClase = obj.getClass();
		int valorRetorno = -1;
		Method metodo;
		try {
			metodo = objetoDeClassConInfoDeMiClase.getDeclaredMethod("getVersion", null);
			valorRetorno = (int) metodo.invoke(obj, null);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se encontro la version");
		}

		return valorRetorno;
	}

	public static int aumentaVersion(Object obj) {

		Class<? extends Object> objetoDeClassConInfoDeMiClase = obj.getClass();
		int valorRetorno = -1;
		Method metodo;
		try {
			valorRetorno = tomaVersion(obj) + 1;
			metodo = objetoDeClassConInfoDeMiClase.getDeclaredMethod("setVersion", int.class);
			metodo.invoke(obj, valorRetorno);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
			System.out.println("No se pudo modificar la version");

		}

		return valorRetorno;
	}

	public static int remueveVersion(Object obj) {

		Class<? extends Object> objetoDeClassConInfoDeMiClase = obj.getClass();
		int valorRetorno = -1;
		Method metodo;
		try {
			metodo = objetoDeClassConInfoDeMiClase.getDeclaredMethod("setVersion", int.class);
			metodo.invoke(obj, 0);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
			System.out.println("No se pudo modificar la version");

		}

		return valorRetorno;
	}

}
