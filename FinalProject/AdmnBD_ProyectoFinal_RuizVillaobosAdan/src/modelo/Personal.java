package modelo;

public class Personal {
	private String id;
	private String nombre;
	private String primerAp;
	private String segundoAp;
	private String puesto;
	private String hSalida;
	private String hEntrada;
	private int sueldo;
	private int diasTrabajados;
	
	//CONTRUCTOR
	public Personal() {}
	
	public Personal(String id, String nombre, String primerAp, String segundoAp, String puesto, String hSalida,
			String hEntrada, int sueldo, int diasTrabajados) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.primerAp = primerAp;
		this.segundoAp = segundoAp;
		this.puesto = puesto;
		this.hSalida = hSalida;
		this.hEntrada = hEntrada;
		this.sueldo = sueldo;
		this.diasTrabajados = diasTrabajados;
	}
	
	public Personal( String nombre, String primerAp, String segundoAp, String puesto, String hSalida,
			String hEntrada, int sueldo, int diasTrabajados) {
		super();
		
		this.nombre = nombre;
		this.primerAp = primerAp;
		this.segundoAp = segundoAp;
		this.puesto = puesto;
		this.hSalida = hSalida;
		this.hEntrada = hEntrada;
		this.sueldo = sueldo;
		this.diasTrabajados = diasTrabajados;
	}
	//GETTERS & SETTERS
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerAp() {
		return primerAp;
	}

	public void setPrimerAp(String primerAp) {
		this.primerAp = primerAp;
	}

	public String getSegundoAp() {
		return segundoAp;
	}

	public void setSegundoAp(String segundoAp) {
		this.segundoAp = segundoAp;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String gethSalida() {
		return hSalida;
	}

	public void sethSalida(String hSalida) {
		this.hSalida = hSalida;
	}

	public String gethEntrada() {
		return hEntrada;
	}

	public void sethEntrada(String hEntrada) {
		this.hEntrada = hEntrada;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public int getDiasTrabajados() {
		return diasTrabajados;
	}

	public void setDiasTrabajados(int diasTrabajados) {
		this.diasTrabajados = diasTrabajados;
	}
	
	//METODO toString
	@Override
	public String toString() {
		return "Personal [id=" + id + ", nombre=" + nombre + ", primerAp=" + primerAp + ", segundoAp=" + segundoAp
				+ ", puesto=" + puesto + ", hSalida=" + hSalida + ", hEntrada=" + hEntrada + ", sueldo=" + sueldo
				+ ", diasTrabajados=" + diasTrabajados + "]";
	}
	
	
	
	
}
