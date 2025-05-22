package dio.lista_jogos.service.impl;

import dio.lista_jogos.handler.GeneroNotFoundException;
import dio.lista_jogos.model.Genero;
import dio.lista_jogos.repository.GeneroRepository;
import dio.lista_jogos.service.GeneroService;
import dio.lista_jogos.util.GeneroUtils;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static dio.lista_jogos.util.GeneroUtils.normalizar;

@Service
public class GeneroServiceImpl implements GeneroService{

    private final GeneroRepository generoRepository;

    public GeneroServiceImpl(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public List<Genero> findAll() {
        return generoRepository.findAll();
    }

    public Genero findById(Long id) {
        return generoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gênero não encontrado"));
    }

    public Genero create(Genero genero) {
        // Normaliza o nome para o campo nomeNormalizado
        String nomeNormalizado = normalizar(genero.getNomeOriginal());
        genero.setNomeNormalizado(nomeNormalizado);
        return generoRepository.save(genero);
    }

    public Genero criarOuBuscarGenero(String nomeGenero) {
        String nomeNormalizado = normalizar(nomeGenero);

        Optional<Genero> generoExistente = generoRepository.findByNomeNormalizado(nomeNormalizado);

        if (generoExistente.isPresent()) {
            return generoExistente.get();
        }

        Genero novoGenero = new Genero();
        novoGenero.setNomeOriginal(nomeGenero);
        novoGenero.setNomeNormalizado(nomeNormalizado);
        return generoRepository.save(novoGenero);
    }

    public String normalizar(String texto) {
        if (texto == null) return null;

        String textoSemAcento = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

        return textoSemAcento.toLowerCase().trim();
    }
}
