package dio.lista_jogos.service;

import dio.lista_jogos.model.Genero;

import java.util.List;

public interface GeneroService {
    Genero create(Genero generoCriado);
    Genero criarOuBuscarGenero(String nomeOriginal);
}
