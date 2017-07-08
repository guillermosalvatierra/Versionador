package test;

import static org.junit.Assert.*;


import org.junit.Test;

import main.Atributo;
import main.AtributoSimpleClase;

public class AtributoSimpleClaseTest {


	@Test
	public void ValidaJson() {
		
		AtributoSimpleClase a=  new AtributoSimpleClase("ValorEntero","int");
		
		assertFalse(a.obtenerAtributosJSON().isEmpty());
	
	}

	
	@Test
	public void ValidaUnAtributoBoolean() {

		Atributo b = new AtributoSimpleClase("VariableBolean","boolean");

		assertEquals(b.getNombre(),"VariableBolean");
		assertEquals(b.getTipo(),"boolean");
	
	}
	
	@Test
	public void ValidaUnAtributoInt() {

		Atributo b = new AtributoSimpleClase("VariableInt","int");
	
		assertEquals(b.getNombre(),"VariableInt");
		assertEquals(b.getTipo(),"int");

	}
	
	@Test
	public void CompruebaGethijo(){
		AtributoSimpleClase a1= new AtributoSimpleClase("VariableInt","int");

		assertEquals(a1.getHijo(0),null);
	}

	@Test
	public void CompruebaValorNulo(){
		AtributoSimpleClase a1= new AtributoSimpleClase("VariableInt","int");

		assertEquals(a1.getValor(),null);
	}
	
	@Test
	public void AgregarHijo(){
		AtributoSimpleClase a1= new AtributoSimpleClase("VariableInt","int");
		AtributoSimpleClase a2= new AtributoSimpleClase("VariableInt","int");
		a1.agregarHijo(a2);
		assertEquals(a1,a1);
	}
	
	
}
