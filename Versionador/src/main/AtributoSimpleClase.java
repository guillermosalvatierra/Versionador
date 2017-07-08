package main;

public class AtributoSimpleClase extends Atributo {


	public AtributoSimpleClase(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;

	}
	
	@Override
	public void agregarHijo(Atributo composicion) {
	//no se usa
	}

	@Override
	public String obtenerAtributosJSON() {
	
		return "{"+'"'+ covertirJson()+ '"'+"}";
	}

	@Override
	public String getValor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String covertirJson() {
		// TODO Auto-generated method stub
		String cadenaJson = "";
	    cadenaJson ='"'+ nombre+ '"';		
		return cadenaJson;
	}

	@Override
	public Atributo getHijo(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
