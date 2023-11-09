package proyect.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
    private String descripcion;

	public Empresa(Long id, String nombre, String direccion, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Empresa{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", direccion='" + direccion + '\'' +
				", descripcion='" + descripcion + '\'' +
				'}';
	}
}
