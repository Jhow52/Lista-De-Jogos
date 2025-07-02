package dio.lista_jogos.service.dto;

public class JogosResquestDTO {
    private String nomeJogo;
    private GeneroRequestDTO genero;

    public String getNomeJogo() {
        return nomeJogo;
    }

    public void setNomeJogo(String nomeJogo) {
        this.nomeJogo = nomeJogo;
    }

    public GeneroRequestDTO getGenero() {
        return genero;
    }

    public void setGenero(GeneroRequestDTO genero) {
        this.genero = genero;
    }
}
