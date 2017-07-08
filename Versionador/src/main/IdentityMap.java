package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class IdentityMap {
	private static Map<Integer, Object> objects = new HashMap<Integer, Object>();
	private static Map<Integer, Object> objectsOrig = new HashMap<Integer, Object>();
	
	public static void add(Object obj, int key) {
		objectsOrig.put(key, obj);
		objects.put(key, Clonador.Clone(obj));
	}

	public static Object get(int key) {
		Object obj = objects.get(key);
		return obj;
	}


	public static Object traerOriginal(int key){
		return objectsOrig.get(key);
	}

	public static void limpiaMapa(){
		objectsOrig.clear();
		objects.clear();
	}

	
	
}
