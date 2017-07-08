package test;

import static org.junit.Assert.*;


import org.junit.Test;

import main.AtributoSimpleObjeto;
import main.C1;

public class AtributoSimpleObjetoTest {

	AtributoSimpleObjeto atrSimpleInt=  new AtributoSimpleObjeto("VariableInt","int","1");
	AtributoSimpleObjeto atrSimpleInt2= new AtributoSimpleObjeto("VariableInt","int","1");
	AtributoSimpleObjeto atrSimpleBool = new AtributoSimpleObjeto("VariableBolean","boolean","true");


	@Test
	public void ValidaJson() {
		
		assertFalse(atrSimpleInt.obtenerAtributosJSON().isEmpty());
	
	}
	
	@Test
	public void ValidaUnAtributoBoolean() {
		assertEquals(atrSimpleBool.getNombre(),"VariableBolean");
		assertEquals(atrSimpleBool.getTipo(),"boolean");
		assertEquals(atrSimpleBool.getValor(),"true");
	
	}
	
	@Test
	public void ValidaUnAtributoInt() {

		assertEquals(atrSimpleInt.getNombre(),"VariableInt");
		assertEquals(atrSimpleInt.getTipo(),"int");
		assertEquals(atrSimpleInt.getValor(),"1");
	
	}


	@Test
	public void CompruebaGethijo(){

		assertEquals(atrSimpleInt.getHijo(0),null);
	}

	
	@Test
	public void CompruebaEquals(){
	
		assertTrue(atrSimpleInt.equals(atrSimpleInt2));
		
		assertTrue(atrSimpleInt.equals(atrSimpleInt));
	
		assertFalse(atrSimpleInt.equals(atrSimpleBool));
		
		assertFalse(atrSimpleInt.equals(null));
		
		assertFalse(atrSimpleInt.equals(new C1(2,2,1)));
		
	}
	
	@Test
	public void CompruebaEqualsNombreDistinto(){
		atrSimpleInt2.setNombre("int2");		
		assertFalse(atrSimpleInt.equals(atrSimpleInt2));

	}

	@Test
	public void CompruebaEqualsTipoDistinto(){
		atrSimpleInt2.setTipo("int2");
		assertFalse(atrSimpleInt.equals(atrSimpleInt2));

	}

	@Test
	public void AgregarHijo(){
		AtributoSimpleObjeto a1= new AtributoSimpleObjeto("VariableInt","int","1");
		AtributoSimpleObjeto a2= new AtributoSimpleObjeto("VariableInt","int","1");
		a1.agregarHijo(a2);
		assertEquals(a1,a1);
	}
	
	
	
}
