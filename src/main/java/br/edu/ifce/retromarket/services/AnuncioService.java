package br.edu.ifce.retromarket.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.edu.ifce.retromarket.entities.Anuncio;
import br.edu.ifce.retromarket.entities.Completude;
import br.edu.ifce.retromarket.repositories.AnuncioRepository;
import br.edu.ifce.retromarket.repositories.CompletudeRepository;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository anuncioRepository;

    public List<Anuncio> listarAnuncios() {
        return anuncioRepository.findAll();
    }

    public Completude criarCompletude(Completude completude) {
    return repository.save(completude);
  }
}

