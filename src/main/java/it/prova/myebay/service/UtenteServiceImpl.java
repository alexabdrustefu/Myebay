package it.prova.myebay.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.myebay.model.StatoUtente;
import it.prova.myebay.model.Utente;
import it.prova.myebay.repository.utente.UtenteRepository;
@Service
public class UtenteServiceImpl implements UtenteService{
	@Autowired
	private UtenteRepository repository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Transactional
	public void inserisciNuovo(Utente utenteInstance) {
		utenteInstance.setStato(StatoUtente.CREATO);
		utenteInstance.setPassword(passwordEncoder.encode(utenteInstance.getPassword()));
		utenteInstance.setDateCreated(LocalDate.now());
		repository.save(utenteInstance);
		
	}

	@Transactional
	public void rimuovi(Long idToDelete) {
		repository.deleteById(idToDelete);		
	}
	@Transactional
	public void aggiorna(Utente utenteInstance) {
			// deve aggiornare solo nome, cognome, username, ruoli
			Utente utenteReloaded = repository.findById(utenteInstance.getId()).orElse(null);
			if (utenteReloaded == null)
				throw new RuntimeException("Elemento non trovato");
			utenteReloaded.setNome(utenteInstance.getNome());
			utenteReloaded.setCognome(utenteInstance.getCognome());
			utenteReloaded.setUsername(utenteInstance.getUsername());
			utenteReloaded.setRuoli(utenteInstance.getRuoli());
			repository.save(utenteReloaded);
		
	}

}
