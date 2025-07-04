package dio.lista_jogos.controllers;

import dio.lista_jogos.model.Genero;
import dio.lista_jogos.repository.GeneroRepository;
import dio.lista_jogos.service.GeneroService;
import dio.lista_jogos.service.dto.JogosRequestDeleteDTO;
import dio.lista_jogos.service.impl.GeneroServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
public class GeneroController {

    private GeneroServiceImpl generoService;

    Genero genero = new Genero();

    public GeneroController(GeneroServiceImpl generoService) {
        this.generoService = generoService;
    }

    @GetMapping
    public ResponseEntity<List<Genero>> listarGeneros(){
        List<Genero> generos = generoService.findAll();
        return ResponseEntity.ok(generos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> buscarPorId(@PathVariable Long id){
        genero = generoService.findById(id);
        return ResponseEntity.ok(genero);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Genero> deletarGenero(@PathVariable Long id, @RequestBody JogosRequestDeleteDTO deleteDTO){
        genero.setId(deleteDTO.getId());
        Genero removido = generoService.remover(id, genero);
        return ResponseEntity.ok(removido);
    }
}
