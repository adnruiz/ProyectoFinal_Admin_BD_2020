package modelo;

public class Botellas {
	private int id_B;
	private String nombre_botella;
	private Double precio_botella;
	private Double nivel_alcohol;
	private String tipo_destilado;
	private int cantidad_botellas;
	
	//CONSTRUCTOR1
	public Botellas() {}

	public Botellas(int id_B, String nombre_botella, Double precio_botella, Double nivel_alcohol, String tipo_destilado,
			int cantidad_botellas) {
		super();
		this.id_B = id_B;
		this.nombre_botella = nombre_botella;
		this.precio_botella = precio_botella;
		this.nivel_alcohol = nivel_alcohol;
		this.tipo_destilado = tipo_destilado;
		this.cantidad_botellas = cantidad_botellas;
	}
	//CONSTRUCTOR2
	public Botellas(String nombre_botella, Double precio_botella, Double nivel_alcohol, String tipo_destilado,
			int cantidad_botellas) {
		super();
		this.nombre_botella = nombre_botella;
		this.precio_botella = precio_botella;
		this.nivel_alcohol = nivel_alcohol;
		this.tipo_destilado = tipo_destilado;
		this.cantidad_botellas = cantidad_botellas;
	}
	
	
	public Botellas(int id_B, int cantidad_botellas) {
		super();
		this.id_B = id_B;
		this.cantidad_botellas = cantidad_botellas;
	}

	//GETTERS & SETTERS
	public int getId_B() {
		return id_B;
	}

	public void setId_B(int id_B) {
		this.id_B = id_B;
	}

	public String getNombre_botella() {
		return nombre_botella;
	}

	public void setNombre_botella(String nombre_botella) {
		this.nombre_botella = nombre_botella;
	}

	public Double getPrecio_botella() {
		return precio_botella;
	}

	public void setPrecio_botella(Double precio_botella) {
		this.precio_botella = precio_botella;
	}

	public Double getNivel_alcohol() {
		return nivel_alcohol;
	}

	public void setNivel_alcohol(Double nivel_alcohol) {
		this.nivel_alcohol = nivel_alcohol;
	}

	public String getTipo_destilado() {
		return tipo_destilado;
	}

	public void setTipo_destilado(String tipo_destilado) {
		this.tipo_destilado = tipo_destilado;
	}

	public int getCantidad_botellas() {
		return cantidad_botellas;
	}

	public void setCantidad_botellas(int cantidad_botellas) {
		this.cantidad_botellas = cantidad_botellas;
	}
	
	//METODO toString
	@Override
	public String toString() {
		return "Botellas [id_B=" + id_B + ", nombre_botella=" + nombre_botella + ", precio_botella=" + precio_botella
				+ ", nivel_alcohol=" + nivel_alcohol + ", tipo_destilado=" + tipo_destilado + ", cantidad_botellas="
				+ cantidad_botellas + "]";
	}
	
	
}
