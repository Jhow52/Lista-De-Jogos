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
    private String nomeOriginal;
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

    public String getNomeOriginal() {
        return nomeOriginal;
    }

    public void setNomeOriginal(String nomeOriginal) {
        this.nomeOriginal = nomeOriginal;
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
        g.setNomeOriginal(value);
        return g;
    }
}
