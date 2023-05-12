package it.prova.myebay.service;

import java.util.List;

import it.prova.myebay.model.Annuncio;

public interface AnnuncioService {
	public List<Annuncio> listAllElements();

	public Annuncio caricaSingoloElemento(Long id);
	
	public Annuncio caricaSingoloElementoEager(Long id);

	public void aggiorna(Annuncio filmInstance);

	public void inserisciNuovo(Annuncio filmInstance);

	public void rimuovi(Long idFilmToDelete);

	public List<Annuncio> findByExample(Annuncio example);

}
