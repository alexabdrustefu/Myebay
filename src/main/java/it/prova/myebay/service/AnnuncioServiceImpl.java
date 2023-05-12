package it.prova.myebay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.myebay.model.Annuncio;
import it.prova.myebay.repository.annuncio.AnnuncioRepository;
@Service
public class AnnuncioServiceImpl implements AnnuncioService {
	@Autowired
	private AnnuncioRepository repository;
	@Transactional(readOnly = true)
	public List<Annuncio> listAllElements() {
		return (List<Annuncio>) repository.findAll();
	}

	@Transactional(readOnly = true)
	public Annuncio caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional(readOnly = true)
	public Annuncio caricaSingoloElementoEager(Long id) {
		return repository.findSingleFilmEager(id);
	}

	@Transactional(readOnly = true)
	public void aggiorna(Annuncio filmInstance) {
		repository.save(filmInstance);
	}

	@Transactional(readOnly = true)
	public void inserisciNuovo(Annuncio filmInstance) {
		repository.save(filmInstance);
		
	}

	@Transactional(readOnly = true)
	public void rimuovi(Long idFilmToDelete) {
		repository.deleteById(idFilmToDelete);		
	}

	@Transactional(readOnly = true)
	public List<Annuncio> findByExample(Annuncio example) {
		return this.listAllElements();
	}

}
