package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class UnitOfWork {
	
	private List<Object> newObjects = new ArrayList<Object>();
	private List<Object> dirtyObjects = new ArrayList<Object>();
	private List<Object> removedObjects = new ArrayList<Object>();

	
	public void registraNuevo(Object obj) {
		if( !dirtyObjects.contains(obj)&& !removedObjects.contains(obj)&& !newObjects.contains(obj)){
			newObjects.add(obj);	
		}
	}
		
	public void registraDirty(Object obj) {
		if (!dirtyObjects.contains(obj)&& !newObjects.contains(obj)) {
			dirtyObjects.add(obj);
		}
	}

	public void registraRemoved(Object obj) {
		if (newObjects.contains(obj)) return;
			dirtyObjects.remove(obj);
		if (!removedObjects.contains(obj))	
			removedObjects.add(obj);		
	}

	public void commit() {
		updateDirty();
		insertNew();
		remove();
	}
	
	private void updateDirty() {
		for (Iterator<Object> objects = dirtyObjects.iterator(); objects.hasNext();) {
			Object value =objects.next();
			MapperRegistry.Update(value);
		}
	}		
	
	private void insertNew() {
		for (Iterator<Object> objects = newObjects.iterator(); objects.hasNext();) {
			Object value =objects.next();
			MapperRegistry.Insert(value);
		}
	}

	private void remove() {
		for (Iterator<Object> objects = removedObjects.iterator(); objects.hasNext();) {
			Object value =objects.next();
			MapperRegistry.Delete(value);
		}
	}
}