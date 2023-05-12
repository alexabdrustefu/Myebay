package it.prova.myebay.service;

import it.prova.myebay.model.Utente;

public interface UtenteService {
	public void inserisciNuovo(Utente utenteInstance);
	
	public void rimuovi(Long idToDelete);
	
	public void aggiorna(Utente utenteInstance);
	

}
