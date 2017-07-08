package test;

import static org.junit.Assert.*;


import org.junit.Test;

import main.Atributo;
import main.ObtenedorDeInformacionDeClase;


public class ObtenedorDeInformacionDeClaseTest {


	private ObtenedorDeInformacionDeClase obte1=new ObtenedorDeInformacionDeClase();
	
	private Atributo atributoDeObtenedorC1Test= obte1.traerInformacionDeAtributos("main.C1");
	
	private Atributo atributoDeObtenedorC2Test= obte1.traerInformacionDeAtributos("main.C2");


	
	
	
	@Test
	public void ValidaObjetoConDosAtributos() {
		
		assertEquals("C1variableEntero1",atributoDeObtenedorC1Test.getHijo(0).getNombre());
		assertEquals("C1variableEntero2",atributoDeObtenedorC1Test.getHijo(1).getNombre());	

	}

	@Test
	public void ValidaObjetoConUnAtributo() {
		assertEquals("C2variableBoolean",atributoDeObtenedorC2Test.getHijo(0).getNombre());
		
		//assertEquals(atributoDeObtenedorC2Test.getHijo(0).getNombre(),"C2variableBoolean");
			
	
	}


	
	@Test
	public void ValidaObjetoConDosAtributosEnteros() {		
		
		assertEquals("int",atributoDeObtenedorC1Test.getHijo(0).getTipo());
		assertEquals("int",atributoDeObtenedorC1Test.getHijo(1).getTipo());	
	
		
	}

	@Test
	public void ValidaObjetoConUnAtributoBoolean() {
		
		assertEquals("boolean",atributoDeObtenedorC2Test.getHijo(0).getTipo());
		
			
	}

	@Test
	public void ValidaClaseNoExiste() {
		
		assertTrue(obte1.traerInformacionDeAtributos("main.NoExiste")==null);
		
			
	}



}
