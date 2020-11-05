package mejorasdecartas;

public abstract class PocionAbs {
	
	private String nombre, descripcion;
	private double valor;
	
	public PocionAbs(String nombre, String descripcion, double valor) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
		

}
