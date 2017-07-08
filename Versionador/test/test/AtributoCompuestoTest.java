package test;

import static org.junit.Assert.*;


import org.junit.Test;

import main.AtributoCompuesto;
import main.AtributoSimpleObjeto;
import main.Atributo;

public class AtributoCompuestoTest {
	int Atrib1=0,Atrib2=1;
	
	AtributoCompuesto atriCompuesto1= new AtributoCompuesto();
	AtributoCompuesto atriCompuesto2= new AtributoCompuesto();
	Atributo b = new AtributoSimpleObjeto("VariableInt","int","1");
	Atributo c = new AtributoSimpleObjeto("VariableInt","int","2");
	Atributo d = new AtributoSimpleObjeto("VariableBolean","boolean","true");
	
	
	@Test
	public void ValidaJsonAtributoCompuesto() {
		atriCompuesto1.agregarHijo(b);	
		assertFalse(atriCompuesto1.obtenerAtributosJSON().isEmpty());
	}

	@Test
	public void ValidaDosAtributosInt() {
		atriCompuesto1.agregarHijo(b);
		atriCompuesto1.agregarHijo(c);
		assertTrue(atriCompuesto1.getHijo(Atrib1).equals(b));
		assertTrue(atriCompuesto1.getHijo(Atrib2).equals(c));
	}
	

	@Test
	public void ValidaUnAtributosBoolean() {
		atriCompuesto1.agregarHijo(d);
		assertTrue(atriCompuesto1.getHijo(Atrib1).equals(d));
	}
	
	@Test
	public void CompruebaAtributoEquals(){
		atriCompuesto1.setNombre("Objeto");
		atriCompuesto1.setTipo("o");
	
		atriCompuesto2.setNombre("Objeto");
		atriCompuesto2.setTipo("o");
		
		assertTrue(atriCompuesto1.equals(atriCompuesto1));

		assertTrue(atriCompuesto1.equals(atriCompuesto2));

		assertFalse(atriCompuesto1.equals(null));
		
		assertFalse(atriCompuesto1.equals(new String("Prueba")));
		
		


	}
		
	@Test
	public void CompruebaNombreAtributoEquals(){
		atriCompuesto1.setNombre("Objeto");
		atriCompuesto1.setTipo("o");
		
		atriCompuesto2.setNombre("Objeto2");
		atriCompuesto2.setTipo("o");

		assertFalse(atriCompuesto1.equals(atriCompuesto2));		
	}

	@Test
	public void CompruebaTipoAtributoEquals(){
		atriCompuesto1.setNombre("Objeto");
		atriCompuesto1.setTipo("o");

		atriCompuesto2.setNombre("Objeto2");
		atriCompuesto2.setTipo("o");

		assertFalse(atriCompuesto1.equals(atriCompuesto2));		
	}

	
	@Test	
	public void ValidaValorNulo(){

		assertEquals(atriCompuesto1.getValor(),null);
	}
	
	@Test
	public void ValidaJsonAtributoCompuestoConNombre() {

		atriCompuesto1.setNombre("ValidaConNombre");
		assertFalse(atriCompuesto1.obtenerAtributosJSON().isEmpty());
		
	}
}
