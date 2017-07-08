package main;

import java.util.ArrayList;
import java.util.List;

public class AtributoCompuesto extends Atributo{
	   protected List<Atributo> hijo = new ArrayList<Atributo>();

	  public AtributoCompuesto(){
	  }
	  
	  
	@Override
	public void agregarHijo(Atributo composicion) {
		hijo.add(composicion);
	}


	public String obtenerAtributosJSON() {
		return covertirJson() ;
	}


	@Override
	public Atributo getHijo(int index) {
		return hijo.get(index);
	}

	
	@Override
	protected String covertirJson() {
		// TODO Auto-generated method stub
		String cadenaJson = "";
		int index=0;
		for (Atributo c:hijo) {
			
			cadenaJson+=c.covertirJson();

			cadenaJson=UtilidadesJson.encapsularAtributoConSeparador(cadenaJson, index, hijo.size());
			index=index+1;
		}

		if(nombre!=null)
			cadenaJson='"'+nombre+'"'+':'+UtilidadesJson.encapsularCadenaJson(cadenaJson);
		else 
			cadenaJson=UtilidadesJson.encapsularCadenaJson(cadenaJson);	
		return cadenaJson;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		AtributoCompuesto other = (AtributoCompuesto) obj;
		if (!nombre.equals(other.nombre))
			return false;
		if (!tipo.equals(other.tipo))
			return false;
		
		return true;
	}


	@Override
	public String getValor() {
		return null;
	}

	public int getID(){
		int id=-1;
		for (Atributo h:hijo){
			if(h.nombre.equals("id")){
				id=Integer.parseInt(h.getValor());
			}
		}
		return id;
	}

	public int getVersion(){
		int id=-1;
		for (Atributo h:hijo){
			if(h.nombre.equals("version")){
				id=Integer.parseInt(h.getValor());
			}
		}
		return id;
	}	
}
