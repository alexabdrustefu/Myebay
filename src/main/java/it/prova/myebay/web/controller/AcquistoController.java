package it.prova.myebay.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.prova.myebay.dto.AcquistoDTO;
import it.prova.myebay.exception.AnnuncioChiusoException;
import it.prova.myebay.exception.CreditoInsufficienteException;
import it.prova.myebay.exception.UtenteNotFoundException;
import it.prova.myebay.model.Acquisto;
import it.prova.myebay.service.AcquistoService;

@Controller
@RequestMapping("/acquisto")
public class AcquistoController {

	@Autowired
	private AcquistoService acquistoService;

	@GetMapping("/listaacquisti")
	public String gestioneAcquisti(Model model) {
		try {
			List<Acquisto> acquisti = acquistoService.gestioneAcquisti();
			List<AcquistoDTO> acquistiDTO = AcquistoDTO.createAcquistoDTOListFromModelList(acquisti);
			model.addAttribute("acquisto_list_attr", acquistiDTO);
		} catch (UtenteNotFoundException e) {
			// Gestire l'eccezione se l'utente non viene trovato
			// Esempio: model.addAttribute("errorMessage", "Utente non trovato");
			return "/error"; // Pagina di errore appropriata
		}
		return "/acquisto/list";
	}

	@PostMapping("/compra")
	public String compra(Long idAnnuncio, RedirectAttributes redirectAttrs) {
		try {
			acquistoService.registraAcquisto(idAnnuncio);
			redirectAttrs.addFlashAttribute("successMessage", "Acquisto effettuato.");
		} catch (AnnuncioChiusoException e) {
			redirectAttrs.addFlashAttribute("errorMessage",
					"Questo articolo è già stato acquistato da un altro utente.");
			return "redirect:/annuncio";
		} catch (UtenteNotFoundException e) {
			redirectAttrs.addFlashAttribute("infoMessage", "Prima di acquistare, effettua il login.");
			return "redirect:/login";
		} catch (CreditoInsufficienteException e) {
			redirectAttrs.addFlashAttribute("errorMessage", "Credito insufficiente.");
			return "redirect:/annuncio/show/" + String.valueOf(idAnnuncio);
		}

		return "redirect:/acquisto/listaacquisti";
	}

}