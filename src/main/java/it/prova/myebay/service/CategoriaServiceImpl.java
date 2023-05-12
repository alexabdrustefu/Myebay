package it.prova.myebay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.myebay.model.Categoria;
import it.prova.myebay.repository.categoria.CategoriaRepository;
@Service
public class CategoriaServiceImpl implements CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Transactional(readOnly = true)

	public List<Categoria> listAll() {
		return(List<Categoria>)categoriaRepository.findAll();
	}

	@Transactional(readOnly = true)

	public Categoria caricaSingoloElemento(Long id) {
		return categoriaRepository.findById(id).orElse(null);
	}

	@Transactional
	public void aggiorna(Categoria categoriaInstance) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	public void inserisciNuovo(Categoria ruoloInstance) {
		categoriaRepository.save(ruoloInstance); 
		
	}

	@Transactional
	public void rimuovi(Long idToDelete) {
		// TODO Auto-generated method stub
		
	}

	@Transactional(readOnly = true)
	public Categoria cercaPerDescrizione(String descrizione) {
		return categoriaRepository.findByDescrizione(descrizione);
	}
	

}
