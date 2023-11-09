package proyect.bean;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class OfertaTreball {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titol;
    @ManyToOne
    private Empresa empresa;


    public OfertaTreball(Long id, String titol, Empresa empresa) {
        this.id = id;
        this.titol = titol;
        this.empresa = empresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "OfertaTreball{" +
                "id=" + id +
                ", titol='" + titol + '\'' +
                ", empresa=" + empresa +
                '}';
    }
}
