package it.prova.myebay.service;

import java.util.List;

import it.prova.myebay.model.Categoria;


public interface CategoriaService {
public List<Categoria> listAll() ;
	
	public Categoria caricaSingoloElemento(Long id) ;

	public void aggiorna(Categoria categoriaInstance) ;

	public void inserisciNuovo(Categoria ruoloInstance) ;

	public void rimuovi(Long idToDelete) ;

	public Categoria cercaPerDescrizione(String descrizione) ;


}
