package com.dio.live.controler;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho criarJornadaTrabalho(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.salvarJornadaTrabalho(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> pegarTodasJornadaTrabalho(){
        return jornadaService.pegarTodasJornadaTrabalho();
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> pegarJornadaTrabalhoPorId (@PathVariable("idJornada") long idJornada) throws NoSuchElementException {
        return ResponseEntity.ok(jornadaService.pegarJornadaTrabalhoPorId(idJornada));
    }

    @DeleteMapping("/{idJornada}")
    public void deletarJornadaTrabalhoPorId (@PathVariable("idJornada") long idJornada) {
        jornadaService.deleteJornadaTrabalhoPorId(idJornada);
    }

    @PutMapping
    public JornadaTrabalho atualizarJornadaTrabalho(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.atualizarJornadaTrabalho(jornadaTrabalho);
    }
}
