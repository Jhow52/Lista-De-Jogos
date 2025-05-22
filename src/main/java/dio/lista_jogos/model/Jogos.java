package dio.lista_jogos.model;

import jakarta.persistence.*;

@Entity(name = "tb_jogos")
public class Jogos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeJogo;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    public Jogos() {
    }

    public Jogos(String nomeJogo, Genero genero) {
        this.nomeJogo = nomeJogo;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nome) {
        this.nomeJogo = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
