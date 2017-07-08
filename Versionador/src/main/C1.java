package main;

public class C1  implements Cloneable{
	private int C1variableEntero1;
	private int C1variableEntero2;
	private int version=1;
	private int id;
	
	public C1() {
		super();
	}

	public C1(int variable,int variable2,int id) {

		this.C1variableEntero1 = variable;
		this.C1variableEntero2 = variable2;
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getId() {
		return id;
	}

	public int getC1variableEntero1() {
		return C1variableEntero1;
	}

	public void setC1variableEntero1(int c1variableEntero1) {
		C1variableEntero1 = c1variableEntero1;
	}

	public int getC1variableEntero2() {
		return C1variableEntero2;
	}

	public void setC1variableEntero2(int c1variableEntero2) {
		C1variableEntero2 = c1variableEntero2;
	}

	  @Override
	    protected Object clone() throws CloneNotSupportedException {
	        return super.clone();
	    }
}
