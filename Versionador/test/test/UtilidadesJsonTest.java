package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.UtilidadesJson;

public class UtilidadesJsonTest {

	@Test
	public void encapsularCadenaJsonTest() {
		String aux = "Hola";
		String resultado = UtilidadesJson.encapsularCadenaJson(aux);
		assertEquals("{Hola}",resultado);
	}
	
	@Test
	public void encapsularAtributoConSeparador(){
		String aux = "Hola";
		String resultado = UtilidadesJson.encapsularAtributoConSeparador(aux, 1, 4);
		assertEquals("Hola,",resultado);
	}
	
	@Test
	public void esUltimaIteracion(){
		assertFalse(UtilidadesJson.esUltimaIteracion(4, 4));
		assertTrue(UtilidadesJson.esUltimaIteracion(1, 2));
	}
	
	@Test
	public void creaUtilidadesJson(){
		UtilidadesJson u=new UtilidadesJson();
		boolean esUltimaIteracion = u.esUltimaIteracion(1, 2);
		assertTrue(esUltimaIteracion);
	}
}
