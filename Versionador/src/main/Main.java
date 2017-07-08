package main;

public class Main {

	public static void main(String[] args) {
		C1 c1=new C1(1,1,1);
		C1 c2=new C1(1,1,2);
		C1 c3=new C1(1,1,3);
		
		System.out.println("Base Inicial");
		System.out.println(ObtenedorDeInformacionDeObjeto.traerInformacionDeAtributos(c1).obtenerAtributosJSON());
		System.out.println(ObtenedorDeInformacionDeObjeto.traerInformacionDeAtributos(c2).obtenerAtributosJSON());
		System.out.println(ObtenedorDeInformacionDeObjeto.traerInformacionDeAtributos(c3).obtenerAtributosJSON());
		
		IdentityMap.add(c1,c1.getId());
		IdentityMap.add(c2,c2.getId());
		IdentityMap.add(c3,c3.getId());
		

		UnitOfWork uow=new UnitOfWork();
		
		
		System.out.println("Se modifica el objeto id=1");
		C1 cmodif= (C1) IdentityMap.get(1);
		cmodif.setC1variableEntero1(3000);

		uow.registraDirty(cmodif);
		
		System.out.println("Se modifica el objeto id=2");
		C1 cmodif2=(C1) IdentityMap.get(2);
		cmodif2.setC1variableEntero2(2500);

		uow.registraDirty(cmodif2);

		System.out.println("Se modifica el objeto id=2 se vuelve atras el cambio");

		cmodif2.setC1variableEntero2(1);
		uow.registraDirty(cmodif2);

		
		System.out.println("Se toma el objeto id=3 para eliminar");
		C1 cmodif3=(C1) IdentityMap.get(3);

		uow.registraRemoved(cmodif3);

		
		System.out.println("se crea el objeto id=4");
		C1 alta=new C1(99,99,4);
		
		uow.registraNuevo(alta);

		System.out.println("Se realizan commits ");
		

		uow.commit();
		
		
		
	}

}
