package main;

public abstract class Atributo {
		protected String nombre;
		protected String tipo;

	   
	   public abstract String obtenerAtributosJSON() ;
	   
	   public String getNombre(){return nombre;}
       public String getTipo()  {return tipo;}
	   public void setNombre(String nombre) {this.nombre = nombre; }
	   public void setTipo(String tipo) {this.tipo = tipo; }
       public abstract String getValor();
	   protected abstract String covertirJson();

	   public abstract void agregarHijo(Atributo composicion);
	   public abstract Atributo getHijo(int index);


	    

		
}
