package dio.lista_jogos.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "tb_genero")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeOriginalGenero;
    @Column(unique = true)
    private String nomeNormalizado;

    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Jogos> jogos = new ArrayList<>();

    public Genero() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeOriginalGenero() {
        return nomeOriginalGenero;
    }

    public void setNomeOriginalGenero(String nomeOriginalGenero) {
        this.nomeOriginalGenero = nomeOriginalGenero;
    }

    public String getNomeNormalizado() {
        return nomeNormalizado;
    }

    public void setNomeNormalizado(String nomeNormalizado) {
        this.nomeNormalizado = nomeNormalizado;
    }

    @JsonCreator
    public static Genero fromString(String value) {
        Genero g = new Genero();
        g.setNomeOriginalGenero(value);
        return g;
    }
}
