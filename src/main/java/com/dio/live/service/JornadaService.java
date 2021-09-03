package com.dio.live.service;

import com.dio.live.model.JornadaTrabalho;
import com.dio.live.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class JornadaService {

    JornadaRepository jornadaRepository;

    @Autowired
    public JornadaService(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }
//  CREATE
    public JornadaTrabalho salvarJornadaTrabalho(JornadaTrabalho jornadaTrabalho){
        return jornadaRepository.save(jornadaTrabalho);
    }
//  GET ALL
    public List<JornadaTrabalho> pegarTodasJornadaTrabalho(){
        return jornadaRepository.findAll();
    }
//  GET BY ID
    public JornadaTrabalho pegarJornadaTrabalhoPorId(long id) throws NoSuchElementException{
        Optional<JornadaTrabalho> jornadaTrabalhoOptional=jornadaRepository.findById(id);
        return jornadaTrabalhoOptional.orElseThrow(() -> new NoSuchElementException("Jornada não Encontrada"));
    }
//  UPDATE
    public JornadaTrabalho atualizarJornadaTrabalho(JornadaTrabalho jornadaTrabalho){
        return jornadaRepository.save(jornadaTrabalho);
    }
//  DELETE
    public void deleteJornadaTrabalhoPorId(long id){
        try {
            jornadaRepository.deleteById(id);
        }catch (Exception e){
            e.getMessage();
        }
    }
}
