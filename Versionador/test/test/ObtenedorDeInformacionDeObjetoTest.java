package test;

import static org.junit.Assert.*;



import org.junit.Test;

import main.Atributo;
import main.C1;
import main.C2;
import main.ObtenedorDeInformacionDeObjeto;

public class ObtenedorDeInformacionDeObjetoTest {

	private C1 C1Test1=new C1(1,2,1);
	private C2 C2Test2=new C2(true);
	 
	private ObtenedorDeInformacionDeObjeto obte1=new ObtenedorDeInformacionDeObjeto();
	
	private Atributo atributoDeObtenedorC1Test= obte1.traerInformacionDeAtributos(C1Test1);
	
	private Atributo atributoDeObtenedorC2Test= obte1.traerInformacionDeAtributos(C2Test2);

	@Test
	public void ValidaObjetoPorNombreDeClase() {

		assertEquals("C1",obte1.mostrarNombreDeClase(C1Test1));
	
	}	
	

	@Test
	public void ValidaNULL() {

		assertEquals( obte1.mostrarNombreDeClase(null),"El objeto no debe ser nulo");
	
	}	
	
	@Test
	public void ValidaObjetoNULL() {

		assertEquals( obte1.traerInformacionDeAtributos(null),null);
	
	}	





	@Test
	public void ValidaNombreObjetoConDosAtributos() {

		assertEquals("C1variableEntero1",atributoDeObtenedorC1Test.getHijo(0).getNombre());
		assertEquals("C1variableEntero2",atributoDeObtenedorC1Test.getHijo(1).getNombre());	
	}

	@Test
	public void ValidaNombreObjetoConUnAtributo() {

		assertEquals("C2variableBoolean",atributoDeObtenedorC2Test.getHijo(0).getNombre());
	
	}


	
	@Test
	public void ValidaObjetoConDosAtributosEnteros() {		
	
		assertEquals("int",atributoDeObtenedorC1Test.getHijo(0).getTipo());
		assertEquals("int",atributoDeObtenedorC1Test.getHijo(1).getTipo());	
	
	}

	@Test
	public void ValidaObjetoConUnAtributoBoolean() {

	//	assertTrue(atributoDeObtenedorC2Test.getTipo().equals("boolean"));
		assertEquals("boolean",atributoDeObtenedorC2Test.getHijo(0).getTipo());
		
	}

	@Test
	public void ValidaObjetoConDosValoresEnteros() {		
	
	
		assertEquals("1",atributoDeObtenedorC1Test.getHijo(0).getValor());
		assertEquals("2",atributoDeObtenedorC1Test.getHijo(1).getValor());	
	
	}

	@Test
	public void ValidaObjetoConUnaValorBoolean() {
		assertEquals("true",atributoDeObtenedorC2Test.getHijo(0).getValor());


	}


	

}
